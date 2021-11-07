//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//
//public class AdminViewPharmacistAccount extends AppCompatActivity {
//    Button b6;
//    Button b10;
//    EditText editTextP;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_admin_view_pharmacist_account);
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
//            b6 = (Button) findViewById(R.id.b6);
//            b10 = (Button) findViewById(R.id.b10);
//            editTextP = (EditText) findViewById(R.id.editTextP);
//
//        } catch (NullPointerException exc) {
//            exc.printStackTrace();
//        }
//    }
//
//    private void setListenerForViews() {
//        b6.setOnClickListener(myListener);
//        b10.setOnClickListener(myListener);
//        editTextP.setOnClickListener(myListener);
//    }
//
//    View.OnClickListener myListener = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            if (view == b6)
//                AdminViewPharmacistSummary();
//            if (view == b10)
//                goHome();
//        }
//    };
//
//    public void AdminViewPharmacistSummary() {
//        String getEditTextP = editTextP.getText().toString();
//        Intent intent = new Intent(AdminViewPharmacistAccount.this, AdminViewPharmacistSummary.class);
//        intent.putExtra("editTextP", getEditTextP);
//        startActivity(intent);
//    }
//
//    public void goHome() {
//        Intent intent = new Intent(AdminViewPharmacistAccount.this, AdminMainPage.class);
//        startActivity(intent);
//    }
//}
