package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Boundary.R;

public class SummaryOfAccountAdded extends AppCompatActivity {

    TextView enterName, enterPassword, drop, enterAddress, enterContactNo, enterEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_of_account_created);


        enterName = findViewById(R.id.name);
        //enterPassword = findViewById(R.id.textView54);
        drop = findViewById(R.id.roles);
        enterAddress = findViewById(R.id.address);
        enterContactNo = findViewById(R.id.contactNum);
        enterEmail = findViewById(R.id.emailHere);

        Intent intent = getIntent();
        String getUserName = intent.getStringExtra("enterName");
        //String getUserPassword = enterPassword.getText().toString();
        String getUserRole = intent.getStringExtra("drop");
        String getUserAddress = intent.getStringExtra("enterAddress");
        String getUserContactNo = intent.getStringExtra("enterContactNo");
        String getUserEmail = intent.getStringExtra("enterEmail");

        enterName.setText(getUserName);
        drop.setText(getUserRole);
        enterAddress.setText(getUserAddress);
        enterContactNo.setText(getUserContactNo);
        enterEmail.setText(getUserEmail);

        Button sumbthButton = (Button) findViewById(R.id.sumbthButton);

        sumbthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    public void goHome() {
        Intent intent = new Intent(SummaryOfAccountAdded.this, AdminMainPage.class);
        startActivity(intent);
    }
}