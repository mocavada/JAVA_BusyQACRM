package com.busyqa.crm.repo;

import com.busyqa.crm.model.auth.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserGroupJpaRepository extends JpaRepository<UserGroup, Long> {
    List<UserGroup> findByUser_Username(String username);
//    List<UserGroup> findByUsername(String username);
}
