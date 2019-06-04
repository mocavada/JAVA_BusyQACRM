import { AuditApiService } from './../services/_audit-api.service';
import { Client } from './../model/client';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';



@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styleUrls: ['.././busyqacrm.component.css']
})
export class AuditComponent implements OnInit {

  errorMessage: string;
  studentList: Client[];

  constructor(private auditService: AuditApiService,
              private router: Router) { }

  ngOnInit() {

}

}


// this.userService.getPmUserByTeam().subscribe(
    //     data => {
    //       this.users = data.result;
    //       console.log(this.users);
    //     },
    //     error => {
    //       this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
    //     }
    //   );
    // }
