package com.example.wasooli_aab.employee;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.customer.AddEditCustomerActivity;
import com.example.wasooli_aab.customer.CustomerActivity;
import com.example.wasooli_aab.customer.RVCustomerAdapter;
import com.example.wasooli_aab.dummyList.DummyListModel;
import com.example.wasooli_aab.dummyList.DummyListModelHolder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class EmployeeActivity extends AppCompatActivity {
    private static final int ADD_DATA_REQUEST = 1;
    RVEmployeeAdapter adapter;
    private ArrayList<DummyListModel> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_employee);

        // Hooks
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton fabAddData = findViewById(R.id.fBtn_add);

        // Launch AddDataActivity
        fabAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeeActivity.this, AddEditEmployeeActivity.class);
                startActivityForResult(intent, ADD_DATA_REQUEST);
            }
        });


        // Get the dummy data list
        dataList = DummyListModelHolder.getInstance().getDummyList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Create and set the adapter
        adapter = new RVEmployeeAdapter(EmployeeActivity.this,dataList);
        recyclerView.setAdapter(adapter);

        // Attach swipe-to-delete functionality
        ItemTouchHelper.Callback callback = new SwipeToDeleteCallback(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);




    }

    // Handle the result from AddDataActivity
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_DATA_REQUEST && resultCode == RESULT_OK && data != null) {
            DummyListModel updatedData = (DummyListModel) data.getSerializableExtra("updatedData");
            DummyListModel newData = (DummyListModel) data.getSerializableExtra("newData");

            Log.e("updatedMsg" , "updated data " + updatedData);
            Log.e("updatedMsg" , "New  data " + newData);
            if (updatedData != null) {
                // Find and update existing data
                for (int i = 0; i < dataList.size(); i++) {
                    if (dataList.get(i).getId() == updatedData.getId()) {
                        Toast.makeText(this, "id = " + updatedData.getId(), Toast.LENGTH_SHORT).show();
                        dataList.set(i, updatedData);
                        break;
                    }
                }
            } else if (newData != null) {
                // Add new data to your existing list
                dataList.add(newData);
            }

            // Notify the adapter
            adapter.notifyDataSetChanged();
        }
    }
}