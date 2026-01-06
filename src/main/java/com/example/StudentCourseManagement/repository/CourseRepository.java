package com.example.StudentCourseManagement.repository;

import com.example.StudentCourseManagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByTitleContainingIgnoreCase(String title);

    List<Course> findByCredit(Integer credit);

    List<Course> findByTitleContainingIgnoreCaseAndCredit(String title, Integer credit);
}

