package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class ViewPrescriptionStatus extends AppCompatActivity {

    Button searchButton;
    Button button9;
    Button vppbthButton;

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
            //button9 = (Button) findViewById(R.id.button9);
            vppbthButton = (Button) findViewById(R.id.vppbthButton);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        searchButton.setOnClickListener(myListener);
        //button9.setOnClickListener(myListener);
        vppbthButton.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == searchButton) {
                PharmacistViewPatientPrescriptionStatusPage2();
            }
//            if (view == button9) {
//                PharmacistViewPatientPrescriptionStatusPage2();
//            }
            if (view == vppbthButton) {
                goHome();
            }
        }
    };

    public void PharmacistViewPatientPrescriptionStatusPage2() {
        Intent intent = new Intent(ViewPrescriptionStatus.this, PharmacistViewCurrentPrescriptionStatus.class);
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