package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Boundary.R;

public class PharmacistViewPrescriptionUI extends AppCompatActivity {

    Button upsearchButton2;
    Button upsbthButton2;
    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_view_patient_prescription);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            upsearchButton2 = (Button) findViewById(R.id.upsearchButton2);
            upsbthButton2 = (Button) findViewById(R.id.upsbthButton2);
            userName = (EditText) findViewById(R.id.vppidTextBox2);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        upsearchButton2.setOnClickListener(myListener);
        upsbthButton2.setOnClickListener(myListener);
        userName.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == upsearchButton2)
                OpenViewPatientPrescription();
            if (view == upsbthButton2)
                goHome();
        }
    };

    public void OpenViewPatientPrescription() {
        Intent intent = new Intent(PharmacistViewPrescriptionUI.this, PharmacistViewPrescriptionSummaryUI.class);
        startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(PharmacistViewPrescriptionUI.this, PharmacistMainPage.class);
        startActivity(intent);
    }
}