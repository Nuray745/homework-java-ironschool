package org.ironhack.collections.ironschool.Controller;

import org.ironhack.collections.ironschool.Model.Teacher;
import org.ironhack.collections.ironschool.Service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> displayAllTeacher(){
        List<Teacher> teachers = teacherService.getAllTeacher();
        if(teachers == null || teachers.isEmpty()){
            System.out.println("No teachers found in system");
        }
        return teachers;
    }

    @GetMapping("/{id}")
    public Teacher lookupTeacher(@PathVariable String id){
        Teacher teacher = teacherService.getTeacherById(id);
        if(teacher != null) return teacher;
        System.out.println("Teacher with ID " + id + " not found");
        return null;
    }

    @GetMapping("/total-salary")
    public double getTotalSalaryOfTeacher(){
        return teacherService.getTotalTeacherSalary();
    }

    @PostMapping("/create")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher.getName(), teacher.getSalary());
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable String id) {
        Teacher teacher = teacherService.getTeacherById(id);
        if (teacher != null) {
            teacherService.deleteTeacher(id);
            return "Teacher " + teacher.getName() + " deleted successfully";
        }
        return "Teacher ID not found";
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable String id, @RequestBody Teacher updatedTeacher) {
        return teacherService.updateTeacher(id, updatedTeacher.getName(), updatedTeacher.getSalary());
    }


    @PatchMapping("/{id}")
    public Teacher patchTeacher(@PathVariable String id, @RequestBody Teacher updatedFields) {
        return teacherService.patchTeacher(id,
                updatedFields.getName(),
                updatedFields.getSalary());
    }
}