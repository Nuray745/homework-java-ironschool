package org.ironhack.collections.ironschool.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Course {
    private String courseId;
    private String name;
    private double price;
    private double moneyEarned;
    private Teacher teacher;

    public Course(String name, double price) {
        this.courseId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.moneyEarned = 0.0;
        this.teacher = null;
    }

    public String getCourseId() { return courseId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public double getMoneyEarned() { return moneyEarned; }
    public Teacher getTeacher() { return teacher; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    public void enrollStudent() {
        this.moneyEarned += this.price;
        System.out.println("Student enrolled in course: " + this.name);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
        System.out.println("Teacher " + teacher.getName() + " assigned to course" + this.name);
    }

    public void displayDetails() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Money Earned: " + moneyEarned);
        System.out.println("Teacher: " + (teacher != null ? teacher.getName() : "None"));
        System.out.println("------------------------------");
    }

}
