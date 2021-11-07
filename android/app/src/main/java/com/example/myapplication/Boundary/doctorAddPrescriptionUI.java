package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class doctorAddPrescriptionUI extends AppCompatActivity {

    Button upsbthButton4;
    Button button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_add_prescription_ui);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            upsbthButton4 = (Button) findViewById(R.id.upsbthButton4);
            button8 = (Button) findViewById(R.id.button8);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        upsbthButton4.setOnClickListener(myListener);
        button8.setOnClickListener(myListener);

    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == upsbthButton4)
                goBack();
            if (view == button8)
                DoctorViewPatientPrescription();
        }
    };

    public void DoctorViewPatientPrescription() {
        Intent intent = new Intent(doctorAddPrescriptionUI.this, doctorViewPrescriptionUI.class);
        startActivity(intent);
    }

    public void goBack() {
        Intent intent = new Intent(doctorAddPrescriptionUI.this, doctorSearchThenAddUpdate.class);
        startActivity(intent);
    }
}