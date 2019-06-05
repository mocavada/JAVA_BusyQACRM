import { Course } from './../../model/course';
import { JWT_OPTIONS } from '@auth0/angular-jwt';
import { Client } from './../../model/client';
import { SalesApiService } from './../../services/_sales-api.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';


@Component({
  selector: 'app-add-lead',
  templateUrl: './add-lead.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class AddLeadComponent implements OnInit {

  private sub: Subscription;
  editForm: FormGroup;
  validMessage = '';
  message: string;
  leadExample: any;
  courseList: Course[];
  showCourse: boolean;
  showAddress: boolean;

  paymentPlanList = [
    'One_Time_Credit_Card',
    'One_Time_Debit_Card_Or_Cash',
    'One_Time_Email_Money',
    'Automated_Weekly',
    'Automated_BiWeekly'
  ];

  leadSourceList = [
    'Advertisement',
    'Cold_Call',
    'Employee_Referral',
    'External_Referral',
    'Online_Store',
    'Partner',
    'Public_Relations',
    'Sales_Email_Alias',
    'Seminar_Partner',
    'Internal_Seminar',
    'Trade_Show',
    'Web_Download',
    'Web_Research',
    'Chat'
  ];

  constructor(private salesService: SalesApiService,
              private route: ActivatedRoute,
              private fb: FormBuilder) {
        this.showCourse = true;
        this.showAddress = true;
}

  ngOnInit() {
    this.updateForm();
  }

  toggleCourseDisplay() {
    console.log(this.showCourse);
    this.showCourse = !this.showCourse;
  }
  toggleAddressDisplay() {
    console.log(this.showAddress);
    this.showAddress = !this.showAddress;
  }

  updateForm() {
    // const formControls = this.rolesArray.map(control => new FormControl(false));
    this.editForm = this.fb.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required],
      registrationFeePaid: false,
      paymentPlan: '',
      paymentPlanStatus: '',
      leadSource: '',
      leadStatus: '',
      currentlyEmployed: '',
      currentlyITEmployed: '',
      comments: '',
      course: this.fb.group({
        id: [0],
      }),
      mailingStreet: '',
      mailingCity: '',
      mailingState: '',
      mailingZip: '',
      mailingCountry: '',
    });

  }

}
