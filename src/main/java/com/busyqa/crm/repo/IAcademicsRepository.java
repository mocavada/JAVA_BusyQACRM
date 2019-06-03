package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.academics.Course;

import java.util.List;

public interface IAcademicsRepository {
    // CLASS
    List<Class> getAllClass();
    void addClass(Class classes);
    Class getClassById(long id);
    void updateClass(Class classes);
    void deleteClassById(int id);

    // COURSE
    List<Course> getAllCourse();
    void addCourse(Course course);
    Course getCourseById(int id);
    void updateCourse(Course course);
    void deleteCourseById(int id);


}
