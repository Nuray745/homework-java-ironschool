package org.ironhack.collections.ironschool.Service;

import org.ironhack.collections.ironschool.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    private final List<Teacher> teacherList = new ArrayList<>();

    public TeacherService() {}

    public List<Teacher> getAllTeacher() {
        return teacherList;
    }

    public Teacher getTeacherById(String teacherId){
        for(Teacher teacher : teacherList) {
            if (teacher.getTeacherId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    public Teacher createTeacher(String name, double salary) {
        Teacher teacher = new Teacher(name, salary);
        teacherList.add(teacher);
        return teacher;
    }

    public void deleteTeacher(String teacherId) {
        teacherList.removeIf(teacher -> teacher.getTeacherId().equals(teacherId));
    }

    public Teacher updateTeacher(String id, String name, double salary) {
        Teacher teacher = getTeacherById(id);
        if (teacher != null) {
            teacher.setName(name);
            teacher.setSalary(salary);
        }
        return teacher;
    }

    public Teacher patchTeacher(String id, String name, Double salary) {
        Teacher teacher = getTeacherById(id);
        if (teacher != null) {
            if (name != null) teacher.setName(name);
            if (salary != null) teacher.setSalary(salary);
        }
        return teacher;
    }

    public double getTotalTeacherSalary(){
        double total = 0;
        for(Teacher teacher : teacherList){
            if(teacher != null){
                total += teacher.getSalary();
            }
        }
        return total;
    }
}