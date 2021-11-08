package com.example.myapplication.Entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.Controller.UserController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class User extends SQLiteOpenHelper{

    String adminID;
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

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    private SQLiteDatabase openDatabase(){
        String path = DATABASE_PATH + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        System.out.println("================================+==+++==+++=++++=++++=++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(db);
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

    public boolean checkUserExist(String username, String Role){
        String[] columns = {"userName"};
        db = openDatabase();

        String selection = "userName=? and roles = ?";
        String[] selectionArgs = {username, Role};

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

    public boolean checkUsernameExistOrNot(String username){
        String[] columns = {"userName"};
        db = openDatabase();

        String selection = "userName=? ";
        String[] selectionArgs = {username};

        Cursor cursor = db.query("Doctor ", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }

    public String checkUserExistInWhichTable(String username){
        String ROLE = "";
        String[] columnsUserName = {"userName"};
        db = openDatabase();

        String selectionUserName = "userName=? ";
        String[] selectionArgsUserName = {username};

        Cursor cursorPatient = db.query("Patient ", columnsUserName, selectionUserName, selectionArgsUserName, null, null, null);

        Cursor cursorDoctor = db.query("Doctor ", columnsUserName, selectionUserName, selectionArgsUserName, null, null, null);

        Cursor cursorPharmacist = db.query("Pharmacist ", columnsUserName, selectionUserName, selectionArgsUserName, null, null, null);

        int countDoctor;
        countDoctor = cursorDoctor.getCount();

        int countPatient;
        countPatient = cursorPatient.getCount();

        int countPharmacist;
        countPharmacist = cursorPharmacist.getCount();

        cursorDoctor.close();
        cursorPatient.close();
        cursorPharmacist.close();
        close();

        if (countPatient > 0) {
            String patRole = "";
            String queryPat = "SELECT roles FROM Patient WHERE userName = " + "'" + username + "'";
            db = openDatabase();
            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursorPat = db.rawQuery(queryPat, null);

            while (cursorPat.moveToNext()) {
                patRole = cursorPat.getString(0);
                System.out.println(patRole);
                ROLE = patRole;
            }

        }
        else if (countDoctor > 0) {
            String docRole = "";
            String queryDoc = "SELECT roles FROM Doctor WHERE userName = " + "'" + username + "'";
            db = openDatabase();
            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursorDoc = db.rawQuery(queryDoc, null);

            while (cursorDoc.moveToNext()) {
                docRole = cursorDoc.getString(0);
                System.out.println(docRole);
                ROLE = docRole;
            }

        }
        else if (countPharmacist > 0) {
            String pharRole = "";
            String queryPhar = "SELECT roles FROM Pharmacist WHERE userName = " + "'" + username + "'";
            db = openDatabase();
            SQLiteDatabase db = this.getWritableDatabase();

            Cursor cursorPhar = db.rawQuery(queryPhar, null);

            while (cursorPhar.moveToNext()) {
                pharRole = cursorPhar.getString(0);
                System.out.println(pharRole);
                ROLE = pharRole;
            }

        }
        return ROLE;
    }


//    public boolean checkUserExistInWhichTable(String username){
//        String[] columns = {"roles"};
//        db = openDatabase();
//
//        String selection = "userName = ?";
//        String[] selectionArgs = {username};
//
//        Cursor cursor = db.query("Doctor", columns, selection, selectionArgs, null, null, null);
//        int count = cursor.getCount();
//
//        cursor.close();
//        close();
//
//        if(count > 0){
//            return true;
//        } else {
//            return false;
//        }
//    }

//    public String returnRoleTableAfterCheck(String username, boolean checkingUser) {
//        String role = "";
//
//        String[] columns = {"roles"};
//        db = openDatabase();
//
//        String selection = "userName = ?";
//        String[] selectionArgs = {username};
//
//        Cursor cursor = db.query("Doctor", columns, selection, selectionArgs, null, null, null);
//
//        if (checkingUser == true) {
//            if (cursor.moveToFirst()) {
//                do {
//                    String getRole = cursor.getString(0);
//                }
//                while(cursor.moveToNext());
//            }
//            return role;
//        }
//        else {
//            return "";
//        }
//    }

    public String returnRoleTableAfterCheck(String username, boolean checkingUser) {
        String role = "";

        if (checkingUser == true) {
            String conditions = "doctor join patient on doctor.docID = patient.patID join pharmacist on pharmacist.pharID = patient.patID";
            final Cursor c = db.rawQuery("SELECT roles FROM " + conditions + " WHERE userName =  " + "'" + username + "'", null);

            if (c.moveToFirst()) {
                role = c.getString(c.getColumnIndex("roles"));
            }
            return role;
        }

        return role;
    }


    public boolean insertData(String userName, String password, String roles, String address, String contactNumber, String email)
    {

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        //this line creates database and table

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
        if(result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getAllDataDoctor(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Doctor WHERE userName = ?", new String[]{userName});
        return res;
    }

    public Cursor getAllDataPatient(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Patient WHERE userName = ?", new String[]{userName});
        return res;
    }

    public Cursor getAllDataPharmacist(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM Pharmacist WHERE userName = ?", new String[]{userName});
        return res;
    }

    public Cursor getUserAccountData(String userNameInput, String passwordInput)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT role from Login where userName = " + "'" + userNameInput + "'" + "and password = " + "'" + passwordInput + "'", null);
        return res;
    }

    public boolean UpdateData(String Username, String Password, String Role, String Address, String contactNo, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        //Create ContentValues object to insert data into table
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
