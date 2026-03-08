package org.ironhack.collections.ironschool;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Model.Student;
import org.ironhack.collections.ironschool.Service.StudentService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentServiceTest {
    private StudentService studentService;
    @BeforeEach
    void setUp(){
        studentService=new StudentService();
    }
    @Test
    void testGetStudentById(){
        Student s=new Student("Zeyneb","Baku","zeyneb06@gmail.com");
        String generatedId=s.getStudentId();
        studentService.getAllStudent().add(s);

        Student found=studentService.getStudentById(generatedId);
        assertNotNull(found,"Student must found!");
        assertEquals("Zeyneb",found.getName());
        assertEquals(generatedId,found.getStudentId());
    }

    @Test
    void testGetStudentById_IfNotFound() {
        Student found=studentService.getStudentById("NON-EXISTENT-ID");
        assertNull(found, "Expected null for non-existent student ID");
    }

    @Test
    void testStudentCourseAssignment_ShouldUpdateCourseCorrectly(){
        Student s=new Student("Kenan","Xacmaz","kenan12@gmail.com");
        Course c=new Course("Java Spring Boot", 800);
        s.setCourse(c);
        assertNotNull(s.getCourse(),"Course should not be null after assignment");
        assertEquals("Java Spring Boot",s.getCourse().getName(),"Course name should match the assigned course");

    }
}
