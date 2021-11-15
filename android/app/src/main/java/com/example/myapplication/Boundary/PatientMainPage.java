package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;
import com.example.myapplication.Controller.PrescriptionController;
import com.example.myapplication.Entity.PatientD;
import com.example.myapplication.Entity.People;

import java.util.ArrayList;

public class PatientMainPage extends AppCompatActivity {

    Button button2;
    Button vmpButton;
    PrescriptionController prescriptionController;

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
            prescriptionController = new PrescriptionController();

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
            Intent intent = getIntent();
            String getUserName = intent.getStringExtra("userName");

            //prescriptionController.viewController(getUserName);


            String getPatID = intent.getStringExtra(getUserName);
            if (view == vmpButton) {

                ArrayList<PatientD> p1 = prescriptionController.viewControllerPatient(getUserName);

                patientViewPrescriptionUI(p1);
            }
            if (view == button2) {
                logout();
            }
        }
    };

    public void patientViewPrescriptionUI(ArrayList<PatientD> p1) {
        Intent intent = new Intent(PatientMainPage.this, patientViewPrescriptionUI.class);
        intent.putExtra("p_list", p1);
        startActivity(intent);
    }

    public void logout() {
        Intent intent = new Intent(PatientMainPage.this, UserLoginPage.class);
        startActivity(intent);
    }
}

