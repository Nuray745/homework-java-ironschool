package org.ironhack.collections.ironschool;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Model.Teacher;
import org.ironhack.collections.ironschool.Service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CourseServiceTest {
    private CourseService courseService;
    private Course course1;
    private Course course2;

    @BeforeEach
    public void setUp() {
        courseService = new CourseService();
        course1 = new Course("Math", 100);
        course2 = new Course("Physics", 200);

        courseService.addCourse(course1);
        courseService.addCourse(course2);
    }
    @Test
    public void testEnrollStudent() {
        assertEquals(0, course1.getMoneyEarned());
        course1.enrollStudent();
        assertEquals(100, course1.getMoneyEarned());
    }

    @Test
    public void testAssignTeacher() {
        Teacher t = new Teacher("Ali", 500);
        assertNull(course1.getTeacher());
        course1.assignTeacher(t);
        assertEquals(t, course1.getTeacher());
    }
    @Test
    public void testServiceEnrollStudent() {
        assertEquals(0, course1.getMoneyEarned());
        courseService.enrollStudent(course1.getCourseId());
        assertEquals(100, course1.getMoneyEarned());
    }

    @Test
    public void testServiceAssignTeacher() {
        Teacher t = new Teacher("Aysha", 500);
        assertNull(course2.getTeacher());
        courseService.assignTeacher(course2.getCourseId(), t);
        assertEquals(t, course2.getTeacher());
    }

    @Test
    public void testGetTotalMoneyEarned() {
        course1.enrollStudent();
        course2.enrollStudent();
        assertEquals(300, courseService.getTotalMoneyEarned());
    }
}
