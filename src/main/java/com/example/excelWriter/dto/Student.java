package com.example.excelWriter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Student {

    private String name;
    private int roll;
    private int age;

    public Student() {
    }

    public Student(String name, int roll, int age) {
        this.name = name;
        this.roll = roll;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
