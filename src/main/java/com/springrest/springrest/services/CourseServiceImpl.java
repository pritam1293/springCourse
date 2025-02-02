package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;
    public CourseServiceImpl() {

        list = new ArrayList<>();
        list.add(new Course(145,"Java core course","this course contains basics of java"));
        list.add(new Course(4343 , "Spring boot course" , "creating rest api using spring boot"));

    }


    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        return this.list.stream().filter(c -> c.getId() == courseId).findFirst().orElse(null);
    }

    @Override
    public Course addCourse(Course course) {
        this.list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        long courseId = course.getId();
        int n = list.size();

        for(int i = 0; i < n; i++) {
            if(list.get(i).getId() == courseId) {
                list.set(i,course);
                break;
            }
        }
        return course;
    }

    @Override
    public Course deleteCourse(long courseId) {
        Course c = null;
        int n = list.size();
        for(int i=0;i<n;i++) {
            if(list.get(i).getId() == courseId) {
                c = list.get(i);
                list.remove(i);
                break;
            }
        }
        return c;
    }
}
