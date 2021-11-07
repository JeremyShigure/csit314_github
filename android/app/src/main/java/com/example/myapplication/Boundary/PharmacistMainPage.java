package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class PharmacistMainPage extends AppCompatActivity {

    Button vppButton;
    Button vpsButton;
    Button vppButton4;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_main_page);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            vppButton = (Button) findViewById(R.id.vppButton);
            vpsButton = (Button) findViewById(R.id.vpsButton);
            vppButton4 = (Button) findViewById(R.id.vppButton4);
            logoutButton = (Button) findViewById(R.id.logoutButton);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        vppButton.setOnClickListener(myListener);
        vpsButton.setOnClickListener(myListener);
        vppButton4.setOnClickListener(myListener);
        logoutButton.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == vppButton) {
                PharmacistViewPatientPrescription();
            }
            if (view == vpsButton) {
                PharmacistUpdatePrescriptionStatus();
            }
            if (view == vppButton4) {
                PharmacistViewUpdatedPrescriptionStatus();
            }
            if (view == logoutButton) {
                logout();
            }
        }
    };

    public void PharmacistViewPatientPrescription() {
        Intent intent = new Intent(PharmacistMainPage.this, PharmacistViewPrescriptionUI.class);
        startActivity(intent);
    }

    public void PharmacistUpdatePrescriptionStatus() {
        Intent intent = new Intent(PharmacistMainPage.this, ViewPrescriptionStatus.class);
        startActivity(intent);
    }

    public void PharmacistViewUpdatedPrescriptionStatus() {
        Intent intent = new Intent(PharmacistMainPage.this, PharmacistUpdatePrescriptionStatusUI.class);
        startActivity(intent);
    }

    public void logout() {
        Intent intent = new Intent(PharmacistMainPage.this, UserLoginPage.class);
        startActivity(intent);
    }

}