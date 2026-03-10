package org.ironhack.collections.ironschool.Controller;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Model.Student;
import org.ironhack.collections.ironschool.Service.CourseService;
import org.ironhack.collections.ironschool.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    private final CourseService courseService;

    public StudentController(StudentService studentService, CourseService courseService){
        this.studentService = studentService;
        this.courseService = courseService;
    }

    @GetMapping
    public List<Student> displayAllStudents(){
        List<Student> students = studentService.getAllStudent();
        if(students == null || students.isEmpty()){
            System.out.println("No students found in the system");
        }
        return students;
    }

    @GetMapping("/{id}")
    public Student lookupStudent(@PathVariable String id){
        Student student = studentService.getStudentById(id);
        if(student != null) return student;
        System.out.println("Student with ID " + id + " not found");
        return null;
    }


    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student.getName(), student.getAddress(), student.getEmail());
    }

    @PostMapping("/enroll")
    public String enrollStudent(@RequestParam String studentId,
                                @RequestParam String courseId) {
        Student student = studentService.getStudentById(studentId);
        if(student == null) return "Student ID not found";

        return courseService.enrollStudent(student, courseId);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            studentService.deleteStudent(id);
            return "Student " + student.getName() + " deleted successfully";
        }
        return "Student ID not found";
    }


    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student updatedStudent) {
        return studentService.updateStudent(id,
                updatedStudent.getName(),
                updatedStudent.getAddress(),
                updatedStudent.getEmail());
    }

    @PatchMapping("/{id}")
    public Student patchStudent(@PathVariable String id, @RequestBody Student updatedFields) {
        return studentService.patchStudent(id,
                updatedFields.getName(),
                updatedFields.getAddress(),
                updatedFields.getEmail());
    }
}