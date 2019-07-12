package com.busyqa.crm.service;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.academics.*;
import com.busyqa.crm.repo.AcademicsRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class AcademicsService {

    @Autowired
    private AcademicsRepositoryI academicsRepository;

    // COURSE
    //////////////
    public synchronized boolean addCourse(Course course) {
        if( academicsRepository.courseExist(course.getName())) {
            return false;
        } else {
            academicsRepository.addCourse(course);
            return true;
        }
    }

    public List<Course> getAllCourse() {
        return academicsRepository.getAllCourse(); }


    public Course getCourseById(int id) {
        return academicsRepository.getCourseById(id);
    }

    public void addClassByCourseId(Integer classId, Integer courseId) {
        academicsRepository.addClassByCourseId(classId, courseId);
    }


    // CLASS
    //////////////
    public List<Class> getAllClass() { return academicsRepository.getAllClass(); }
    public Class getClassById(int id) { return academicsRepository.getClassById(id); }


    // COURSE SCHEDULE
    //////////////
    public List<CourseSchedule> getAllCourseSchedule() {
        return academicsRepository.getAllCourseSchedule(); }


    public CourseSchedule getCourseScheduleById(int id) {

        return academicsRepository.getCourseScheduleById(id);
    }

    public synchronized boolean addCourseSchedule(CourseSchedule courseSchedule) {
        if( academicsRepository.courseScheduleExist(courseSchedule.getName())) {
            return false;
        } else {
            academicsRepository.addCourseSchedule(courseSchedule);
            return true;
        }

    }


    // TRAINER
    //////////////
    public List<Trainer> getAllTrainer() {
        return academicsRepository.getAllTrainer(); }


    public Trainer getTrainerById(int id) {
        return academicsRepository.getTrainerById(id);
    }

    public synchronized boolean addTrainer(Trainer trainer) {
        if( academicsRepository.trainerExist(trainer.getTrainerName())) {
            return false;
        } else {
            academicsRepository.addTrainer(trainer);
            return true;
        }
    }


    // TRAINING LOCATION
    //////////////
    public List<TrainingLocation> getAllTrainingLocation() {
        return academicsRepository.getAllTrainingLocation(); }


    public TrainingLocation getTrainingLocationById(int id) {
        return academicsRepository.getTrainingLocationById(id);
    }

    public synchronized boolean addTrainingLocation(TrainingLocation trainingLocation) {

            academicsRepository.addTrainingLocation(trainingLocation);
            return true;

    }


}
