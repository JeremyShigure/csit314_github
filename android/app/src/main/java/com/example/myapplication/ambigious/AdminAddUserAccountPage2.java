//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//public class AdminAddUserAccountPage2 extends AppCompatActivity {
//    Button backButton;
//    Button createButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_admin_add_user_account_page2);
//
//        Intent intent = getIntent();
//
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
//            backButton = (Button) findViewById(R.id.backButton);
//            createButton = (Button) findViewById(R.id.createButton);
//
//        } catch (NullPointerException exc) {
//            exc.printStackTrace();
//        }
//    }
//
//    private void setListenerForViews() {
//        backButton.setOnClickListener(myListener);
//        createButton.setOnClickListener(myListener);
//    }
//
//    View.OnClickListener myListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            if (view == createButton)
//                AdminViewPatientSummary();
//            if (view == backButton)
//                goBack();
//        }
//    };
//
//    public void AdminViewPatientSummary() {
//        Intent intent = new Intent(AdminAddUserAccountPage2.this, SummaryOfAccountAdded.class);
//        startActivity(intent);
//    }
//
//    public void goBack() {
//        Intent intent = new Intent(AdminAddUserAccountPage2.this, AdminAddUserAccount.class);
//        startActivity(intent);
//    }
//}