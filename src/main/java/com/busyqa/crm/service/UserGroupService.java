package com.busyqa.crm.service;


import com.busyqa.crm.model.auth.DTOUserGroup;
import com.busyqa.crm.model.auth.UserGroup;
import com.busyqa.crm.repo.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserGroupService {

    @Autowired
    private UserGroupRepository userGroupRepository;

    public UserGroup createUserGroup(DTOUserGroup dtoUserGroup) {

        UserGroup userGroupToSave = userGroupRepository
                .findByRoleAndGroups(dtoUserGroup.getRole(), dtoUserGroup.getGroups()).orElse(new UserGroup());

        userGroupToSave.setRole(dtoUserGroup.getRole());
        userGroupToSave.setGroups(dtoUserGroup.getGroups());
        this.userGroupRepository.save(userGroupToSave);

        return userGroupToSave;
    }


    public List<DTOUserGroup> getAllUsersGroups() {

        List<UserGroup> ug = userGroupRepository.findAll();

        if (ug.isEmpty()) throw new RuntimeException("Empty User-Group list!");

        List<DTOUserGroup> ugResponses = new ArrayList<>();

        System.out.println(ug.size());

        for (UserGroup l: ug) {
            ugResponses.add(getUserGroup(l));
        }
        return ugResponses;
    }

    public ResponseEntity<?> deleteUserGroupById(Long id) {
        return userGroupRepository.findById(id).map(
                record -> {
                    userGroupRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());

    }


    /**
     * @param l
     * @return
     */
    public DTOUserGroup getUserGroup(UserGroup l) {
        return new DTOUserGroup(
                l.getId(),
                l.getRole(),
                l.getGroups()

        );

    }

}
