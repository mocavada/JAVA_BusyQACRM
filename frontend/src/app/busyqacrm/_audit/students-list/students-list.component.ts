import { Student } from './../../model/client-student';
import { AuditApiService } from './../../services/_audit-api.service';

import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class StudentsListComponent implements OnInit {

  errorMessage: string;

  studentList: Student[];

  constructor(private auditService: AuditApiService,
              private router: Router) { }

  ngOnInit() {
    this.auditService.studentResult$.subscribe(data => {
      if (data != null) {
        this.studentList = data;
        console.log('Successful Loading Students List!');
        console.log(this.studentList);
      }
    });

    this.auditService.getAllStudent();
    console.log(this.studentList);
}

}
