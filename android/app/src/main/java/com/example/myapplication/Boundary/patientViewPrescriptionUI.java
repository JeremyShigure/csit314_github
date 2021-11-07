package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class patientViewPrescriptionUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_view_prescription);


        Button button16 = (Button) findViewById(R.id.button16);

        button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    public void goHome() {
        Intent intent = new Intent(patientViewPrescriptionUI.this, PatientMainPage.class);
        startActivity(intent);
    }
}
//        view = findViewById(R.id.xxxxxxxx);
//
//        @Override
//        public void onClick(View v) {
//            String pres = Prescriptino.getText().toString();
//            String quantity = qty.getText().toString();
//            String DATE = Date.getText().toString();
//
//        }
