package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.*;
import com.busyqa.crm.model.academics.Class;

import java.util.List;
import java.util.Optional;

public interface AcademicsRepositoryI {
    // COURSE
    void addCourse(Course course);
    List<Course> getAllCourse();
    Course getCourseById(long id);
    boolean courseExist(String name);
    Optional<Course> findByCourseName(String name);


    // CLASS
    void addClassByCourseId(Integer classId, Integer courseId);
    List<Class> getAllClass();
    Class getClassById(long id);

    // COURSE SCHEDULE
    List<CourseSchedule> getAllCourseSchedule();
    void addCourseSchedule(CourseSchedule courseSchedule);
    CourseSchedule getCourseScheduleById(long id);
    boolean courseScheduleExist(String name);

    // TRAINER
    List<Trainer> getAllTrainer();
    void addTrainer(Trainer trainer);
    Trainer getTrainerById(long id);
    boolean trainerExist(String name);

    // TRAINING LOCATION
    List<TrainingLocation> getAllTrainingLocation();
    void addTrainingLocation(TrainingLocation trainingLocation);
    TrainingLocation getTrainingLocationById(long id);
    boolean trainingLocationExist(String name);


}
