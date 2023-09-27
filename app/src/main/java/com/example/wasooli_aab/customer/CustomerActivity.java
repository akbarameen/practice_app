package com.example.wasooli_aab.customer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.dummyList.DummyListModel;
import com.example.wasooli_aab.dummyList.DummyListModelHolder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CustomerActivity extends AppCompatActivity {
    private static final int ADD_DATA_REQUEST = 1;
    RVCustomerAdapter adapter;
    private ArrayList<DummyListModel> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_customer);

        // Assuming you have a RecyclerView with the id recyclerView in your activity
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

// Get the dummy data list
        dataList = DummyListModelHolder.getInstance().getDummyList();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
// Create and set the adapter
        adapter = new RVCustomerAdapter(CustomerActivity.this,dataList);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fabAddData = findViewById(R.id.fBtn_add);


// ...

// Launch AddDataActivity
        fabAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerActivity.this, AddEditCustomerActivity.class);
                startActivityForResult(intent, ADD_DATA_REQUEST);
            }
        });



    }

    // Handle the result from AddDataActivity
    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_DATA_REQUEST && resultCode == RESULT_OK && data != null) {
            DummyListModel updatedData = (DummyListModel) data.getSerializableExtra("updatedData");
            DummyListModel newData = (DummyListModel) data.getSerializableExtra("newData");

            if (updatedData != null) {
                // Find and update existing data
                for (int i = 0; i < dataList.size(); i++) {
                    if (dataList.get(i).getId() == updatedData.getId()) {
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