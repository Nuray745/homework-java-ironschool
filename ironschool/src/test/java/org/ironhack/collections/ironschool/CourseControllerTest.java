package org.ironhack.collections.ironschool;


import org.ironhack.collections.ironschool.Controller.CourseController;
import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Service.CourseService;
import org.ironhack.collections.ironschool.Service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CourseControllerTest {

    private CourseService courseService;
    private CourseController courseController;

    @BeforeEach
    void setup() {
        courseService = mock(CourseService.class);
        TeacherService teacherService = mock(TeacherService.class);
        courseController = new CourseController(courseService, teacherService);
    }

    @Test
    void showCoursesShouldReturnList() {
        when(courseService.getAllCourses()).thenReturn(List.of(new Course("Java", 200)));

        List<Course> courses = courseController.showCourses();

        assertEquals(1, courses.size());
        assertEquals("Java", courses.get(0).getName());
    }

    @Test
    void lookUpCourseShouldReturnCourse() {
        Course course = new Course("Java", 200);
        when(courseService.findCourse(course.getCourseId())).thenReturn(course);

        Course found = courseController.lookUpCourse(course.getCourseId());

        assertEquals(course, found);
    }

    @Test
    void assignTeacherEndpointShouldCallService() {
        String courseId = "c1";
        String teacherId = "t1";

        courseController.assignTeacher(courseId, teacherId);

        verify(courseService, times(1)).assignTeacher(courseId, teacherId);
    }
}