package com.cv;

public class Education {

    private String schoolName;
    private String department;
    private String period;

    public Education(String schoolName, String department, String period) {
        this.schoolName = schoolName;
        this.department = department;
        this.period = period;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPeriod() {
        return period;
    }
}