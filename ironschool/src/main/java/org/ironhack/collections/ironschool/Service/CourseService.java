package org.ironhack.collections.ironschool.Service;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses = new ArrayList<>();
    private final TeacherService teacherService;

    public CourseService(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    public Course createCourse(String name, double price){
        Course course = new Course(name, price);
        courses.add(course);
        return course;
    }

    public List<Course> getAllCourses(){
        return courses;
    }

    public Course findCourse(String courseId) {
        for(Course course : courses) {
            if(course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public void assignTeacher(String courseId, String teacherId) {
        Course course = findCourse(courseId);
        Teacher teacher = teacherService.findTeacher(teacherId);

        if(course != null && teacher != null) {
            course.setTeacher(teacher);
        }
    }
    public void addCourseMoney(String courseId) {
        Course course = findCourse(courseId);

        if(course != null) {
            course.addMoneyEarned(course.getPrice());
        }
    }
}