package com.example.myapplication.Boundary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.widget.ArrayAdapter;
import android.widget.Spinner;

//---------------
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Controller.PrescriptionController;
import com.example.myapplication.Controller.UserController;
import com.example.myapplication.Boundary.R;
import com.example.myapplication.Entity.PatientD;

import java.util.ArrayList;

    /*
        This source code could be used for academic purposes only. Posting on other websites or blogs is only allowed with a dofollow link to the orignal content.
    */

public class UserLoginPage extends AppCompatActivity {
    // Declaring layout button, edit texts
    Button login;
    EditText userName, password;
    Spinner roles;
    PrescriptionController prescriptionController;

    DBHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.idTextBox);
        password = (EditText) findViewById(R.id.passwordTextBox);
        login = (Button) findViewById(R.id.btnLogin);
        roles = (Spinner) findViewById(R.id.spinRoles);
        prescriptionController = new PrescriptionController();

        UserController userController = new UserController();

        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.roletype, R.layout.support_simple_spinner_dropdown_item);
        roles.setAdapter(adapter);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //boolean isExist = userController.validateLogin(username.getText().toString(), password.getText().toString(), dropdownlist.getSelectedItem().toString());

                boolean isValidate = userController.checkUserExistInTheDatabaseOrNot(userName.getText().toString(), password.getText().toString(), roles.getSelectedItem().toString());

                String item;

                if (isValidate) {
                    item = roles.getSelectedItem().toString();
                    System.out.println("TTTTTTTTTTTEEEEEEEEEEEEEEEESSSSSSSSSSSSSSSSSSTTTTTTTTTTTTTTTTTTIIIIIIIIIIIINNNNNNNNNNNNNGGGGGGGGGGGG");

                    System.out.println(userName.getText().toString());
                    System.out.println(password.getText().toString());
                    System.out.println(roles.getSelectedItem().toString());

                    if (item.equals("doctor") || item.equals("Doctor")) {
                        openDoctor();
                    }
                    if (item.equals("pharmacist") || item.equals("Pharmacist")) {
                        openPharmacist();
                    }
                    if (item.equals("patient") || item.equals("Patient")) {
                        ArrayList<PatientD> p1 = prescriptionController.viewController(userName.getText().toString());

                        openPatient();
                    }
                    if (item.equals("admin") || item.equals("Admin")) {
                        openAdmin();
                    }
                    Toast.makeText(UserLoginPage.this, "Login Successfully as " + userName.getText().toString(), Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(UserLoginPage.this, "Login Failed!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    public void openDoctor() {
        Intent intent = new Intent(UserLoginPage.this, DoctorMainPage.class);
        startActivity(intent);
    }

    public void openPatient() {
        Intent intent = new Intent(UserLoginPage.this, PatientMainPage.class);
        intent.putExtra("userName", userName.getText().toString());
        startActivity(intent);
    }

    public void openPharmacist() {
        Intent intent = new Intent(UserLoginPage.this, PharmacistMainPage.class);
        startActivity(intent);
    }

    public void openAdmin() {
        Intent intent = new Intent(UserLoginPage.this, AdminMainPage.class);
        startActivity(intent);
    }
}