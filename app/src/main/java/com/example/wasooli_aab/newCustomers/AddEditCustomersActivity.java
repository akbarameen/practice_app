package com.example.wasooli_aab.newCustomers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.wasooli_aab.R;

public class AddEditCustomersActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CustomerPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_customers);

        viewPager = findViewById(R.id.viewPager);

        adapter = new CustomerPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AddCustomersFragment1());
        adapter.addFragment(new AddCustomersFragment2());
        adapter.addFragment(new AddCustomersFragment3());

        viewPager.setAdapter(adapter);
    }

    public void nextFragment() {
        if (viewPager.getCurrentItem() < adapter.getCount() - 1) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public void previousFragment() {
        if (viewPager.getCurrentItem() > 0) {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }
}