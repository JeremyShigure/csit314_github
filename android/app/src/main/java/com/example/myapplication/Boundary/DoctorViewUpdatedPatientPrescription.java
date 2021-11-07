package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class DoctorViewUpdatedPatientPrescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_view_updated_patient_prescription);

        Button vmpbthButton = (Button) findViewById(R.id.backtohome);

        vmpbthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    public void goHome() {
        Intent intent = new Intent(DoctorViewUpdatedPatientPrescription.this, DoctorMainPage.class);
        startActivity(intent);
    }
}