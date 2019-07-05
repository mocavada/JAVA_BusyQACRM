package com.busyqa.crm.repo;

import com.busyqa.crm.model.auth.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface UserGroupRepository extends JpaRepository<UserGroup, Long> {


    Optional<UserGroup> findById(Long id);
    Optional<UserGroup> findByRoleAndGroups(String role, String group);
    List<UserGroup> findAll();




//    @Query("select p from UserGroup p where p.role = :role")
//    List<UserGroupRepository> findUserGroupByRole(@Param("role") String role);
//
//    @Query("select p from UserGroup p where p.groups = :groups")
//    List<UserGroupRepository> findUserGroupByGroups(@Param("groups") String groups);
//
//    @Query("select p from UserGroup p where p.role = :role and p.groups = :groups")
//    List<UserGroup> findUserGroupByRoleAndGroups(@Param("role") String role,@Param("groups") String groups);

}
