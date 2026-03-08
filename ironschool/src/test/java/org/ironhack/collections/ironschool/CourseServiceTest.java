package org.ironhack.collections.ironschool;

package service;


import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseServiceTest {

    private CourseService courseService;
    private TeacherService teacherService;

    @BeforeEach
    void setUp() {
        teacherService = new TeacherService();
        courseService = new CourseService(teacherService);
    }

    @Test
    void createCourseShouldWork() {
        Course course = courseService.createCourse("Java", 200);

        assertEquals("Java", course.getName());
        assertEquals(200, course.getPrice());
        assertNotNull(course.getCourseId());
        assertEquals(0, course.getMoneyEarned());
    }

    @Test
    void assignTeacherShouldWork() {
        Course course = courseService.createCourse("Java", 200);
        Teacher teacher = teacherService.createTeacher("Ali", 3000);

        courseService.assignTeacher(course.getCourseId(), teacher.getTeacherId());

        assertEquals(teacher, course.getTeacher());
    }

    @Test
    void findCourseShouldReturnCourse() {
        Course course = courseService.createCourse("Java", 200);

        Course found = courseService.findCourse(course.getCourseId());

        assertEquals(course, found);
    }

    @Test
    void findCourseShouldReturnNullIfNotFound() {
        Course found = courseService.findCourse("invalid-id");

        assertNull(found);
    }

    @Test
    void addCourseMoneyShouldIncreaseMoneyEarned() {
        Course course = courseService.createCourse("C++", 400);

        courseService.addCourseMoney(course.getCourseId());
        assertEquals(400, course.getMoneyEarned());

        courseService.addCourseMoney(course.getCourseId());
        assertEquals(800, course.getMoneyEarned());
    }
}