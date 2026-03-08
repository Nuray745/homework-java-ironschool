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
       this.studentService=studentService;
       this.courseService=courseService;
   }
   @GetMapping
   public List<Student> displayAllStudents(){
       List<Student> students=studentService.getAllStudent();
       if(students==null || students.isEmpty()){
           System.out.println("No students found in the system");
       }
       return students;
   }
   @GetMapping("/{id}")
   public Student lookupStudent(@PathVariable String id){
      try{
         Student student=studentService.getStudentById(id);
         if(student!=null){
             return student;
         }
         else{
             System.out.println("Student with ID " + id + " not found");
             return null;
         }
      }
      catch(Exception e){
          System.out.println("Unexpected error happened: "+e.getMessage());
          return null;
       }
   }

   @PostMapping("/enroll")
    public String enrollStudent(@RequestParam String id, @RequestParam String courseId) {
       try {
           String response = courseService.enrollStudent(courseId);
           if (!response.equals("Course ID not found")) {
               Student s = studentService.getStudentById(id);
               if (s != null) {
                   s.setCourse(courseService.getCourseById(courseId));
               }
               return "Success: " + s.getName() + " enrolled in " + courseId;
           }
           return response;
       } catch (Exception e) {
           return "Unexpected error happened " + e.getMessage();
       }
   }

}
