package com.example.myapplication.Entity;

public class People {

    private String ID;
    private String userName;
    private String password;
    private String roles;
    private String address;
    private String contactNumber;
    private String email;

    public People(){

    }

    public People(String ID, String userName, String password, String roles, String address, String contactNumber, String email) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
    }

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
}
