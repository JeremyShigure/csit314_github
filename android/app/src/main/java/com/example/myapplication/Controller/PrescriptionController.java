package com.example.myapplication.Controller;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Entity.PatientD;
import com.example.myapplication.Entity.Prescription;

import java.util.ArrayList;

public class PrescriptionController extends AppCompatActivity {

    Prescription prescription = new Prescription(PrescriptionController.this);
    //User user = new User(PharmacistController.this);

    //private SQLiteDatabase db;

    public boolean checkPrescriptionID(String patID) {
        boolean isValidate = prescription.checkPatIDExistOrNot(patID);
        if (isValidate) {
            return true;
        }
        else {
            return false;
        }
    }

    ArrayList<PatientD> pDList = new ArrayList<PatientD>();

    //Retrieve patient prescription
    public ArrayList<PatientD> viewController(String patID){
        prescription.viewPrescription(patID, pDList);
        return pDList;
    }

    ArrayList<PatientD> peopleList = new ArrayList<PatientD>();

    public ArrayList<PatientD> viewControllerPatient(String userName){
        prescription.viewPrescriptionPatient(userName, peopleList);
        return peopleList;
    }


//    public ArrayList<>

//    public updateStatus(String userName, String medicineName, ) {
//        boolean checkUpdate = pharmacist.ViewUpdateStatus(userName, );
//    }


}
