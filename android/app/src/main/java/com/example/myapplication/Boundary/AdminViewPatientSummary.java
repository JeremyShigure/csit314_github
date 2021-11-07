package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Boundary.R;

public class AdminViewPatientSummary extends AppCompatActivity {

    Button button11;
    Button button12;
    TextView roles, editTextP, address, contactNum, emailHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_patient_summary);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();

        Intent intent = getIntent();
        String getRoles = intent.getStringExtra("editTextP");

        editTextP.setText(getRoles);
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            button11 = (Button) findViewById(R.id.button11);
            button12 = (Button) findViewById(R.id.button12);
            roles = (TextView) findViewById(R.id.roles);
            editTextP = (TextView) findViewById(R.id.name);
            address = (TextView) findViewById(R.id.address);
            contactNum = (TextView) findViewById(R.id.contactNum);
            emailHere = (TextView) findViewById(R.id.emailHere);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        button11.setOnClickListener(myListener);
        button12.setOnClickListener(myListener);
        roles.setOnClickListener(myListener);
        editTextP.setOnClickListener(myListener);
        address.setOnClickListener(myListener);
        contactNum.setOnClickListener(myListener);
        emailHere.setOnClickListener(myListener);

    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == button12)
                goHome();
            if (view == button11)
                AdminViewAccounts();
        }
    };

    public void goHome() {
        Intent intent = new Intent(AdminViewPatientSummary.this, AdminMainPage.class);
        startActivity(intent);
    }

    public void AdminViewAccounts() {
        Intent intent = new Intent(AdminViewPatientSummary.this, AdminSearchUserUI.class);
        startActivity(intent);
    }
}