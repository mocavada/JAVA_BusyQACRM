package com.busyqa.crm.repo;

import com.busyqa.crm.model.auth.User;

import javax.transaction.Transactional;


@Transactional
public interface UserRepository extends UserBaseRepository<User> {

}
