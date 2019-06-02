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
public class CourseRepository implements ICourseRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
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
    public Course getCourseById(long id) {
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
}
