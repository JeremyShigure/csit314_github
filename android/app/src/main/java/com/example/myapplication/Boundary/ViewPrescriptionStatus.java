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

public class ViewPrescriptionStatus extends AppCompatActivity {

    Button searchButton;
    EditText userName;
    Button vppbthButton;
    PrescriptionController prescriptionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_view_prescription_status);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            searchButton = (Button) findViewById(R.id.searchButton);
            userName = (EditText) findViewById(R.id.vppidTextBox);
            vppbthButton = (Button) findViewById(R.id.vppbthButton);
            prescriptionController = new PrescriptionController();

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        searchButton.setOnClickListener(myListener);
        userName.setOnClickListener(myListener);
        vppbthButton.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == searchButton) {

                boolean isValidate = prescriptionController.checkPrescriptionID(userName.getText().toString());

                if (isValidate) {
                    ArrayList<PatientD> p1 = prescriptionController.viewController(userName.getText().toString());

                    PharmacistViewPatientPrescriptionStatusPage2(p1);

                    Toast.makeText(ViewPrescriptionStatus.this, "Viewing " + userName.getText().toString() + " data now!!", Toast.LENGTH_LONG).show();

                    //Clear everytime when open
                    p1.clear();
                }
                else {
                    Toast.makeText(ViewPrescriptionStatus.this, "Data not found!!", Toast.LENGTH_LONG).show();
                }

            }
            if (view == vppbthButton) {
                goHome();
            }
        }
    };

    public void PharmacistViewPatientPrescriptionStatusPage2(ArrayList<PatientD> p1) {
        Intent intent = new Intent(ViewPrescriptionStatus.this, PharmacistViewCurrentPrescriptionStatus.class);
        intent.putExtra("p_list", p1);
        startActivity(intent);
    }
//
//    public void PharmacistPressUpdateStatus() {
//        Intent intent = new Intent(PharmacistViewPrescriptionStatus.this, PharmacistPressUpdateStatus.class);
//        startActivity(intent);
//    }

    public void goHome() {
        Intent intent = new Intent(ViewPrescriptionStatus.this, PharmacistMainPage.class);
        startActivity(intent);
    }
}