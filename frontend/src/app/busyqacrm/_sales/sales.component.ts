import { SalesApiService } from '../services/_sales-api.service';
import { Component, OnInit } from '@angular/core';

import { UserResponse } from '../model/user-response';
import { TokenStorageService } from '../security/token-storage.service';
import {Router} from '@angular/router';




@Component({
  selector: 'app-sales',
  templateUrl: './sales.component.html',
  styleUrls: ['.././busyqacrm.component.css']
})

export class SalesComponent implements OnInit {
  errorMessage: string;
  roles: string[];
  authority: string;
  username: string;


  constructor(private tokenStorage: TokenStorageService,
              private salesService: SalesApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.roleAccess();
  }

  roleAccess() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();

    // Find the User ROLE
      this.roles.find(role => {
        if (this.roles.includes('ROLE_ADMIN' || 'ADMIN')) {
          this.authority = 'admin';
          return false;
        } else if (this.roles.includes('ROLE_AUDIT' || 'AUDIT')) {
          this.authority = 'audit';
          return false;
        } else if (this.roles.includes('ROLE_SALES' || 'SALES')) {
          this.authority = 'sales';
          return false;
        } else {
          this.authority = 'user';
          return true;
        }
      });

  //     // Find the User USERNAME
      this.username = this.tokenStorage.getUsername();
    }
  }
}


// this.username = this.token.getUsername();

    // this.userService.getUserInfo(this.username).subscribe(
    //   data => {
    //     this.user = data.result;
    //     console.log(this.user);
    //   },
    //   error => {
    //     this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
    //   }
    // );
