package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.academics.Course;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class AcademicsRepository implements IAcademicsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // CLASSES
    @Override
    public List<Class> getAllClass() {
        String jpql = "SELECT j FROM Class j ORDER BY j.id";
        return (List<Class>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addClass(Class classes) {
        entityManager.persist(classes);
    }

    @Override
    public Class getClassById(long id) {
        return entityManager.find(Class.class,id);
    }

    @Override
    public void updateClass(Class classes) {
        Class updateClass = getClassById(classes.getId());
        updateClass.setName(classes.getName());
        updateClass.setDescription(classes.getDescription());
        updateClass.setCourse(classes.getCourse());
        updateClass.setUnits(classes.getUnits());
        entityManager.flush();
    }

    @Override
    public void deleteClassById(int id) {
        entityManager.remove(id);
    }



    // COURSES
    public List<Course> getAllCourse() {
        String jpql = "SELECT j FROM Course j ORDER BY j.id";
        return (List<Course>) entityManager.createQuery(jpql)
                .getResultStream()
                .collect(Collectors.toList());
    }

    @Override
    public void addCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course getCourseById(int id) {
        return entityManager.find(Course.class,id);

    }

    @Override
    public void updateCourse(Course course) {

        Course updateCourse = getCourseById(course.getId());
        updateCourse.setName(course.getName());
        updateCourse.setDescription(course.getDescription());
        updateCourse.setLocation(course.getLocation());
        updateCourse.setTrainer(course.getTrainer());
        updateCourse.setStartDate(course.getStartDate());
        updateCourse.setEndDate(course.getEndDate());
        updateCourse.setClasses(course.getClasses());
        entityManager.flush();
    }

    @Override
    public void deleteCourseById(int id) {
            entityManager.remove(id);
    }

    @Override
    public void addClassToCourse(int classId, int courseId) {
        Class classes = getClassById(classId);
        Course course = getCourseById(classId);

        course.addClass(classes);
        entityManager.flush();
    }


    @Override
    public boolean courseExist(String name) {
        String jpql = "from Client as a WHERE a.name =: name";
        int count = entityManager.createQuery(jpql)
                .setParameter("name",name)
                .getResultList().size();
        return count > 0;
    }
}
