package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Class;
import com.busyqa.crm.model.clients.Lead;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Repository
public class ClassRepository implements IClassRepository {

    @PersistenceContext
    private EntityManager entityManager;


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
}
