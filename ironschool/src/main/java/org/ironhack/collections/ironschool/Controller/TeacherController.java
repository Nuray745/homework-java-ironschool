package org.ironhack.collections.ironschool.Controller;


import org.ironhack.collections.ironschool.Model.Teacher;
import org.ironhack.collections.ironschool.Service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    private TeacherService teacherService;
    public TeacherController(TeacherService teacherService){
        this.teacherService=teacherService;
    }

    @GetMapping
    public List<Teacher> displayAllTeacher(){
        List<Teacher> teachers=teacherService.getAllTeacher();
        if(teachers==null || teachers.isEmpty()){
            System.out.println("No teachers found in system");
        }
        return teachers;
    }

    @GetMapping("/{id}")
    public Teacher lookupTeacher(@PathVariable("id") String teacherId){
        try{
            Teacher teacher=teacherService.getTeacherById(teacherId);
            if(teacher!=null){
                return teacher;
            }
            else{
                System.out.println("Teacher with ID " + teacherId + " not found");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Unexpected error happened "+e.getMessage());
            return null;
        }
    }

    @GetMapping("/total-salary")
    public double getTotalSalaryOfTeacher(){
        try{
            return teacherService.getTotalTeacherSalary();
        }
        catch (Exception e) {
            System.out.println("Error calculating total salary: " + e.getMessage());
            return 0;
        }
    }
}
