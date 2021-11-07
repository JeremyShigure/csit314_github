package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class PatientMainPage extends AppCompatActivity {

    Button button2;
    Button vmpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_main_page);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            vmpButton = (Button) findViewById(R.id.vmpButton);
            button2 = (Button) findViewById(R.id.button2);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        vmpButton.setOnClickListener(myListener);
        button2.setOnClickListener(myListener);

    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == vmpButton)
                OpenViewPatientPrescription();
            if (view == button2)
                logout();
        }
    };

    public void OpenViewPatientPrescription() {
        Intent intent = new Intent(PatientMainPage.this, patientViewPrescriptionUI.class);
        startActivity(intent);
    }

    public void logout() {
        Intent intent = new Intent(PatientMainPage.this, UserLoginPage.class);
        startActivity(intent);
    }
}

