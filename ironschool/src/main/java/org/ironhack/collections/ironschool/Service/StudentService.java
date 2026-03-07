package org.ironhack.collections.ironschool.Service;

import org.ironhack.collections.ironschool.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> studentList=new ArrayList<>();
    public StudentService(){}
    public List<Student> getAllStudent(){
        return studentList;
    }
   public Student getStudentById(String id){
        for(Student student:studentList){
            if(student.getStudentId().equals(id)){
                return student;
            }
        }
        return null;
   }

}
