package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class doctorViewPrescriptionUI extends AppCompatActivity {

    Button upsbthButton2;
    Button upsearchButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view_patient_prescription);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            upsbthButton2 = (Button) findViewById(R.id.upsbthButton2);
            upsearchButton2 = (Button) findViewById(R.id.upsearchButton2);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        upsbthButton2.setOnClickListener(myListener);
        upsearchButton2.setOnClickListener(myListener);

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
        Intent intent = new Intent(doctorViewPrescriptionUI.this, DoctorViewPatientPrescriptionPage2.class);
        startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(doctorViewPrescriptionUI.this, DoctorMainPage.class);
        startActivity(intent);
    }
}