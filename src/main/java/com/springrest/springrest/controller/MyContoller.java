package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyContoller {
    @Autowired
    private CourseService courseService;


    @GetMapping("/home")
    public String home() {

        return "Welcome to courses application";
    }

    //get the courses

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    //get a particular course with the course id
    @GetMapping("courses/{courseId}")
    public Course getCourse(@PathVariable String courseId) {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //add a course
    @PostMapping(path = "/courses", consumes = "application/json")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }
}
