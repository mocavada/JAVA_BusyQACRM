package com.busyqa.crm.repo;

import com.busyqa.crm.model.academics.Class;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IClassRepository {
    List<Class> getAllClass();
    void addClass(Class classes);
    Class getClassById(long id);
    void updateClass(Class classes);
    void deleteClassById(int id);
}
