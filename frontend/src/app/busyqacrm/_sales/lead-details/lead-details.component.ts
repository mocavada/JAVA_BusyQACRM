import { JWT_OPTIONS } from '@auth0/angular-jwt';
import { Client } from './../../model/client';
import { SalesApiService } from './../../services/_sales-api.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

import 'rxjs/add/operator/map';

@Component({
  selector: 'app-lead-details',
  templateUrl: './lead-details.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class LeadDetailsComponent implements OnInit {

private sub: Subscription;
editForm: FormGroup;
validMessage = '';
message: string;
leadExample: any;

paymentPlanList = [
  'One_Time_Credit_Card',
  'One_Time_Debit_Card_Or_Cash',
  'One_Time_Email_Money',
  'Automated_Weekly',
  'Automated_BiWeekly'
];
paymentPlanStatusList = [
  'CONFIRMED',
  'UNCONFIRMED'
];
test: any;

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
leadStatusList = [
  'CONFIRMED',
  'UNCONFIRMED'
];
currentYear = new Date().getFullYear().toString();
courseList = [
  'AUTOMATION_TESTING' ,
  'DATA_SCIENCE',
  'SCRUM_MASTER',
  'SOFTWARE_TESTING',
  'BUSINESS_ANALYSIS',
  'CERTIFIED_SCRUM_MASTER',
  'FULLSTACK_JAVA_DEVELOPER',
  'PERFORMANCE_TESTING',
  'AUTOMATION_TESTING_ONLINE',
  'DATA_SCIENCE_ONLINE',
  'SOFTWARE_TESTING_ONLINE'
];
termList = [
  'WINTER ' + this.currentYear,
  'SPRING ' + this.currentYear,
  'SUMMER ' + this.currentYear,
  'FALL ' + this.currentYear,
];
classList = [];


constructor(private salesService: SalesApiService,
            private route: ActivatedRoute,
            private fb: FormBuilder) {
}

  ngOnInit() {
    this.updateForm();
    this.sub = this.route.paramMap.subscribe(
      params => {
        const email = params.get('email');
        this.getLead(email);
      }
    );

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
      comments: '',
      course: ''
    });

  }


  getLead(email: string): void {
    this.salesService.getLeadByEmail(email)
    .subscribe(
      data => {
        console.log(data);
        this.displayForm(data);
        },
      (error: any) => console.error(error)
    );
  }

  displayForm(data: any): void {
    if (this.editForm) {
      this.editForm.reset();
    }

    this.leadExample = data;

    this.editForm.patchValue({
      firstName: this.leadExample.firstName,
      lastName: this.leadExample.lastName,
      phone: this.leadExample.phone,
      email: this.leadExample.email,

      registrationFeePaid: this.leadExample.registrationFeePaid,
      createdTime: this.leadExample.createdTime,
      currentlyEmployed: this.leadExample.currentlyEmployed,
      currentlyITEmployed: this.leadExample.currentlyITEmployed,

      desiredJob: this.leadExample.desiredJob,
      emergencyPhone: this.leadExample.emergencyPhone,
      leadStatus: this.leadExample.leadStatus,
      leadSource: this.leadExample.leadSource,

      comments: this.leadExample.comments,
      course: this.leadExample.course,
    });

  }

  // updateForm() {
  //   // const formControls = this.rolesArray.map(control => new FormControl(false));
  //   this.editForm = this.fb.group({
  //     firstName: ['', Validators.required],
  //     lastName: ['', Validators.required],
  //     phone: ['', Validators.required],
  //     email: ['', Validators.required],
  //     registrationFee: 0,
  //     paymentPlan: '',
  //     paymentPlanStatus: '',
  //     leadSource: '',
  //     leadStatus: '',
  //     comments: '',
  //     course: '',
  //   });

  // }

  // displayLeadInfo(data: any): void {
  //     if (this.editForm) {
  //       this.editForm.reset();
  //     }

  //     this.leadInfo = data;
  //     this.editForm.patchValue({
  //       firstName: this.leadInfo.firstName,
  //       lastName: this.leadInfo.lastName,
  //       phone: this.leadInfo.phone,
  //       email: this.leadInfo.email,
  //       registrationFee: this.leadInfo.registrationFee,
  //       paymentPlan: this.leadInfo.paymentPlan,
  //       paymentPlanStatus: this.leadInfo.paymentPlanStatus,
  //       leadSource: this.leadInfo.leadSource,
  //       leadStatus: this.leadInfo.leadStatus,
  //       comments: this.leadInfo.comments,
  //       course: this.leadInfo.course
  //   });
  // }

  // onUpdate() {
  //   if (this.editForm.valid) {
  //     this.validMessage = 'Your information has been updated!';
  //     this.salesService.updateLead(this.editForm.value).subscribe(
  //       data => {
  //         this.message = 'The lead has been updated!';
  //         return true;
  //       },
  //       error => {
  //         alert('Couldnt update this lead!'); });
  //   } else {
  //     this.validMessage = 'Please make sure the inputs are valid!';
  //   }
  // }

  // deleteLead() {
  //   if (confirm('Are you sure you want to delete this lead?')) {
  //     this.salesService.deleteClient(this.route.snapshot.params.id)
  //     .subscribe(
  //       () => this.editForm.reset(),
  //       (error: any) => console.error(error)
  //     );
  //   }
  // }

  // onConvertToStudent() {
  // tslint:disable-next-line:max-line-length
  //   if (! this.editForm.value.paidDeposit) {alert('You cannot convert this lead to a student because the deposite has not been paid yet!');
  //   } else {
  //     if (confirm('Are you sure you want to change this lead to a student?')) {
  //       this.deleteLead.changeLeadToStudent(this.route.snapshot.params.email)
  //       .subscribe(
  //         () => this.editForm.reset(),
  //         (error: any) => console.error(error)
  //       );
  //     }
  //   }

  // }
 
}
