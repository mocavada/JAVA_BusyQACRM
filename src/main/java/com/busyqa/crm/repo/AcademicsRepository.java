package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.*;
import com.busyqa.crm.model.academics.Class;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
@Transactional
@Repository
public class AcademicsRepository implements AcademicsRepositoryI {

    @PersistenceContext
    private EntityManager entityManager;

    //////////////
    // COURSES
    //////////////
    @Override
    public void addCourse(Course course) {
        entityManager.persist(course);
    }


    public List<Course> getAllCourse() {
        String jpql = "SELECT j FROM Course j ORDER BY j.id DESC";
        return (List<Course>) entityManager.createQuery(jpql)
                .setMaxResults(12)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public Course getCourseById(int id) {
        return entityManager.find(Course.class,id);

    }

    @Override
    public boolean courseExist(String name) {
        String jpql = "from Course as a WHERE a.name =: name";

        int count = entityManager.createQuery(jpql)
                .setParameter("name",name)
                .getResultList().size();

        return count > 0;
    }

    @Override
    public Optional<Course> findByCourseName(String name) {

        String jpql = "from Course as a WHERE a.name =: name";

        return (Optional<Course>) entityManager.createQuery(jpql)
                .setParameter("name",name)
                .getResultStream()
                .collect(Collectors.toList());
    }


    //////////////
    // CLASS
    //////////////
    @Override
    public void addClassByCourseId(Integer classId, Integer courseId) {
        Course course = getCourseById(courseId);
        Class isClass = getClassById(classId);
        course.addClass(isClass);
        entityManager.flush();
    }


    @Override
    public List<Class> getAllClass() {
        String jpql = "SELECT j FROM Class j ORDER BY j.id";
        return (List<Class>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }



    @Override
    public Class getClassById(int id) {
        return entityManager.find(Class.class,id);
    }

    //////////////
    // COURSE SCHEDULE
    //////////////
    @Override
    public List<CourseSchedule> getAllCourseSchedule() {

        String jpql = "SELECT j FROM CourseSchedule j ORDER BY j.id DESC";
        return (List<CourseSchedule>) entityManager.createQuery(jpql)
                .setMaxResults(12)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addCourseSchedule(CourseSchedule courseSchedule) {

        entityManager.persist(courseSchedule);
    }

    @Override
    public CourseSchedule getCourseScheduleById(int id) {

        return entityManager.find(CourseSchedule.class,id);
    }

    @Override
    public boolean courseScheduleExist(String name) {
        String jpql = "from CourseSchedule as a WHERE a.name =: name";

        int count = entityManager.createQuery(jpql)
                .setParameter("name",name)
                .getResultList().size();

        return count > 0;
    }

    //////////////
    // TRAINER
    //////////////
    @Override
    public List<Trainer> getAllTrainer() {

        String jpql = "SELECT j FROM Trainer j ORDER BY j.id DESC";
        Query query = entityManager.createQuery(jpql);


        return (List<Trainer>) entityManager.createQuery(jpql)
                .setMaxResults(12)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addTrainer(Trainer trainer) {
        entityManager.persist(trainer);
    }

    @Override
    public Trainer getTrainerById(int id) {

        return entityManager.find(Trainer.class,id);
    }

    @Override
    public boolean trainerExist(String trainerName) {
        String jpql = "from Trainer as a WHERE a.trainerName =: trainerName";

        int count = entityManager.createQuery(jpql)
                .setParameter("trainerName",trainerName)
                .getResultList().size();

        return count > 0;
    }

    //////////////
    // TRAINING LOCATION
    //////////////
    @Override
    public List<TrainingLocation> getAllTrainingLocation() {

        String jpql = "SELECT j FROM TrainingLocation j ORDER BY j.id DESC";
        return (List<TrainingLocation>) entityManager.createQuery(jpql)
                .setMaxResults(12)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addTrainingLocation(TrainingLocation trainingLocation) {

        entityManager.persist(trainingLocation);
    }

    @Override
    public TrainingLocation getTrainingLocationById(int id) {

        return entityManager.find(TrainingLocation.class,id);
    }

    @Override
    public boolean trainingLocationExist(String name) {
        String jpql = "from TrainingLocation as a WHERE a.name =: name";

        int count = entityManager.createQuery(jpql)
                .setParameter("name",name)
                .getResultList().size();

        return count > 0;
    }


}

