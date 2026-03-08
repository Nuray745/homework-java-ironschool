package org.ironhack.collections.ironschool.Service;

import org.ironhack.collections.ironschool.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private List<Teacher> teacherList=new ArrayList<>();
    public TeacherService(){};

    public List<Teacher> getAllTeacher() {
        return teacherList;
    }
    public Teacher getTeacherById(String teacherId){

        for(Teacher teacher:teacherList) {
            if (teacher.getTeacherId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }
    public double getTotalTeacherSalary(){
        double total=0;
        for(Teacher teacher:teacherList){
            if(teacher!=null){
                total+=teacher.getSalary();
            }
        }
        return total;
    }
}
