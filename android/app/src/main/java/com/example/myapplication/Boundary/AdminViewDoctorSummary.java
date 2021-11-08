package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication.Entity.People;
import com.example.myapplication.Boundary.R;

import java.io.Serializable;

public class AdminViewDoctorSummary extends AppCompatActivity implements Serializable {

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
        String rolesData = intent.getStringExtra("roles");
        String userNameData = intent.getStringExtra("userName");
        String addressData = intent.getStringExtra("address");
        String contactNumberData = intent.getStringExtra("contactNumber");
        String emailData = intent.getStringExtra("email");

        roles.setText(rolesData);
        userName.setText(userNameData);
        address.setText(addressData);
        contactNumber.setText(contactNumberData);
        email.setText(emailData);
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
        Intent intent = new Intent(AdminViewDoctorSummary.this, AdminSearchUserUI.class);
        startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(AdminViewDoctorSummary.this, AdminMainPage.class);
        startActivity(intent);
    }
}