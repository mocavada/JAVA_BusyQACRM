package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Course;

import java.util.List;

public interface ICourseRepository {
    List<Course> getAllCourse();
    void addCourse(Course course);
    Course getCourseById(long id);
    void updateCourse(Course course);
    void deleteCourseById(int id);
}
