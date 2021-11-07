package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Boundary.R;

public class AdminSearchUserUI extends AppCompatActivity {
    Button b6;
    Button b10;
    EditText editTextP;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_search_user_ui);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            b6 = (Button) findViewById(R.id.b6);
            b10 = (Button) findViewById(R.id.b10);
            editTextP = (EditText) findViewById(R.id.editTextP);
            db = new DBHelper(AdminSearchUserUI.this);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        b6.setOnClickListener(myListener);
        b10.setOnClickListener(myListener);
        editTextP.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            boolean checkExist = db.checkUsernameExistOrNot(editTextP.getText().toString());
//            String gettingRoleFromWhichTable = (db.returnRoleTableAfterCheck(editTextP.getText().toString(), checkExist));
//            db.checkUserExistInWhichTable(editTextP.getText().toString());
            if (view == b6) {
                if (checkExist == true) {
                    if (db.checkUserExistInWhichTable(editTextP.getText().toString()) == "Patient" || db.checkUserExistInWhichTable(editTextP.getText().toString()) == "patient") {
                        //String getEditTextP = editTextP.getText().toString();
                        Intent intent = new Intent(AdminSearchUserUI.this, AdminViewPatientSummary.class);
                        //intent.putExtra("editTextP", getEditTextP);
                        startActivity(intent);
                    }
                    else if (db.checkUserExistInWhichTable(editTextP.getText().toString()).contains("Doctor") || db.checkUserExistInWhichTable(editTextP.getText().toString()).contains("doctor")) {
                        //String getEditTextP = editTextP.getText().toString();
                        Intent intent = new Intent(AdminSearchUserUI.this, AdminViewDoctorSummary.class);
                        //intent.putExtra("editTextP", getEditTextP);
                        startActivity(intent);
                    }
                    else if (db.checkUserExistInWhichTable(editTextP.getText().toString()) == "Pharmacist" || db.checkUserExistInWhichTable(editTextP.getText().toString()) == "pharmacist") {
                        //String getEditTextP = editTextP.getText().toString();
                        Intent intent = new Intent(AdminSearchUserUI.this, AdminViewPharmacistSummary.class);
                        //intent.putExtra("editTextP", getEditTextP);
                        startActivity(intent);
                    }
                }
            }
            if (view == b10) {
                goHome();
            }
        }
    };

//    public void AdminViewAccounts(String Role) {
//        if (Role == "Doctor") {
//            AdminViewDoctorSummary();
//        }
//        if (Role == "Pharmacist") {
//            AdminViewPharmacistSummary();
//        }
//        if (Role == "Patient") {
//            AdminViewPatientSummary();
//        }
//    }

    //------------------------------------------


//    public void AdminViewDoctorSummary() {
//        String getEditTextP = editTextP.getText().toString();
//        Intent intent = new Intent(AdminViewAccounts.this, AdminViewDoctorSummary.class);
//        intent.putExtra("editTextP", getEditTextP);
//        startActivity(intent);
//    }
//
//    public void AdminViewPharmacistSummary() {
//        String getEditTextP = editTextP.getText().toString();
//        Intent intent = new Intent(AdminViewAccounts.this, AdminViewPharmacistSummary.class);
//        intent.putExtra("editTextP", getEditTextP);
//        startActivity(intent);
//    }
//
//    public void AdminViewPatientSummary() {
//        String getEditTextP = editTextP.getText().toString();
//        Intent intent = new Intent(AdminViewAccounts.this, AdminViewPatientSummary.class);
//        intent.putExtra("editTextP", getEditTextP);
//        startActivity(intent);
//    }

    public void goHome() {
        Intent intent = new Intent(AdminSearchUserUI.this, AdminMainPage.class);
        startActivity(intent);
    }
}