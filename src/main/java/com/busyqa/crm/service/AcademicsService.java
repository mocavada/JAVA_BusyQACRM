package com.busyqa.crm.service;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.academics.Course;
import com.busyqa.crm.model.clients.Client;
import com.busyqa.crm.repo.IAcademicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AcademicsService {

    @Autowired
    private IAcademicsRepository academicsRepository;


    // COURSE //
    public synchronized boolean addCourse(Course course) {
        if( academicsRepository.courseExist(course.getName())) {
            return false;
        } else {
            academicsRepository.addCourse(course);
            return true;
        }
    }

    public void addClass(Integer classId, Integer courseId) {
        academicsRepository.addClass(classId, courseId);
    }


    public List<Course> getAllCourse() {
        return academicsRepository.getAllCourse(); }




    public Course getCourseById(int id) { return academicsRepository.getCourseById(id); }





    // CLASS //
    public List<Class> getAllClass() { return academicsRepository.getAllClass(); }
    public void addClass(Class classes) { academicsRepository.addClass(classes); }

    public Class getClassById(long id) { return academicsRepository.getClassById(id); }



}
