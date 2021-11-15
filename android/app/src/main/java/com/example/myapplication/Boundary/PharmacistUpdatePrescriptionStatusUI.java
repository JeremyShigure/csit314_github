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

public class PharmacistUpdatePrescriptionStatusUI extends AppCompatActivity {

    Button upsearchButton2;
    Button upsbthButton2;
    EditText userName;
    PrescriptionController prescriptionController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_view_updated_prescription_status);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            upsearchButton2 = (Button) findViewById(R.id.upsearchButton2);
            upsbthButton2 = (Button) findViewById(R.id.upsbthButton2);
            userName = (EditText) findViewById(R.id.vppidTextBox2);
            prescriptionController = new PrescriptionController();

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        upsearchButton2.setOnClickListener(myListener);
        upsbthButton2.setOnClickListener(myListener);
        userName.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            if (view == upsearchButton2) {

                boolean isValidate = prescriptionController.checkPrescriptionID(userName.getText().toString());

                if (isValidate) {
                    ArrayList<PatientD> p1 = prescriptionController.viewController(userName.getText().toString());

                    PharmacistViewUpdatedPrescriptionStatusPage2(p1);

                    Toast.makeText(PharmacistUpdatePrescriptionStatusUI.this, "Viewing " + userName.getText().toString() + " data now!!", Toast.LENGTH_LONG).show();

                    //Clear everytime when open
                    p1.clear();
                }
                else {
                    Toast.makeText(PharmacistUpdatePrescriptionStatusUI.this, "Data not found!!", Toast.LENGTH_LONG).show();
                }
            }
            if (view == upsbthButton2) {
                goHome();
            }
        }
    };

    public void PharmacistViewUpdatedPrescriptionStatusPage2(ArrayList<PatientD> p1) {
        Intent intent = new Intent(PharmacistUpdatePrescriptionStatusUI.this, PharmacistViewUpdatedPrescriptionStatusPage2.class);
        intent.putExtra("p_list", p1);
        startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(PharmacistUpdatePrescriptionStatusUI.this, PharmacistMainPage.class);
        startActivity(intent);
    }
}