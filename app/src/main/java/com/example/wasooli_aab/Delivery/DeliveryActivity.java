package com.example.wasooli_aab.Delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.dummyList.DummyListModel;
import com.example.wasooli_aab.dummyList.DummyListModelHolder;

import java.util.ArrayList;

public class DeliveryActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DeliveryAdapter adapter;
    private ArrayList<DummyListModel> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        // Assuming you have already populated dataList
        dataList = DummyListModelHolder.getInstance().getDummyList();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new DeliveryAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
}