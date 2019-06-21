package com.busyqa.crm.repo;

import com.busyqa.crm.model.auth.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface IUserGroupRepository extends JpaRepository<UserGroup, Long> {
//    List<UserGroup> findByUser_Username(String username);
//    List<UserGroup> findByUsername(String username);

    Optional<UserGroup> findById(Long id);

    Optional<UserGroup> findByRoleAndGroups(String role, String group);

    @Query("select p from UserGroup p where p.role = :role")
    List<IUserGroupRepository> findUserGroupByRole(@Param("role") String role);

    @Query("select p from UserGroup p where p.groups = :groups")
    List<IUserGroupRepository> findUserGroupByGroups(@Param("groups") String groups);

    @Query("select p from UserGroup p where p.role = :role and p.groups = :groups")
    List<UserGroup> findUserGroupByRoleAndGroups(@Param("role") String role,@Param("groups") String groups);



}
