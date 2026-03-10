package org.ironhack.collections.ironschool.Service;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Model.Student;
import org.ironhack.collections.ironschool.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final List<Course> courses = new ArrayList<>();
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

    public Course updateCourse(String courseId, String name, double price) {
        Course course = findCourse(courseId);
        if(course != null) {
            course.setName(name);
            course.setPrice(price);
        }
        return course;
    }

    public Course assignTeacher(String courseId, String teacherId) {
        Course course = findCourse(courseId);
        Teacher teacher = teacherService.getTeacherById(teacherId);

        if(course != null && teacher != null) {
            course.setTeacher(teacher);
        }
        return course;
    }

    public String enrollStudent(Student student, String courseId) {
        Course course = findCourse(courseId);
        if(course == null) return "Course ID not found";

        course.addStudent(student);
        student.setCourse(course);
        course.addMoneyEarned(course.getPrice());

        return "Student " + student.getName() + " enrolled successfully in " + course.getName();
    }


    public void deleteCourse(String courseId) {
        courses.removeIf(course -> course.getCourseId().equals(courseId));
    }

    public double getTotalMoneyEarned() {
        double total = 0;
        for (Course course : courses) {
            total += course.getMoneyEarned();
        }
        return total;
    }

    public void addCourseMoney(String courseId) {
        Course course = findCourse(courseId);
        if(course != null) {
            course.addMoneyEarned(course.getPrice());
        }
    }
}