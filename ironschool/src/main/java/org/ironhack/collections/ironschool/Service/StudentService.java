package org.ironhack.collections.ironschool.Service;

import org.ironhack.collections.ironschool.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> studentList = new ArrayList<>();

    public StudentService() {}

    public List<Student> getAllStudent() {
        return studentList;
    }

    public Student getStudentById(String id) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public Student createStudent(String name, String address, String email) {
        Student student = new Student(name, address, email);
        studentList.add(student);
        return student;
    }

    public void deleteStudent(String id) {
        studentList.removeIf(student -> student.getStudentId().equals(id));
    }

    public Student updateStudent(String id, String name, String address, String email) {
        Student student = getStudentById(id);
        if (student != null) {
            student.setName(name);
            student.setAddress(address);
            student.setEmail(email);
        }
        return student;
    }

    public Student patchStudent(String id, String name, String address, String email) {
        Student student = getStudentById(id);
        if (student != null) {
            if (name != null) student.setName(name);
            if (address != null) student.setAddress(address);
            if (email != null) student.setEmail(email);
        }
        return student;
    }
}