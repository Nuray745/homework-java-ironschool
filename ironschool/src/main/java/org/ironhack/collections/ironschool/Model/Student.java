package org.ironhack.collections.ironschool.Model;

public class Student {
    private String studentId;
    private String name;
    private String address;
    private String email;
    private Course course;
    public Student(String name, String address, String email){
        this.studentId=java.util.UUID.randomUUID().toString();
        this.name=name;
        this.address=address;
        this.email=email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getStudentId() {
        return studentId;
    }

    public Course getCourse() {
        return course;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
