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
import com.example.myapplication.Entity.People;

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

        boolean isValidate = user.AddUserDetails(userName, password, roles, address, contactNumber, email);

        if (isValidate) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean CheckUpdateDetails(String userName, String password, String roles, String address, String contactNumber, String email) {
        boolean isValidate = user.UpdateUserDetails(userName, password, roles, address, contactNumber, email);

        if (isValidate) {
            return true;
        }
        else {
            return false;
        }
    }


    //here
    public People ViewController(String userName) {
        String roles = "";
        boolean isAdded = user.checkUserNameExistOrNot(userName);
        People p1 = new People();
        if (isAdded) {
            p1 = user.checkUserExistInWhichTable(userName);
            System.out.println(p1.getUserName());
            System.out.println(p1.getRoles());
            System.out.println(p1.getAddress());
            System.out.println(p1.getContactNumber());
            System.out.println(p1.getEmail());
            System.out.println(p1.getPassword());
        }
        return p1;
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



