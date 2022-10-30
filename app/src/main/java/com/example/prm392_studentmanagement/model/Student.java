package com.example.prm392_studentmanagement.model;

import java.util.Date;

public class Student {
    private  String id;
    private  String name;
    private Date dob;
    private  int classId;
    private  String phone;

    public Student() {
    }

    public Student(String id, String name, Date dob, int classId, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.classId = classId;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
