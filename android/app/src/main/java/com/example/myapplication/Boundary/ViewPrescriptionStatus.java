package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Boundary.R;

public class ViewPrescriptionStatus extends AppCompatActivity {

    Button searchButton;
    EditText userName;
    Button vppbthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_view_prescription_status);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            searchButton = (Button) findViewById(R.id.searchButton);
            userName = (EditText) findViewById(R.id.vppidTextBox);
            vppbthButton = (Button) findViewById(R.id.vppbthButton);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        searchButton.setOnClickListener(myListener);
        userName.setOnClickListener(myListener);
        vppbthButton.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == searchButton) {
                PharmacistViewPatientPrescriptionStatusPage2();
            }
            if (view == vppbthButton) {
                goHome();
            }
        }
    };

    public void PharmacistViewPatientPrescriptionStatusPage2() {
        Intent intent = new Intent(ViewPrescriptionStatus.this, PharmacistViewCurrentPrescriptionStatus.class);
        startActivity(intent);
    }
//
//    public void PharmacistPressUpdateStatus() {
//        Intent intent = new Intent(PharmacistViewPrescriptionStatus.this, PharmacistPressUpdateStatus.class);
//        startActivity(intent);
//    }

    public void goHome() {
        Intent intent = new Intent(ViewPrescriptionStatus.this, PharmacistMainPage.class);
        startActivity(intent);
    }
}