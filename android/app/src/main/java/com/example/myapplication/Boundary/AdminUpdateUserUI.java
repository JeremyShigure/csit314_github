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

public class AdminUpdateUserUI extends AppCompatActivity {

    DBHelper myDb;
    Spinner drop;
    Button npButton;
    EditText enterID, enterName, enterPassword, enterAddress, enterContactNo, enterEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_user_ui);

        //Instantiation or variables
        myDb = new DBHelper(AdminUpdateUserUI.this);
        npButton = (Button) findViewById(R.id.npButton);
        enterName = (EditText) findViewById(R.id.useraddnameTextBox);
        enterPassword = (EditText) findViewById(R.id.useraddpassTextBox);
        drop = (Spinner) findViewById(R.id.spinner2);
        enterAddress = (EditText) findViewById(R.id.add1TextBox2);
        enterContactNo = (EditText) findViewById(R.id.add1TextBox3);
        enterEmail = (EditText) findViewById(R.id.add1TextBox6);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.roletype, R.layout.support_simple_spinner_dropdown_item);
        drop.setAdapter(adapter);

        npButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInsert = myDb.UpdateData(enterName.getText().toString() ,enterPassword.getText().toString(), drop.getSelectedItem().toString(), enterAddress.getText().toString(), enterContactNo.getText().toString(), enterEmail.getText().toString());
                if (isInsert && myDb.checkUserExist(enterName.getText().toString(), drop.getSelectedItem().toString())) {

                    String getUserName = enterName.getText().toString();
                    String getUserPassword = enterPassword.getText().toString();
                    String getUserRole = drop.getSelectedItem().toString();
                    String getUserAddress = enterAddress.getText().toString();
                    String getUserContactNo = enterContactNo.getText().toString();
                    String getUserEmail = enterEmail.getText().toString();

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