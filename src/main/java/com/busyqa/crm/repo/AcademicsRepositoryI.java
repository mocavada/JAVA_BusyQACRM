package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.*;
import com.busyqa.crm.model.academics.Class;

import java.util.List;
import java.util.Optional;

public interface AcademicsRepositoryI {
    // COURSE
    void addCourse(Course course);
    List<Course> getAllCourse();
    Course getCourseById(int id);
    boolean courseExist(String name);
    Optional<Course> findByCourseName(String name);


    // CLASS
    void addClassByCourseId(Integer classId, Integer courseId);
    List<Class> getAllClass();
    Class getClassById(int id);

    // COURSE SCHEDULE
    List<CourseSchedule> getAllCourseSchedule();
    void addCourseSchedule(CourseSchedule courseSchedule);
    CourseSchedule getCourseScheduleById(int id);

    // TRAINER
    List<Trainer> getAllTrainer();
    void addTrainer(Trainer trainer);
    Trainer getTrainerById(int id);

    // TRAINING LOCATION
    List<TrainingLocation> getAllTrainingLocation();
    void addTrainingLocation(TrainingLocation trainingLocation);
    TrainingLocation getTrainingLocationById(int id);


}
