package com.example.myapplication.Entity;

import java.io.Serializable;

public class PatientD implements Serializable {

    private String prescriptionID;
    private String patID;
    private String medicineName;
    private int qty;
    private String date; //yyyy-mm-dd
    private String status;

    public PatientD(){

    }

    public PatientD(String prescriptionID, String patID, String medicineName, int qty, String date, String status) {
        this.prescriptionID = prescriptionID;
        this.patID = patID;
        this.medicineName = medicineName;
        this.qty = qty;
        this.date = date;
        this.status = status;
    }

    public String getPrescriptionID() {
        return prescriptionID;
    }

    public void setPrescriptionID(String prescriptionID) {
        this.prescriptionID = prescriptionID;
    }

    public String getPatID() {
        return patID;
    }

    public void setPatID(String patID) {
        this.patID = patID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
