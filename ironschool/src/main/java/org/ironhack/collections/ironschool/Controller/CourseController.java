package org.ironhack.collections.ironschool.Controller;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Service.CourseService;
import org.ironhack.collections.ironschool.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;
    private final TeacherService teacherService;

    public CourseController(CourseService courseService, TeacherService teacherService) {
        this.courseService = courseService;
        this.teacherService = teacherService;
    }


    @GetMapping("/profit")
    public ResponseEntity<String> showProfit() {
        double totalEarned = courseService.getTotalMoneyEarned();
        double totalSpent = teacherService.getTotalTeacherSalary();
        double profit = totalEarned - totalSpent;

        return ResponseEntity.ok("Total profit: " + profit);
    }


    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course.getName(), course.getPrice());
    }


    @GetMapping
    public List<Course> showCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course lookUpCourse(@PathVariable String courseId) {
        return courseService.findCourse(courseId);
    }


    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable String courseId, @RequestBody Course updatedCourse) {
        return courseService.updateCourse(courseId, updatedCourse.getName(), updatedCourse.getPrice());
    }


    @PutMapping("/{courseId}/teacher/{teacherId}")
    public Course assignTeacher(@PathVariable String courseId,
                                @PathVariable String teacherId) {
        return courseService.assignTeacher(courseId, teacherId);
    }


    @DeleteMapping("/{courseId}")
    public String deleteCourse(@PathVariable String courseId) {
        Course course = courseService.findCourse(courseId);
        if (course != null) {
            courseService.deleteCourse(courseId);
            return "Course " + course.getName() + " deleted successfully";
        }
        return "Course ID not found";
    }
}