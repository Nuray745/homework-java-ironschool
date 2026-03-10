package org.ironhack.collections.ironschool.Model;

import jakarta.validation.constraints.*;

import java.util.UUID;

public class Student {

    private String studentId;

    @NotBlank(message = "Student name cannot be empty")
    private String name;

    private String address;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    private String email;

    private Course course;

    public Student(@NotBlank(message = "Student name cannot be empty") String name,
                   String address,
                   @NotBlank(message = "Email cannot be empty") @Email(message = "Email should be valid") String email) {
        this.studentId = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Course getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}