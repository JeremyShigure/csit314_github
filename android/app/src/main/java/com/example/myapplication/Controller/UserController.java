package com.example.myapplication.Controller;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Entity.User;
import com.example.myapplication.Entity.People;

public class UserController extends AppCompatActivity {

    User user = new User(UserController.this);
    //DBHelper db = new DBHelper();

    public boolean validateLogin(String userName) {
        boolean isValidate = user.checkUserNameExistOrNot(userName);

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

    public boolean CheckUserExistOrNot(String userName) {
        boolean isValidate = user.checkUserNameExistOrNot(userName);
        if (isValidate) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkUserExistInTheDatabaseOrNot(String userName, String password, String roles) {
        boolean isValidate = user.checkUserExistInTheDatabaseOrNot(userName, password, roles);

        if (isValidate) {
            return true;
        }
        else {
            return false;
        }
    }

    public People ViewController(String userName) {
        String roles = "";
        boolean isAdded = user.checkUserNameExistOrNot(userName);
        People p1 = new People();
        if (isAdded) {
            p1 = user.checkUserExistInWhichTable(userName); //Get User obj from db
        }
        return p1;
    }

}



