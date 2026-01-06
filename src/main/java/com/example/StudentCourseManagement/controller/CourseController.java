package com.example.StudentCourseManagement.controller;

import com.example.StudentCourseManagement.model.Course;
import com.example.StudentCourseManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = "http://127.0.0.1:5500/")
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    public CourseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }
    @GetMapping
    public List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @PutMapping("/{id}")
    public Course updateCourse(
            @PathVariable Long id,
            @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
    @GetMapping("/count")
    public Long getCourseCount(){
        return courseService.getCourseCount();
    }

    @GetMapping("/courses")
    public List<Course> getCoursesByCredit(@RequestParam String title){
        return courseService.getCourseByTitle(title);
    } 

    @GetMapping("/filter")
    public List<Course> findByCredit(@RequestParam Integer credit) {
        return courseService.getCourseByCredit(credit);
    }
 @GetMapping("/courses/search")
  public List<Course> getCourseByTitleAndCredit(
        @RequestParam String title,
        @RequestParam Integer credit) {

    return courseService.getCourseByTitleAndCredit(title, credit);
}

}

