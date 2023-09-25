package com.example.wasooli_aab.models;

import android.os.Build;

import java.time.LocalDateTime;

public class HomeModel {
    private int id;
    private String name;
    private String address;
    private  String cellPhone;
    private int amount;
    private LocalDateTime date;
    private int a1;
    private String b1;
    private String c1;
    private String d1;

    public HomeModel(String name, String address, String cellPhone, int amount, String date, int a1, String b1, String c1, String d1) {
        this.name = name;
        this.address = address;
        this.cellPhone = cellPhone;
        this.amount = amount;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.date = LocalDateTime.parse(date);
        }
        this.a1 = a1;
        this.b1 = b1;
        this.c1 = c1;
        this.d1 = d1;
    }

    public HomeModel(int id, String name, String address, String cellPhone, int amount, LocalDateTime date, int a1, String b1, String c1, String d1) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cellPhone = cellPhone;
        this.amount = amount;
        this.date = date;
        this.a1 = a1;
        this.b1 = b1;
        this.c1 = c1;
        this.d1 = d1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getA1() {
        return a1;
    }

    public void setA1(int a1) {
        this.a1 = a1;
    }

    public String getB1() {
        return b1;
    }

    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }
}
