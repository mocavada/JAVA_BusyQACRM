package com.busyqa.crm.repo;

import com.busyqa.crm.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends JpaRepository<T, Long> {

    Optional<T> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<T> findAll();

    List<T> findByUsergroups_Groups(String group);
    List<T> findByUsergroups_Role(String role);


    @Modifying
    @Transactional
    @Query("delete from #{#entityName} as u where u.username = :username")
    void deleteByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query("delete from #{#entityName} as u where u.email = :email")
    void deleteByEmail(@Param("email") String email);

    @Query("select u from #{#entityName} as u")
    List<T> findAllWithUsergroups();

}
