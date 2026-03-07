package org.ironhack.collections.ironschool.Controller;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Model.Teacher;
import org.ironhack.collections.ironschool.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Bütün course-ları göstər
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getCourses();
    }

    // Bir course-u göstər
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable String id) {
        Course c = courseService.getCourseById(id);
        if(c == null) throw new RuntimeException("Course not found");
        return c;
    }

    // Student enroll
    @PostMapping("/enroll")
    public String enrollStudent(@RequestParam String courseId) {
        Course c = courseService.getCourseById(courseId);
        if(c == null) return "Course not found!";
        c.enrollStudent();
        return "Student enrolled in course " + c.getName();
    }

    // Teacher assign
    @PostMapping("/assign")
    public String assignTeacher(@RequestParam String courseId, @RequestParam String teacherName) {
        Course c = courseService.getCourseById(courseId);
        if(c == null) return "Course not found!";
        Teacher t = new Teacher(teacherName, 500); // nümunə üçün teacher yaradılır
        c.assignTeacher(t);
        return "Teacher " + teacherName + " assigned to course " + c.getName();
    }

    // Total money earned
    @GetMapping("/profit")
    public double getTotalProfit() {
        return courseService.getTotalMoneyEarned();
    }


}