import { AuditApiService } from './../../services/_audit-api.service';
import { Component, OnInit } from '@angular/core';
import { Student } from '../../model/client-student';
import { SearchItemPipe } from '../../services/search-item.pipe';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-search-student',
  templateUrl: './search-student.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class SearchStudentComponent implements OnInit {

  studentList: Student[];
  student: any;
  query: string;
  currentStudent: object;
  searchItem: SearchItemPipe;


  constructor(private http: HttpClient,
              private auditService: AuditApiService) {
                this.query = '';
              }

  ngOnInit() {
    this.auditService.studentResult$.subscribe(data => {
      if (data != null) {
        this.studentList = data;
        console.log('Successful Loading Student List!');
        console.log(this.studentList);
      }
    });

    this.auditService.getAllStudent();
    console.log(this.studentList);
  }

  showStudent(item: any) {
    this.query = item.firstName;
    item.highlight = !item.highlight;
    this.currentStudent = item;
  }

}
