import { Component, OnInit } from '@angular/core';
import { Lead } from '../../model/client-lead';
import { AdminApiService } from '../../services/_admin-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class UsersListComponent implements OnInit {

  leadList: Lead[];

  constructor(private adminService: AdminApiService,
              private router: Router) {

  }

  ngOnInit() {
    this.adminService.leadResult$.subscribe(data => {
      if (data != null) {
        this.leadList = data;
        console.log('Successful Loading User List!');
        console.log(this.leadList);
      }
    });

    this.adminService.getAllUsers();
    console.log(this.leadList);

  }

}
