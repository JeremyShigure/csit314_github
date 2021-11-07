package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class PharmacistViewUpdatedPrescriptionStatusPage2 extends AppCompatActivity {

    Button button18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacist_view_updated_prescription_status_page2);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            button18 = (Button) findViewById(R.id.button18);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        button18.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == button18)
                OpenViewPatientPrescription();
        }
    };

    public void OpenViewPatientPrescription() {
        Intent intent = new Intent(PharmacistViewUpdatedPrescriptionStatusPage2.this, PharmacistViewUpdatedToYesPage.class);
        startActivity(intent);
    }

}