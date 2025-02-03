package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //update a course with a given course
    @PutMapping(path = "/courses",consumes = "application/json")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    //delete a course with a given courseId
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//    public Course deleteCourse(@PathVariable String courseId) {
//        return this.courseService.deleteCourse(Long.parseLong(courseId));
//    }
}
