package com.example.javv101;

public class User {
    public String fullName, age, phoneNumber, email, gender;

    public String getFullName() {
        return fullName;
    }

    public String getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public User(){

    }
    public User(String fullName, String age, String phoneNumber, String email, String gender){
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;

    }



}
