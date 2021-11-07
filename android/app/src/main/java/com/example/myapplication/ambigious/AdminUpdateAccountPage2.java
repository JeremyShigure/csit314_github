//package com.example.myapplication.ambigious;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//import com.example.myapplication.Boundary.AdminUpdateUserUI;
//import com.example.myapplication.Boundary.SummaryOfUpdatedAccount;
//import com.example.myapplication.R;
//
//public class AdminUpdateAccountPage2 extends AppCompatActivity {
//    Button uabackButton2;
//    Button createButton;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_admin_update_account_page2);
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
//            uabackButton2 = (Button) findViewById(R.id.uabackButton2);
//            createButton = (Button) findViewById(R.id.createButton);
//
//        } catch (NullPointerException exc) {
//            exc.printStackTrace();
//        }
//    }
//
//    private void setListenerForViews() {
//        uabackButton2.setOnClickListener(myListener);
//        createButton.setOnClickListener(myListener);
//    }
//
//    View.OnClickListener myListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            if (view == createButton)
//                AdminViewPatientSummary();
//            if (view == uabackButton2)
//                goBack();
//        }
//    };
//
//    public void AdminViewPatientSummary() {
//        Intent intent = new Intent(AdminUpdateAccountPage2.this, SummaryOfUpdatedAccount.class);
//        startActivity(intent);
//    }
//
//    public void goBack() {
//        Intent intent = new Intent(AdminUpdateAccountPage2.this, AdminUpdateUserUI.class);
//        startActivity(intent);
//    }
//}