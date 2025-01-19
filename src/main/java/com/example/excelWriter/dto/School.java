package com.example.excelWriter.dto;


public class School {

    private String schoolName;
    private String schoolCode;
    private String schoolAddress;

    public School(String schoolName, String schoolCode, String schoolAddress) {
        this.schoolName = schoolName;
        this.schoolCode = schoolCode;
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }
}
