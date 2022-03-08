package com.genspark.CourseApplicationDemo.Services;

import com.genspark.CourseApplicationDemo.Entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.ArrayList;
import java.util.List;


@Service //this page acts as a service now.
public class CourseApplicationImpl implements CourseApplication{

  List<Course> list;
  private long courseID;

  public CourseApplicationImpl(){
    list = new ArrayList<>();
    list.add(new Course(123L, "Java", "This Course Contains Core Java"));
    list.add(new Course(134L, "Spring Boot", "This Course Contains Spring Boot"));
    list.add(new Course(169L, "Third Course", "Testing this OUT!"));
  }


  @Override
  public List<Course> getAllCourses() {
    return list;
  }

  @Override
  public Course getCourse(long courseId) {
    this.courseID = courseId;
    Course c =null;

    for(Course course:list) {
      if(course.getId()== this.courseID) {
        c=course;
        break;
      }
    }
    return c;
  }

  @Override
  public Course addCourse(Course course) {
    list.add(course);
    return course;
  }

  @Override
  public Course updateCourse(Course course) {
    Course edited = null;
    String title = course.getTitle();
    String desc = course.getDescription();

    for(Course c : list) {
      if(c.getId() == course.getId()) {
        c.setTitle(title);
        c.setDescription(desc);
        edited = c;
        break;
      }
    }
    return edited;
  }

  @Override
  public String deleteCourse(long courseId) {
    list.removeIf(course -> course.getId() == courseId);
    return "Course deleted: " + courseId ;
  }


}


