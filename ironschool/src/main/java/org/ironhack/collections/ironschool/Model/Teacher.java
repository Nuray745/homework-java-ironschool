package org.ironhack.collections.ironschool.Model;

import jakarta.validation.constraints.*;

import java.util.UUID;

public class Teacher {

    private String teacherId;

    @NotBlank(message = "Teacher name cannot be empty")
    private String name;

    @Min(value = 0, message = "Salary cannot be negative")
    private double salary;

    public Teacher(@NotBlank(message = "Teacher name cannot be empty") String name,
                   @Min(value = 0, message = "Salary cannot be negative") double salary) {
        this.teacherId = UUID.randomUUID().toString();
        this.name = name;
        this.salary = salary;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}