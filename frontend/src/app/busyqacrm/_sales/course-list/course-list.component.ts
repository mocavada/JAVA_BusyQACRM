import { SalesApiService } from './../../services/_sales-api.service';
import { Course } from './../../model/academics-course';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-course-list',
  templateUrl: './course-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class CourseListComponent implements OnInit {

  courseList: Course[];

  constructor(private salesService: SalesApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.salesService.courseResult$.subscribe(data => {
      if (data != null) {
        this.courseList = data;
        console.log('Successful Loading Lead List!');
        console.log(this.courseList);
      }
    });

    this.salesService.getAllCourse();
    console.log(this.courseList);

  }

}
