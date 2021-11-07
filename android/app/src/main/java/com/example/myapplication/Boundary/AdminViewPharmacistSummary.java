package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class AdminViewPharmacistSummary extends AppCompatActivity {

    Button button11;
    Button button12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_pharmacist_summary);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            button11 = (Button) findViewById(R.id.button11);
            button12 = (Button) findViewById(R.id.button12);

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
                AdminViewPharmacistAccount();
            if (view == button12)
                goHome();
        }
    };

    public void AdminViewPharmacistAccount() {
        Intent intent = new Intent(AdminViewPharmacistSummary.this, AdminSearchUserUI.class);
        startActivity(intent);
    }

    public void goHome() {
        Intent intent = new Intent(AdminViewPharmacistSummary.this, AdminMainPage.class);
        startActivity(intent);
    }
}