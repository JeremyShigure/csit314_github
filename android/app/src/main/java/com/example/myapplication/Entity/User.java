package com.example.myapplication.Entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.myapplication.Entity.People;

import com.example.myapplication.Controller.UserController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class User extends SQLiteOpenHelper{

    String ID;
    String userName;
    String password;
    String roles;
    String address;
    String contactNumber;
    String email;

    private static final String DATABASE_NAME = "csit314DB.db";
    private static final int DATABASE_VERSION = 1;
    private final Context context;
    SQLiteDatabase db;

    private static final String DATABASE_PATH = "/data/data/com.example.myapplication/databases/";
    private final String TABLE_NAME = "Admin";

    public User(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        createDb();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createDb(){
        boolean dbExist = checkDbExist();

        if(!dbExist){
            this.getReadableDatabase();
            copyDatabase();
        }
    }

    private boolean checkDbExist(){
        SQLiteDatabase sqLiteDatabase = null;

        try{
            String path = DATABASE_PATH + DATABASE_NAME;
            sqLiteDatabase = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        }
        catch (Exception ex){
        }

        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
            return true;
        }
        return false;
    }

    private void copyDatabase(){
        try {
            InputStream inputStream = context.getAssets().open(DATABASE_NAME);
            String outFileName = DATABASE_PATH + DATABASE_NAME;

            OutputStream outputStream = new FileOutputStream(outFileName);

            byte[] b = new byte[1024];
            int length;

            while ((length = inputStream.read(b)) > 0){
                outputStream.write(b, 0, length);
            }

            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SQLiteDatabase openDatabase(){
        String path = DATABASE_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }

    public boolean checkUserAccountExist(String username, String password, String Role){
        String[] columns = {"userName"};
        db = openDatabase();

        String selection = "userName=? and password = ?";
        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(Role, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }

    //Check User existing in database
    public boolean checkUserNameExistOrNot(String username){
        String[] columns = {"userName"};
        db = openDatabase();

        String selection = "userName=? ";
        String[] selectionArgs = {username};

        Cursor cursor = db.query("AllUser", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUserExistInTheDatabaseOrNot(String username, String password, String roles){
        String[] columns = {"userName, password, roles"};
        db = openDatabase();

        String selection = "userName=? and password=? and roles=? ";
        String[] selectionArgs = {username, password, roles};

        Cursor cursor = db.query("AllUser", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }

    People p1;

    //Retrieve role from AllUser Table
    public People checkUserExistInWhichTable(String userName){

        String[] columns = {"*"};
        db = openDatabase();

        String selection = "userName=?";
        String[] selectionArgs = {userName};

        Cursor cursor = db.query("AllUser", columns, selection, selectionArgs, null, null, null);

        if(cursor.moveToFirst()){
            ID = cursor.getString(0);
            userName = cursor.getString(1);
            password = cursor.getString(2);
            roles = cursor.getString(3);
            address = cursor.getString(4);
            contactNumber = cursor.getString(5);
            email = cursor.getString(6);
            p1 = new People(ID, userName, password, roles, address, contactNumber, email);
        }
        cursor.close();
        close();
        //p1.setRoles(roles);
        return p1;
    }

    public boolean AddUserDetails(String userName, String password, String roles, String address, String contactNumber, String email) {
        //System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        db = openDatabase();
        System.out.println(db);

        //Create ContentValues object to insert data into table
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", userName);
        contentValues.put("password", password);
        contentValues.put("roles", roles);
        contentValues.put("address", address);
        contentValues.getAsInteger(contactNumber);
        contentValues.put("contactNumber", contactNumber);
        contentValues.put("email", email);

        //If insert fails, its gonna return -1 to us
        long result = db.insert(roles, null, contentValues);
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

//    public boolean UpdateUserDetails(String Username, String Password, String Role, String Address, String contactNo, String email) {
////        SQLiteDatabase db = this.getWritableDatabase();
//
//        db = openDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        //contentValues.put(Role + "ID", id);
//        contentValues.put("password", Password);
//        //contentValues.put("roles", Role);
//        contentValues.put("address", Address);
//        contentValues.put("contactNumber", contactNo);
//        contentValues.put("email", email);
//        //If insert fails, its gonna return -1 to us
//        //db.update(Role, contentValues, "userName = ? and roles = ? and password = ?", new String[]{Username, Role, Password});
//        db.update(Role, contentValues, "userName = ? and roles = ?", new String[]{Username, Role});
//        return true;
//    }

    public boolean UpdateUserDetails(String Username, String Password, String Role, String Address, String contactNo, String email) {

        db = openDatabase();

        ContentValues contentValues = new ContentValues();
        //contentValues.put(Role + "ID", id);
        contentValues.put("password", Password);
        //contentValues.put("roles", Role);
        contentValues.put("address", Address);
        contentValues.put("contactNumber", contactNo);
        contentValues.put("email", email);
        //If insert fails, its gonna return -1 to us
        //db.update(Role, contentValues, "userName = ? and roles = ? and password = ?", new String[]{Username, Role, Password});
        db.update(Role, contentValues, "userName = ? and roles = ?", new String[]{Username, Role});
        return true;
    }

}
