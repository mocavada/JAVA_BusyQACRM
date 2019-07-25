import { AuditApiService } from './../services/_audit-api.service';

import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';



@Component({
  selector: 'app-audit',
  templateUrl: './audit.component.html',
  styleUrls: ['.././busyqacrm.component.css']
})
export class AuditComponent implements OnInit {

  errorMessage: string;


  constructor(private auditService: AuditApiService,
              private router: Router) { }

  ngOnInit() {

}

}


// this.userService.getPmUserByTeam().subscribe(
    //     data => {
    //       this.auth = data.result;
    //       console.log(this.auth);
    //     },
    //     error => {
    //       this.errorMessage = `${error.status}: ${JSON.parse(error.error).message}`;
    //     }
    //   );
    // }
