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

public class AdminAddUserUI extends AppCompatActivity {

    Spinner roles;
    Button addUserButton;
    EditText userName, password, address, contactNumber, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_user_ui);

        //myDb = new DBHelper(AdminAddUserUI.this);

        addUserButton = (Button) findViewById(R.id.npButton);
        userName = (EditText) findViewById(R.id.useraddnameTextBox);
        password = (EditText) findViewById(R.id.useraddpassTextBox);
        roles = (Spinner) findViewById(R.id.spinner2);
        address = (EditText) findViewById(R.id.add1TextBox2);
        contactNumber = (EditText) findViewById(R.id.add1TextBox3);
        email = (EditText) findViewById(R.id.add1TextBox6);

        UserController userController = new UserController();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.roletype, R.layout.support_simple_spinner_dropdown_item);
        roles.setAdapter(adapter);

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInsert = userController.CheckAddedDetails(userName.getText().toString(), password.getText().toString(), roles.getSelectedItem().toString(), address.getText().toString(), contactNumber.getText().toString(), email.getText().toString());
                if (isInsert) {

                    String getUserName = userName.getText().toString();
                    String getUserPassword = password.getText().toString();
                    String getUserRole = roles.getSelectedItem().toString();
                    String getUserAddress = address.getText().toString();
                    String getUserContactNo = contactNumber.getText().toString();
                    String getUserEmail = email.getText().toString();

                    Toast.makeText(AdminAddUserUI.this, "Data inserted successfully!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(AdminAddUserUI.this, SummaryOfAccountAdded.class);
                    intent.putExtra("enterName", getUserName);
                    intent.putExtra("enterPassword", getUserPassword);
                    intent.putExtra("drop", getUserRole);
                    intent.putExtra("enterAddress", getUserAddress);
                    intent.putExtra("enterContactNo", getUserContactNo);
                    intent.putExtra("enterEmail", getUserEmail);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(AdminAddUserUI.this, "Fail to insert data!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void displayDetails() {
        Intent intent = new Intent(AdminAddUserUI.this, SummaryOfAccountAdded.class);
        startActivity(intent);
    }

}