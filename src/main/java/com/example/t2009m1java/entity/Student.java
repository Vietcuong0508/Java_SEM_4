package com.example.t2009m1java.entity;

public class Student {
    private String rollNumber;
    private String fullName;
    private int status;

    public Student() {
    }

    public Student(String rollNumber, String fullName, int status) {
        this.rollNumber = rollNumber;
        this.fullName = fullName;
        this.status = status;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
