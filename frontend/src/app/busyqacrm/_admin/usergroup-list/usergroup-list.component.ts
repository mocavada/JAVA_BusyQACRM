import { AdminApiService } from './../../services/_admin-api.service';
import { Usergroup } from './../../model/auth-usergroup';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-usergroup-list',
  templateUrl: './usergroup-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class UsergroupListComponent implements OnInit {

  userGroupList: Usergroup[];

  constructor(private adminService: AdminApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.adminService.userGroupResult$.subscribe(data => {
      if (data != null) {
        this.userGroupList = data;
        console.log('Successful Loading User Group List!');
        console.log(this.userGroupList);
      }
    });

    this.adminService.getAllUserGroups();
    console.log(this.userGroupList);

  }

}
