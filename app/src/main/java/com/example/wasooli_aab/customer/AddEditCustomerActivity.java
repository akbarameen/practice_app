package com.example.wasooli_aab.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.dummyList.DummyListModel;

public class AddEditCustomerActivity extends AppCompatActivity {
    private DummyListModel editData; // Add this field
    EditText editTextName,editTextAddress,editTextCellPhone,editTextQuantity;
    Button btnAddEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_customer);

        //Hooks
        editTextName = findViewById(R.id.edt_name);
        editTextAddress = findViewById(R.id.edt_address);
        editTextCellPhone = findViewById(R.id.edt_cell);
        editTextQuantity = findViewById(R.id.edt_quantity);
        btnAddEdit = findViewById(R.id.btn_add_edit);


        // Inside onCreate
        editData = (DummyListModel) getIntent().getSerializableExtra("editData");

        if (editData != null) {
            // Populate fields with existing data for editing
            editTextName.setText(editData.getName());
            editTextAddress.setText(editData.getAddress());
            editTextCellPhone.setText(editData.getCellPhone());
            editTextQuantity.setText(String.valueOf(editData.getA1()));
        }

        // Assume you have a button to save the data
        btnAddEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the data entered by the user
                String name = editTextName.getText().toString();
                String address = editTextAddress.getText().toString();
                String cellPhone = editTextCellPhone.getText().toString();
                int a1 = Integer.parseInt(editTextQuantity.getText().toString());

                if (editData != null) {
                    // Update existing data
                    editData.setName(name);
                    editData.setAddress(address);
                    editData.setCellPhone(cellPhone);
                    editData.setA1(a1);

                    // Return the updated data to MainActivity
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("updatedData", editData);
                    setResult(RESULT_OK, resultIntent);
                } else {
                    // Create a new DummyListModel object
                    DummyListModel newData = new DummyListModel();
                    newData.setName(name);
                    newData.setAddress(address);
                    newData.setCellPhone(cellPhone);
                    newData.setA1(a1);

                    // Return the new data to MainActivity
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra("newData", newData);
                    setResult(RESULT_OK, resultIntent);

                }
                finish(); // Finish AddDataActivity
            }
        });
    }
}