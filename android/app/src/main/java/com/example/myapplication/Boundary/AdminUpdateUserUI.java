package com.example.myapplication.Boundary;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.Boundary.R;
import com.example.myapplication.Controller.UserController;

public class AdminUpdateUserUI extends AppCompatActivity {

    Spinner roles;
    Button npButton;
    EditText userName, password, address, contactNumber, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_user_ui);

        //Instantiation or variables
        npButton = (Button) findViewById(R.id.npButton);
        userName = (EditText) findViewById(R.id.useraddnameTextBox);
        password = (EditText) findViewById(R.id.useraddpassTextBox);
        roles = (Spinner) findViewById(R.id.spinner2);
        address = (EditText) findViewById(R.id.add1TextBox2);
        contactNumber = (EditText) findViewById(R.id.add1TextBox3);
        email = (EditText) findViewById(R.id.add1TextBox6);

        UserController userController = new UserController();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.roletype, R.layout.support_simple_spinner_dropdown_item);
        roles.setAdapter(adapter);

        npButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInsert = userController.CheckUpdateDetails(userName.getText().toString() ,password.getText().toString(), roles.getSelectedItem().toString(), address.getText().toString(), contactNumber.getText().toString(), email.getText().toString());
                if (isInsert) {

                    String getUserName = userName.getText().toString();
                    String getUserPassword = password.getText().toString();
                    String getUserRole = roles.getSelectedItem().toString();
                    String getUserAddress = address.getText().toString();
                    String getUserContactNo = contactNumber.getText().toString();
                    String getUserEmail = email.getText().toString();

                    Toast.makeText(AdminUpdateUserUI.this, "Data updated successfully!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AdminUpdateUserUI.this, SummaryOfUpdatedAccount.class);
                    intent.putExtra("enterName", getUserName);
                    intent.putExtra("enterPassword", getUserPassword);
                    intent.putExtra("drop", getUserRole);
                    intent.putExtra("enterAddress", getUserAddress);
                    intent.putExtra("enterContactNo", getUserContactNo);
                    intent.putExtra("enterEmail", getUserEmail);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(AdminUpdateUserUI.this, "Fail to update data!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

//    public void openPage2() {
//        Intent intent = new Intent(AdminUpdateAccount.this, SummaryOfUpdatedAccount.class);
//        startActivity(intent);
//    }
}