package com.example.wasooli_aab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wasooli_aab.adapters.RVHomeAdapter;
import com.example.wasooli_aab.models.HomeModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    //recyclerView
    FloatingActionButton fBtnAdd;
    RecyclerView recyclerView;
    RVHomeAdapter adapter;
    ArrayList<HomeModel> homeModelArrayList = new ArrayList<>();

    // Add and edit
    EditText edtName,edtAddress, edtCell,edtAmount, edtDate, edtA1,edtB1, edtC1, edtD1;

    String name, address, cell, date, b1, c1, d1;
    int amount, a1;
    private int mYear, mMonth, mDay, mHour, mMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerView);
        fBtnAdd = findViewById(R.id.fBtn_add);

        //
        fBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(HomeActivity.this, AddEditActivity.class));
                addDataDialog();            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String date = null;
        LocalDateTime now = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            now = LocalDateTime.now();
            date = dtf.format(now);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            homeModelArrayList.add(new HomeModel(1, "Akbar a", "Karachi", "923017712517", 122, now, 122, "qwewe", date, date));
            homeModelArrayList.add(new HomeModel(2, "Akbar b", "lahore", "923017712517", 122, now, 122, "qwewe", date, date));
            homeModelArrayList.add(new HomeModel(3, "Akbar c", "peshawar", "923017712517", 122, now, 122, "qwewe", date, date));
            homeModelArrayList.add(new HomeModel(4, "Akbar d", "multan", "923017712517", 122, now, 122, "qwewe", date, date));
        }

        adapter = new RVHomeAdapter(this,homeModelArrayList);
        recyclerView.setAdapter(adapter);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            Window window = getWindow();
//            window.setStatusBarColor(R.color.primary_color); // Change to the color you want
//        }
    }

    public void addDataDialog(){
        // Dialog data

        final Dialog dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.add_edit_dialog);

        // Getting IDs
        Button btnAddEdit = (Button) dialog.findViewById(R.id.btn_action);
        // Hooks
        edtName = dialog.findViewById(R.id.edt_name);
        edtAddress = dialog.findViewById(R.id.edt_address);
        edtCell = dialog.findViewById(R.id.edt_cell);
        edtAmount = dialog.findViewById(R.id.edt_amount);
        edtDate = dialog.findViewById(R.id.edt_date);
        edtA1 = dialog.findViewById(R.id.edt_a1);
        edtB1 = dialog.findViewById(R.id.edt_b1);
        edtC1 = dialog.findViewById(R.id.edt_c1);
        edtD1 = dialog.findViewById(R.id.edt_d1);

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(edtDate);
            }
        });

        edtC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(edtC1);
            }
        });
        edtD1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker(edtD1);
            }
        });
        edtDate.setFocusable(false);
        edtC1.setFocusable(false);
        edtD1.setFocusable(false);

        // Saving Data
        btnAddEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                name = Objects.requireNonNull(edtName.getText()).toString();
                address = Objects.requireNonNull(edtAddress.getText()).toString();
                cell = Objects.requireNonNull(edtCell.getText()).toString();
                amount = Integer.parseInt(Objects.requireNonNull(edtAmount.getText()).toString());
                date = Objects.requireNonNull(edtDate.getText()).toString();
                a1 = Integer.parseInt(Objects.requireNonNull(edtA1.getText()).toString());
                b1 = Objects.requireNonNull(edtB1.getText()).toString();
                c1 = Objects.requireNonNull(edtC1.getText()).toString();
                d1 = Objects.requireNonNull(edtD1.getText()).toString();



                homeModelArrayList.add(new HomeModel(name,address,cell,amount,date,a1,b1,c1,d1));

                Toast.makeText(HomeActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();

                // Intent intent = new Intent(TaskOne.this, TaskOne.class);
                // startActivity(intent);
                edtName.setText("");
                edtAddress.setText("");


                adapter.notifyItemChanged(homeModelArrayList.size() -1);
                recyclerView.scrollToPosition(homeModelArrayList.size()-1);


                dialog.dismiss();


            }
        });
        dialog.show();
    }


    private void datePicker(TextView textView){
        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(HomeActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                textView.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
            }

        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

}