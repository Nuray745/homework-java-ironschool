package org.ironhack.collections.ironschool.Controller;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public Course createCourse(@RequestParam String name, @RequestParam double price) {
        return courseService.createCourse(name, price);
    }

    @GetMapping
    public List<Course> showCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course lookUpCourse(@PathVariable String courseId) {
        return courseService.findCourse(courseId);
    }

    @PutMapping("/{courseId}/teacher/{teacherId}")
    public void assignTeacher(@PathVariable String courseId,
                              @PathVariable String teacherId) {
        courseService.assignTeacher(courseId, teacherId);
    }


}