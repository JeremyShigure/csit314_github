package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Controller.PrescriptionController;
import com.example.myapplication.Entity.PatientD;

import java.util.ArrayList;

public class doctorViewPrescriptionUI extends AppCompatActivity {

    Button upsbthButton2;
    Button upsearchButton2;
    EditText prescriptionID;
    PrescriptionController prescriptionController;

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
            prescriptionID = (EditText)findViewById(R.id.vppidTextBox2);
            prescriptionController = new PrescriptionController();

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        upsbthButton2.setOnClickListener(myListener);
        upsearchButton2.setOnClickListener(myListener);
        prescriptionID.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == upsearchButton2) {
                boolean isValidate = prescriptionController.checkPrescriptionID(prescriptionID.getText().toString());

                if (isValidate) {
                    ArrayList<PatientD> p1 = prescriptionController.viewController(prescriptionID.getText().toString());

                    OpenViewPatientPrescription(p1);

                    Toast.makeText(doctorViewPrescriptionUI.this, "Viewing " + prescriptionID.getText().toString() + " data now!!", Toast.LENGTH_LONG).show();

                    //Clear everytime when open
                    p1.clear();
                }
                else {
                    Toast.makeText(doctorViewPrescriptionUI.this, "Data not found!!", Toast.LENGTH_LONG).show();
                }
            }
            if (view == upsbthButton2) {
                goHome();
            }

        }
    };

    public void OpenViewPatientPrescription(ArrayList<PatientD> p1) {
        Intent intent = new Intent(doctorViewPrescriptionUI.this, DoctorViewPatientPrescriptionPage2.class);
        intent.putExtra("p_list", p1);
        startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(doctorViewPrescriptionUI.this, DoctorMainPage.class);
        startActivity(intent);
    }
}