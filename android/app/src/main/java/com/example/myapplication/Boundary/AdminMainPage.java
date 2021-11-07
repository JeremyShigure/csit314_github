package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.Boundary.R;

public class AdminMainPage extends AppCompatActivity {

    Button auapButton;
    Button uuapButton;
    Button uuapButton2;
    Button adlogoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);

        // Get UI references
        findViewsById();

        // Set listener for the Views (like ImageView, TextView, Button, etc)
        setListenerForViews();
    }

    private void findViewsById() {

        try {
            /* Get a reference for each button */
            auapButton = (Button) findViewById(R.id.auapButton);
            uuapButton = (Button) findViewById(R.id.uuapButton);
            uuapButton2 = (Button) findViewById(R.id.uuapButton2);
            adlogoutButton = (Button) findViewById(R.id.adlogoutButton);

        } catch (NullPointerException exc) {
            exc.printStackTrace();
        }
    }

    private void setListenerForViews() {
        auapButton.setOnClickListener(myListener);
        uuapButton.setOnClickListener(myListener);
        uuapButton2.setOnClickListener(myListener);
        adlogoutButton.setOnClickListener(myListener);
    }

    View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == auapButton) {
                AdminAddUserAccount();
            }
            if (view == uuapButton) {
                AdminUpdateAccount();
            }
            if (view == uuapButton2) {
                AdminViewOneAccount();
            }
            if (view == adlogoutButton) {
                logout();
            }
        }
    };

    public void AdminAddUserAccount() {
        Intent intent = new Intent(AdminMainPage.this, AdminAddUserUI.class);
        startActivity(intent);
    }

    public void AdminUpdateAccount() {
        Intent intent = new Intent(AdminMainPage.this, AdminUpdateUserUI.class);
        startActivity(intent);
    }

    public void AdminViewOneAccount() {
        Intent intent = new Intent(AdminMainPage.this, AdminSearchUserUI.class);
        startActivity(intent);
    }

    public void logout() {
        Intent intent = new Intent(AdminMainPage.this, UserLoginPage.class);
        startActivity(intent);
    }

}