package org.ironhack.collections.ironschool;

import org.ironhack.collections.ironschool.Model.Teacher;
import org.ironhack.collections.ironschool.Service.TeacherService;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeacherServiceTest {
    private TeacherService teacherService;

    @BeforeEach
    void setUp(){
        teacherService=new TeacherService();
    }

    @Test
    void testGetTotalTeacherSalary(){
        Teacher t1=new Teacher("Namiq",1000);
        Teacher t2=new Teacher("Gulay",500);
        teacherService.getAllTeacher().add(t1);
        teacherService.getAllTeacher().add(t2);
        double totalSalary= teacherService.getTotalTeacherSalary();
        assertEquals(1500,totalSalary,"Total salary doesn't calculate correct ");
    }

    @Test
    void testGetTeacherById(){
        Teacher t=new Teacher("Shabnam",1700);
        String generatedId=t.getTeacherId();
        teacherService.getAllTeacher().add(t);
        Teacher found=teacherService.getTeacherById(generatedId);
        assertNotNull(found,"Teacher must found!");
        assertEquals("Shabnam",found.getName());
        assertEquals(generatedId,found.getTeacherId());
    }
}
