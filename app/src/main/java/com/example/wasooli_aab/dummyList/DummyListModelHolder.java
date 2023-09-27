package com.example.wasooli_aab.dummyList;

import java.util.ArrayList;
import java.util.Date;

public class DummyListModelHolder {
    private static DummyListModelHolder instance;
    private ArrayList<DummyListModel> dummyList;

    private DummyListModelHolder() {
        dummyList = new ArrayList<>();

        DummyListModel model1 = new DummyListModel();
        model1.setId(1);
        model1.setName("John Doe");
        model1.setAddress("123 Main Street, Anytown, USA");
        model1.setCellPhone("555-1234");
        model1.setAmount(500);
        model1.setDate(new Date());
        model1.setA1(10);
        model1.setB1("Category A");
        model1.setC1(new Date());
        model1.setD1(new Date());

        DummyListModel model2 = new DummyListModel();
        model2.setId(2);
        model2.setName("Jane Smith");
        model2.setAddress("456 Elm Street, Somewhere, USA");
        model2.setCellPhone("555-5678");
        model2.setAmount(1000);
        model2.setDate(new Date());
        model2.setA1(20);
        model2.setB1("Category B");
        model2.setC1(new Date());
        model2.setD1(new Date());

        // Add more dummy records as needed...

        dummyList.add(model1);
        dummyList.add(model2);
        // Add more models as needed...
    }

    public static DummyListModelHolder getInstance() {
        if (instance == null) {
            instance = new DummyListModelHolder();
        }
        return instance;
    }

    public ArrayList<DummyListModel> getDummyList() {
        return dummyList;
    }
}
