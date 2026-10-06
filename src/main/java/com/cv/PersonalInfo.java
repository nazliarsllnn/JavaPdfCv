package com.cv;

public class PersonalInfo {

    private String fullName;
    private String title;
    private String email;
    private String phone;
    private String address;

    public PersonalInfo(String fullName, String title, String email,
                        String phone, String address) {
        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}