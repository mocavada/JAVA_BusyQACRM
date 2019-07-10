import { CourseSchedule } from './../../model/academics-courseschedule';

import { SalesApiService } from './../../services/_sales-api.service';

import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-courseschedule-list',
  templateUrl: './courseschedule-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class CoursescheduleListComponent implements OnInit {

  courseScheduleList: CourseSchedule[];

  constructor(private salesService: SalesApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.salesService.courseScheduleResult$.subscribe(data => {
      if (data != null) {
        this.courseScheduleList = data;
        console.log('Successful Loading Course Schedule List!');
        console.log(this.courseScheduleList);
      }
    });

    this.salesService.getAllCourseSchedules();
    console.log(this.courseScheduleList);

  }

}
