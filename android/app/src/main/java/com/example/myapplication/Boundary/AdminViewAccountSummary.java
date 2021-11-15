package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Boundary.R;

import java.io.Serializable;

public class AdminViewAccountSummary extends AppCompatActivity implements Serializable {

    Button button11;
    Button button12;
    TextView roles, userName, address, contactNumber, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_doctor_summary);

        // Get UI references
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        roles = (TextView) findViewById(R.id.roles);
        userName = (TextView) findViewById(R.id.name);
        address = (TextView) findViewById(R.id.address);
        contactNumber = (TextView) findViewById(R.id.contactNum);
        email = (TextView) findViewById(R.id.emailHere);

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        Intent intent = getIntent();
        String getRoles = intent.getStringExtra("roles");
        String getUserNameData = intent.getStringExtra("userName");
        String getAddressData = intent.getStringExtra("address");
        String getContactNumberData = intent.getStringExtra("contactNumber");
        String getEmailData = intent.getStringExtra("email");

        roles.setText(getRoles);
        userName.setText(getUserNameData);
        address.setText(getAddressData);
        contactNumber.setText(getContactNumberData);
        email.setText(getEmailData);
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            button11 = (Button) findViewById(R.id.button11);
            button12 = (Button) findViewById(R.id.button12);
            roles = (TextView) findViewById(R.id.roles);
            userName = (TextView) findViewById(R.id.name);
            address = (TextView) findViewById(R.id.address);
            contactNumber = (TextView) findViewById(R.id.contactNum);
            email = (TextView) findViewById(R.id.emailHere);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        button11.setOnClickListener(myListener);
        button12.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == button11)
                AdminViewDoctorAccount();
            if (view == button12)
                goHome();
        }
    };

    public void AdminViewDoctorAccount() {
        Intent intent = new Intent(AdminViewAccountSummary.this, AdminSearchUserUI.class);
        startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(AdminViewAccountSummary.this, AdminMainPage.class);
        startActivity(intent);
    }
}