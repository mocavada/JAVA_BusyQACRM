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

    @Override
    public void addCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public void addClass(Integer classId, Integer courseId) {
        Course course = getCourseById(courseId);
        Class isClass = getClassById(classId);
        course.addClass(isClass);
        entityManager.flush();
    }


    // COURSES
    public List<Course> getAllCourse() {
        String jpql = "SELECT j FROM Course j ORDER BY j.id";
        return (List<Course>) entityManager.createQuery(jpql)
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

    }


    @Override
    public Class getClassById(long id) {
        return entityManager.find(Class.class,id);
    }

}
