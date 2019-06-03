package com.busyqa.crm.service;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.academics.Course;
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


    // CLASS //
    public List<Class> getAllClass() { return academicsRepository.getAllClass(); }
    public void addClass(Class classes) { academicsRepository.addClass(classes); }
    public void updateClass(Class classes) { academicsRepository.updateClass(classes); }
    public Class getClassById(long id) { return academicsRepository.getClassById(id); }
    public void deleteClassById(int id) { academicsRepository.deleteClassById(id); }

    // COURSE //
    public List<Course> getAllCourse() { return academicsRepository.getAllCourse(); }
    public void addCourse(Course course) { academicsRepository.addCourse(course); }
    public void updateCourse(Course course) { academicsRepository.updateCourse(course); }
    public Course getCourseById(int id) { return academicsRepository.getCourseById(id); }
    public void deleteCourseById(int id) { academicsRepository.deleteCourseById(id); }
    public void addClass(int classId, int courseId) {
        academicsRepository.addClassToCourse(classId,courseId);
    }


}
