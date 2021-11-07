package com.example.myapplication.Controller;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Boundary.AdminMainPage;
import com.example.myapplication.Boundary.DBHelper;
import com.example.myapplication.Boundary.DoctorMainPage;
import com.example.myapplication.Boundary.PatientMainPage;
import com.example.myapplication.Boundary.PharmacistMainPage;
import com.example.myapplication.Boundary.UserLoginPage;
import com.example.myapplication.Entity.User;

public class UserController extends AppCompatActivity {


    User user = new User(UserController.this);
    //DBHelper db = new DBHelper();

    public boolean validateLogin(String userName, String password, String roles) {
        boolean isValidate = user.checkUserAccountExist(userName, password, roles);

        if (isValidate) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean CheckAddedDetails(String userName, String password, String roles, String address, String contactNumber, String email) {
        boolean isValidate = user.insertData(userName, password, roles, address, contactNumber, email);

        if (isValidate) {
            return true;
        }
        else {
            return false;
        }

    }
//
//    public boolean checkAddedDetails(String userName, String password, String roles, String address, String contactNumber, String email) {
//        boolean isValidate = user.insertData(userName, password, roles, address, contactNumber, email);
//
//        if (isValidate) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    }

}



