//package com.example.myapplication.Boundary;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.example.myapplication.R;
//
//public class PharmacistViewPatientPrescriptionStatusPage2 extends AppCompatActivity {
//
//    Button button13;
//    Button button14;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pharmacist_view_patient_prescription_status_page2);
//
//        // Get UI references
//        findViewsById();
//
//        // Set listener for the Views (like ImageView, TextView, Button, etc)
//        setListenerForViews();
//    }
//
//    private void findViewsById() {
//
//        try {
//            /* Get a reference for each button */
//            button13 = (Button) findViewById(R.id.button13);
//            button14 = (Button) findViewById(R.id.button14);
//
//        } catch (NullPointerException exc) {
//            exc.printStackTrace();
//        }
//    }
//
//    private void setListenerForViews() {
//        button13.setOnClickListener(myListener);
//        button14.setOnClickListener(myListener);
//
//    }
//
//    View.OnClickListener myListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            if (view == button13)
//                OpenViewPatientPrescription();
//            if (view == button14)
//                goHome();
//        }
//    };
//
//    public void OpenViewPatientPrescription() {
//        Intent intent = new Intent(PharmacistViewPatientPrescriptionStatusPage2.this, PharmacistViewUpdatedToYesPage.class);
//        startActivity(intent);
//    }
//
//    public void goHome() {
//        Intent intent = new Intent(PharmacistViewPatientPrescriptionStatusPage2.this, PharmacistMainPage.class);
//        startActivity(intent);
//    }
//}