package com.genspark.CourseApplicationDemo.Services;

import com.genspark.CourseApplicationDemo.Entity.Course;

import java.util.List;

public interface CourseApplication {

  public List<Course> getAllCourses();

  public Course getCourse(long courseId);

  public Course addCourse(Course course);

  public Course updateCourse(Course course);

  public String deleteCourse(long courseId);
}

