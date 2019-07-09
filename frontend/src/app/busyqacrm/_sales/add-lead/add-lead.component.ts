import { Course } from './../../model/academics-course';

import { JWT_OPTIONS } from '@auth0/angular-jwt';

import { SalesApiService } from '../../services/_sales-api.service';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators, FormControl, ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';


@Component({
  selector: 'app-add-lead',
  templateUrl: './add-lead.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class AddLeadComponent implements OnInit {

  @Input() authority: any;

  private sub: Subscription;
  createClientForm: FormGroup;
  validMessage = '';
  message: string;
  leadExample: any;
  courseList: Course[];
  showCourse: boolean;
  showAddress: boolean;

  leadStatus = [
    'For Payment', 'Interested', 'Request Info', 'For Deletion'
  ];
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
    this.createForm();

    this.salesService.courseResult$
    .subscribe(data => {
      if (data != null) {
        console.log(data);
        this.courseList = data;
      }
    });
    this.salesService.getAllCourse();
  }

  toggleCourseDisplay() {
    console.log(this.showCourse);
    this.showCourse = !this.showCourse;
  }
  toggleAddressDisplay() {
    console.log(this.showAddress);
    this.showAddress = !this.showAddress;
  }

  createForm() {
    this.createClientForm = this.fb.group({
      // BASIC
      id: '',
      clientStatus: '',
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', Validators.required],
      emergencyPhone: '',
      comments: '',
      // ACADEMICS
      course: this.fb.group({
        id: '',
      }),
      // BOOLEAN STATUS
      registrationFeePaid: false,
      planAgreement: false,
      currentlyEmployed: false,
      currentlyITEmployed: false,
      // PAYMENT
      registrationFee: '',
      // STATUS
      leadStatus: '',
      paymentPlan: '',
      leadSource: '',
      // NOT USED
      desiredJob: '',
      paymentPlanStatus: '',
      // ADDRESS
      mailingStreet: '',
      mailingCity: '',
      mailingState: '',
      mailingZip: '',
      mailingCountry: '',
    });

  }

  // onSubmit(f: any) {
  //   if (f.valid) {
  //     this.validMessage = 'Your information has been saved. Thank you!';
  //     console.log('This form is good to go.');
  //     this.salesService.postClient(f.value);
  //     this.createClientForm.reset();
  //   } else {
  //     console.log(f.value);
  //   }
  // }

}
