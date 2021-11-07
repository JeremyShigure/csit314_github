package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class DoctorMainPage extends AppCompatActivity {
    Button button4;
    Button button5;
    Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_main_page);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            button4 = (Button) findViewById(R.id.button4);
            button5 = (Button) findViewById(R.id.button5);
            button7 = (Button) findViewById(R.id.button7);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        button4.setOnClickListener(myListener);
        button5.setOnClickListener(myListener);
        button7.setOnClickListener(myListener);

    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == button4) {
                OpenViewPatientPrescription();
            }
            if (view == button5) {
                OpenUpdatePatientPrescription();
            }
            if (view == button7) {
                logout();
            }
        }
    };

    public void OpenViewPatientPrescription() {
        Intent intent = new Intent(DoctorMainPage.this, doctorViewPrescriptionUI.class);
        startActivity(intent);
    }

    public void OpenUpdatePatientPrescription() {
        Intent intent = new Intent(DoctorMainPage.this, doctorSearchThenAddUpdate.class);
        startActivity(intent);
    }

    public void logout() {
        Intent intent = new Intent(DoctorMainPage.this, UserLoginPage.class);
        startActivity(intent);
    }
}