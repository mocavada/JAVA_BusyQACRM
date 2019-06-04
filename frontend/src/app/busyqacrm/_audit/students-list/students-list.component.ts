import { AuditApiService } from './../../services/_audit-api.service';
import { Client } from './../../model/client';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class StudentsListComponent implements OnInit {

  errorMessage: string;

  studentList: Client[];

  constructor(private auditService: AuditApiService,
              private router: Router) { }

  ngOnInit() {
    this.auditService.clientResult$.subscribe(data => {
      if (data != null) {
        this.studentList = data;
        console.log('Successful Loading Students List!');
        console.log(this.studentList);
      }
    });

    this.auditService.getStudentsList();
    console.log(this.studentList);
}

}
