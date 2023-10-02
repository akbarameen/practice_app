package com.example.wasooli_aab.Delivery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.wasooli_aab.R;

public class DeliveryDetailsActivity extends AppCompatActivity {

    CardView btnDelivery, btnPay;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_details);

        btnDelivery = findViewById(R.id.card_delivery);
        btnPay = findViewById(R.id.card_pay);

        btnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deliveryDialog();
            }
        });

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                payDialog();
            }
        });
    }

    public void deliveryDialog(){

    }
    public void payDialog(){

    }
}