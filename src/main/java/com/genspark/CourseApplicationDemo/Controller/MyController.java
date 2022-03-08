package com.genspark.CourseApplicationDemo.Controller;


import com.genspark.CourseApplicationDemo.Entity.Course;
import com.genspark.CourseApplicationDemo.Services.CourseApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class MyController {

  @Autowired
  private CourseApplication courseService;
  @GetMapping("/")
  public String home(){
    return "<h1> Welcome to Course Application!</h1>";
  }

  //get all the courses
  @GetMapping("/courses")
  public List<Course> getAllCourses(){
    return this.courseService.getAllCourses();
  }

  //get the particular course{courseId}
  @GetMapping("/courses/{courseId}")
  public Course getCourse(@PathVariable String courseId) {
    return this.courseService.getCourse(Long.parseLong(courseId));
  }

  //add a new course
  @PostMapping("/courses")
  public Course addCourse(@RequestBody Course course){
    return this.courseService.addCourse(course);
  }

  //update a course
  @PutMapping("/courses")
  public Course updateCourse(@RequestBody Course course) {
      return this.courseService.updateCourse(course);
    }

  @DeleteMapping("/courses/{courseId}")
  public String deleteCourse(@PathVariable String courseId){
    return this.courseService.deleteCourse(Long.parseLong(courseId));
  }

}


  //delete a course{courseId}
