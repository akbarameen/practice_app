package com.example.wasooli_aab.newCustomers;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.customer.RVCustomerAdapter;
import com.example.wasooli_aab.dummyList.DummyListModel;
import com.example.wasooli_aab.dummyList.DummyListModelHolder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CustomersActivity extends AppCompatActivity {
    //RV
    private RecyclerView recyclerView;
    private RVCustomersAdapter adapter;
    private List<DummyListModel> dataList;

    FloatingActionButton fBtnAdd;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        // Assuming you have already populated dataList
        dataList = DummyListModelHolder.getInstance().getDummyList();

        recyclerView = findViewById(R.id.recyclerView);
        fBtnAdd = findViewById(R.id.fBtn_add);

        fBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomersActivity.this, AddEditCustomersActivity.class);
                startActivity(intent);
            }
        });


        //setting recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RVCustomersAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
}