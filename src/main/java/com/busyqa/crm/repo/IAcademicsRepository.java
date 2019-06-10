package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.academics.Course;

import java.util.List;

public interface IAcademicsRepository {
    // CLASS
    List<Class> getAllClass();
    void addClass(Class classes);
    Class getClassById(long id);



    // COURSE
    void addCourse(Course course);
    void addClass(Integer classId, Integer courseId);

    List<Course> getAllCourse();

    Course getCourseById(int id);

    boolean courseExist(String name);


}
