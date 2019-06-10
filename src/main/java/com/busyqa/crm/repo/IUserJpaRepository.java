package com.busyqa.crm.repo;

import com.busyqa.crm.model.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IUserJpaRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    List<User> findAll();
    User save(User user);

    List<User> findByUserGroups_Groups(String groupName);
    List<User> findByUserGroups_Role(String roleName);

    @Modifying
    @Transactional
    @Query("delete from User u where u.username = :username")
    void deleteUsersByUsername(@Param("username") String username);

    @Query("select u from User u")
    List<User> findAllUsers();


    @Query("select u from User u where u.username = :username")
    User findUserByUsername(@Param("username") String username);

}
