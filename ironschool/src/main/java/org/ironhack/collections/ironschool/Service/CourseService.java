package org.ironhack.collections.ironschool.Service;

import org.ironhack.collections.ironschool.Model.Course;
import org.ironhack.collections.ironschool.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private List<Course> courses;

    public CourseService() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Course getCourseById(String courseId) {
        for (Course course : courses) {
            if(course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }


    public String enrollStudent(String courseId) {
        Course c = getCourseById(courseId);
        if(c != null) {
            c.enrollStudent();
            return "Student enrolled in course " + c.getName();
        } else {
            return "Course ID not found";
        }
    }

    public String assignTeacher(String courseId, Teacher teacher) {
        Course c = getCourseById(courseId);
        if(c != null) {
            c.assignTeacher(teacher);
            return "Teacher " + teacher.getName() + " assigned to course " + c.getName();
        } else {
            return "Course ID not found";
        }
    }

    public double getTotalMoneyEarned() {
        double total = 0.0;
        for (Course c : courses) {
            total += c.getMoneyEarned();
        }
        return total;
    }

    public void showAllCourses() {
        if(courses.isEmpty()) {
            System.out.println("No course available");
            return;
        }
        for(Course c : courses) {
            System.out.println(c.getCourseId() + " - " + c.getName());
        }
    }
}