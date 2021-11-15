package com.example.myapplication.Entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Prescription extends SQLiteOpenHelper {

    String ID;
    String userName;
    String password;
    String roles;
    String address;
    String contactNumber;
    String email;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    private static final String DATABASE_NAME = "csit314DB.db";
    private static final int DATABASE_VERSION = 1;
    private final Context context;
    SQLiteDatabase db;

    private static final String DATABASE_PATH = "/data/data/com.example.myapplication/databases/";
    private final String TABLE_NAME = "Pharmacist";

    public Prescription(Context context) {
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

    //Check User existing in database
    public boolean checkUserNameExistOrNot(String userName){
        String[] columns = {"userName"};
        db = openDatabase();

        String selection = "userName=? ";
        String[] selectionArgs = {userName};

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

    public boolean checkPatIDExistOrNot(String patID){
        String[] columns = {"prescriptionID"};
        db = openDatabase();

        String selection = "patID=? ";
        String[] selectionArgs = {patID};

        Cursor cursor = db.query("Prescription", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkPrescriptionIDPatient(String userName){
        String[] columns = {"patID"};
        db = openDatabase();

        String selection = "userName=? ";
        String[] selectionArgs = {userName};

        Cursor cursor = db.query("Prescription pr JOIN Patient p ON pr.patID = p.patID", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }

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


    public boolean insertData(String Username, String Password, String Role, String Address, String contactNo, String email) {
        //this line creates database and table
        SQLiteDatabase db = this.getWritableDatabase();
        //Create ContentValues object to insert data into table
        ContentValues contentValues = new ContentValues();
        contentValues.put("userName", Username);
        contentValues.put("password", Password);
        contentValues.put("roles", Role);
        contentValues.put("address", Address);
        contentValues.getAsInteger(contactNo);
        contentValues.put("contactNumber", contactNo);
        contentValues.put("email", email);

        //If insert fails, its gonna return -1 to us
        long result = db.insert(Role, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public boolean ViewUpdateStatus (String Username, String medicineName, String Qty, String Date, String Status) {
        //SQLiteDatabase db = this.getWritableDatabase();

        db = openDatabase();

        //Create ContentValues object to insert data into table
        ContentValues contentValues = new ContentValues();
//        contentValues.put(Role + "ID", id);
//        contentValues.put("roles", Role);
//        contentValues.put("address", Address);
//        contentValues.put("contactNumber", contactNo);
        contentValues.put("Status", Status);
        //If insert fails, its gonna return -1 to us
        //db.update(Role, contentValues, "userName = ? and roles = ? and password = ?", new String[]{Username, Role, Password});
        db.update("PatientPrescription", contentValues, "userName = ?", new String[]{Username, userName});
        return true;
    }

    PatientD pd;

    public ArrayList viewPrescription(String patID, ArrayList listHere) {
        db = openDatabase();
        String[] columns = {"*"};

        String selection = "patID=?";
        String[] selectionArgs = {patID};

        Cursor cursor = db.query("Prescription", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        System.out.println("TEST TSTST  " + count);

        PatientD p1 = new PatientD();
        if(cursor.moveToFirst()){
            p1 = new PatientD( cursor.getString(0), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(5));
            listHere.add(p1);
            while(cursor.moveToNext()){
                p1 = new PatientD( cursor.getString(0), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(5));
                listHere.add(p1);
            }
        }
        cursor.close();
        db.close();
        return listHere;
    }

    public ArrayList viewPrescriptionPatient(String userName, ArrayList listHere) {
        db = openDatabase();
        String[] columns = {"Prescription.patID"};

        String selection = "Patient.userName=?";
        String[] selectionArgs = {userName};

        Cursor cursor = db.query("Prescription JOIN Patient ON Prescription.patID = Patient.patID", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        System.out.println("TESTINNNNNGGGGG " + count);

        PatientD p1 = new PatientD();
        if(cursor.moveToFirst()){
            p1 = new PatientD( cursor.getString(0), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(5));
            listHere.add(p1);
            while(cursor.moveToNext()){
                p1 = new PatientD( cursor.getString(0), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), cursor.getString(5));
                listHere.add(p1);
            }
        }
        cursor.close();
        db.close();
        return listHere;
    }

    People p1;

    public People viewControllerPatient(String userName){

        String[] columns = {"patID"};
        db = openDatabase();

        String selection = "userName=?";
        String[] selectionArgs = {userName};

        Cursor cursor = db.query("Patient", columns, selection, selectionArgs, null, null, null);

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


    public ArrayList viewControllerPatientDDDDDDDDDDDDDDDD(String userName, ArrayList listHere) {
        db = openDatabase();
        String[] columns = {"patID"};

        String selection = "userName=?";
        String[] selectionArgs = {userName};

        Cursor cursor = db.query("patient", columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        System.out.println(count);
        People p1 = new People();
        if(cursor.moveToFirst()){
            p1 = new People( cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
            listHere.add(p1);
            while(cursor.moveToNext()){
                p1 = new People( cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6));
                listHere.add(p1);
            }
        }
        cursor.close();
        db.close();
        return listHere;
    }

}
