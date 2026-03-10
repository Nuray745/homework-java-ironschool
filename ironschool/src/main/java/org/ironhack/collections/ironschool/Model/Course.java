package org.ironhack.collections.ironschool.Model;

import jakarta.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {

    private String courseId;

    @NotBlank(message = "Course name cannot be empty")
    private String name;

    @Min(value = 0, message = "Course price cannot be negative")
    private double price;

    private double moneyEarned;
    private Teacher teacher;
    private List<Student> students;


    public Course(@NotBlank(message = "Course name cannot be empty") String name,
                  @Min(value = 0, message = "Course price cannot be negative") double price) {
        this.courseId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.moneyEarned = 0;
        this.students = new ArrayList<>();
    }


    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getMoneyEarned() {
        return moneyEarned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public void addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            this.students.add(student);
            student.setCourse(this);
        }
    }

    public void removeStudent(Student student) {
        if (student != null) {
            this.students.remove(student);
            student.setCourse(null);
        }
    }

    public void addMoneyEarned(double amount) {
        if (amount > 0) {
            this.moneyEarned += amount;
        }
    }

    public void resetMoneyEarned() {
        this.moneyEarned = 0;
    }
}