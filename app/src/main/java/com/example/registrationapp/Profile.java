package com.example.registrationapp;

public class Profile {
    String name;
    String email;
    int id;
    String dept;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDept() {
        return name;
    }

    public void setDept(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profile(String name, String email, int id, String dept) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.dept = dept;
    }
}
