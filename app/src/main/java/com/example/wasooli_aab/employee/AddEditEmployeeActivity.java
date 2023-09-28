package com.example.wasooli_aab.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wasooli_aab.R;
import com.example.wasooli_aab.dummyList.DummyListModel;

import java.util.Calendar;

public class AddEditEmployeeActivity extends AppCompatActivity {
    DummyListModel editData = new DummyListModel();
    EditText editTextName,editTextAddress,editTextCellPhone,editTextDate;
    Button btnAddEdit;
    TextView title;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_employee);

        //Hooks
        editTextName = findViewById(R.id.edt_name);
        editTextAddress = findViewById(R.id.edt_address);
        editTextCellPhone = findViewById(R.id.edt_cell);
        editTextDate = findViewById(R.id.edt_date);
        btnAddEdit = findViewById(R.id.btn_add_edit);
        title = findViewById(R.id.txt_title);
        backBtn = findViewById(R.id.img_btn_back);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // setting data in editTextViews
        gettingAndSettingData();

        // Saving data on Click
        btnAddEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addEditData();
            }
        });

    }

    private void gettingAndSettingData() {
        // Model received from previous activity
        editData = (DummyListModel) getIntent().getSerializableExtra("editData");

        //Setting values in EdtTextFields
        if (editData != null) {
            // Populate fields with existing data for editing
            editTextName.setText(editData.getName());
            editTextAddress.setText(editData.getAddress());
            editTextCellPhone.setText(editData.getCellPhone());
            editTextDate.setText(String.valueOf(editData.getA1()));
            title.setText("Update \nRecord");
            btnAddEdit.setText("Update");
        }
    }
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Handle the selected date
                        // For example, you can update a TextView to display the selected date
                        TextView tvSelectedDate = findViewById(R.id.tv_date);
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        tvSelectedDate.setText(selectedDate);
                    }
                }, year, month, day);

        datePickerDialog.show();
    }
    private void addEditData(){
        // Get the data entered by the user
        String name = editTextName.getText().toString();
        String address = editTextAddress.getText().toString();
        String cellPhone = editTextCellPhone.getText().toString();
        // Get the selected date
        TextView tvSelectedDate = findViewById(R.id.tv_date);
        String date = tvSelectedDate.getText().toString();
//        int a1 = Integer.parseInt(editTextDate.getText().toString());

        if (editData != null) {
            // Update existing data
            editData.setName(name);
            editData.setAddress(address);
            editData.setCellPhone(cellPhone);
//            editData.setDate(date);


            Log.e("updatedMsg", "name" + editData.getName());
            Log.e("updatedMsg", "quantity" + editData.getA1());

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
//            newData.setA1(date);

            // Return the new data to MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("newData", newData);
            setResult(RESULT_OK, resultIntent);

        }
        finish(); // Finish AddDataActivity
    }
}