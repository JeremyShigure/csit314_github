package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class doctorSearchThenAddUpdate extends AppCompatActivity {

    Button addButton;
    Button delButton;
    Button upsbthButton3;
    Button upsearchButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_update_prescription);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            addButton = (Button) findViewById(R.id.addButton);
            delButton = (Button) findViewById(R.id.delButton);
            upsbthButton3 = (Button) findViewById(R.id.upsbthButton3);
            upsearchButton3 = (Button) findViewById(R.id.upsearchButton3);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        addButton.setOnClickListener(myListener);
        delButton.setOnClickListener(myListener);
        upsbthButton3.setOnClickListener(myListener);
        upsearchButton3.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == upsearchButton3){
                OpenViewPatientPrescription();
            }
            if (view == addButton) {
                DoctorAddPrescription();
            }
            if (view == delButton) {
                DoctorDeletePrescription();
            }
            if (view == upsbthButton3) {
                goHome();
            }
        }
    };

    public void OpenViewPatientPrescription() {
        Intent intent = new Intent(doctorSearchThenAddUpdate.this, DoctorViewUpdatedPatientPrescription.class);
        startActivity(intent);
    }

    public void DoctorAddPrescription() {
        Intent intent = new Intent(doctorSearchThenAddUpdate.this, doctorAddPrescriptionUI.class);
        startActivity(intent);
    }

    public void DoctorDeletePrescription() {
        Intent intent = new Intent(doctorSearchThenAddUpdate.this, doctorUpdatePrescriptionUI.class);
        startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(doctorSearchThenAddUpdate.this, DoctorMainPage.class);
        startActivity(intent);
    }


}