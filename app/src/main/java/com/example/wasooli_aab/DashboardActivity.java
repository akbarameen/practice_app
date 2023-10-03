package com.example.wasooli_aab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wasooli_aab.Delivery.DeliveryActivity;
import com.example.wasooli_aab.customer.CustomerActivity;
import com.example.wasooli_aab.employee.EmployeeActivity;
import com.example.wasooli_aab.newCustomers.CustomersActivity;
import com.example.wasooli_aab.vendor.VendorActivity;
import com.google.android.material.navigation.NavigationView;


public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView menuIcon;
    LinearLayout contentView;
    static final float END_SCALE = 0.7f;


    // search view
    TextView searchText;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        menuIcon = findViewById(R.id.img_btn_menu);
        contentView = findViewById(R.id.content);
        searchText = findViewById(R.id.searchText);
        searchView = findViewById(R.id.searchView);

        // searchView
        searchText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchText.setVisibility(View.GONE);
                searchView.setVisibility(View.VISIBLE);
                searchView.setIconified(false);
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Implement your search logic here using the 'query' variable
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Implement any live searching logic here if needed
                return true;
            }
        });


        // NavigationView Drawer Method
        navigationDrawer();


    }

    private void navigationDrawer() {
        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }
    private void animateNavigationDrawer() {
        //Add any color or remove it to use the default one!
        //To make it transparent use Color.Transparent in side setScrimColor();
        //drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Intent intent = new Intent(DashboardActivity.this, HomeActivity.class);
            drawerLayout.closeDrawer(GravityCompat.START);
            startActivity(intent);
        } else if (id == R.id.nav_customer) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(DashboardActivity.this, CustomerActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_customers) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(DashboardActivity.this, CustomersActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_employee) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(DashboardActivity.this, EmployeeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_vendor) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(DashboardActivity.this, VendorActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_delivery) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(DashboardActivity.this, DeliveryActivity.class);
            startActivity(intent);
        }else if (id == R.id.nav_profile) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(this, "Profile is clicked", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("STARTED_FROM_DASHBOARD", true);
            startActivity(intent);
//            finish();
        }
        return true;
    }

    // This method is called when the search text is clicked (defined in XML)
    public void onSearchTextClick(View view) {
        searchText.setVisibility(View.GONE);
        searchView.setVisibility(View.VISIBLE);
        menuIcon.setVisibility(View.GONE);
        searchView.setIconified(false);
    }

}