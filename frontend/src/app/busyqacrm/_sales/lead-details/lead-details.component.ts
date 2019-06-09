import { Course } from './../../model/course';
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
editCLientForm: FormGroup;
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
    this.updateForm();

    this.salesService.courseResult$
    .subscribe(data => {
      if (data != null) {
        console.log('Courses' + data);
        this.courseList = data;
      }
    });

    this.salesService.getCourseList();

    this.sub = this.route.paramMap.subscribe(
      params => {
        const email = params.get('email');
        this.getLead(email);
      }
    );
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
    this.editCLientForm = this.fb.group({
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
        id: [0]
      }),
      // BOOLEAN STATUS
      registrationFeePaid: false,
      planAgreement: false,
      currentlyEmployed: false,
      currentlyITEmployed: false,
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
    if (this.editCLientForm) {
      this.editCLientForm.reset();
    }
    this.leadExample = data;

    this.editCLientForm.patchValue({
      // BASIC
      id: this.leadExample.id,
      clientStatus: this.leadExample.clientStatus,
      firstName: this.leadExample.firstName,
      lastName: this.leadExample.lastName,
      phone: this.leadExample.phone,
      email: this.leadExample.email,
      emergencyPhone: this.leadExample.emergencyPhone,
      comments: this.leadExample.comments,
      // ACADEMICS
      course: this.leadExample.course,
      courseid: this.leadExample.course.id,
      coursename: this.leadExample.course.name,
      // BOOLEAN STATUS
      registrationFeePaid: this.leadExample.registrationFeePaid,
      planAgreement: this.leadExample.planAgreement,
      currentlyEmployed: this.leadExample.currentlyEmployed,
      currentlyITEmployed: this.leadExample.currentlyITEmployed,
      // STATUS
      leadStatus: this.leadExample.leadStatus,
      leadSource: this.leadExample.leadSource,
      paymentPlan: this.leadExample.paymentPlan,
      // NOT USED
      desiredJob: this.leadExample.desiredJob,
      paymentPlanStatus: this.leadExample.paymentPlanStatus,
      // ADDRESS
      mailingStreet: this.leadExample.mailingStreet,
      mailingCity: this.leadExample.mailingCity,
      mailingState: this.leadExample.mailingState,
      mailingZip: this.leadExample.mailingZip,
      mailingCountry: this.leadExample.mailingCountry,
      createdTime: this.leadExample.createdTime,
    });

  }

  onUpdate() {
    if (this.editCLientForm.valid) {
      this.validMessage = 'Your information has been updated!';
      this.salesService
      .updateLeadLead(this.route.snapshot.params.email, this.editCLientForm.value)
      .subscribe(
        data => {
          this.message = 'The lead has been updated!';
          return true;
        },
        error => {
          alert('Couldnt update this lead!'); });
    } else {
      this.validMessage = 'Please make sure the inputs are valid!';
    }
  }

  // onUpdate(editForm: any) {
  //   if (this.editForm.valid) {
  //     console.log('This form is good to go.');
  //     this.salesService.updateLead(editForm.value);
  //   } else {
  //     console.log(editForm.value);
  //   }
  // }



  // onUpdate(editForm: any) {
  //   if (this.editForm.valid) {
  //     this.validMessage = 'Your information has been updated!';
  //     this.salesService
  //     .updateLead(this.editForm.value)
  //     .subscribe(
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


  // deleteLead() {
  //   if (confirm('Are you sure you want to delete this lead?')) {
  //     this.salesService.deleteClient(this.route.snapshot.params.id)
  //     .subscribe(
  //       () => this.editForm.reset(),
  //       (error: any) => console.error(error)
  //     );
  //   }
  // }

  onConvertToStudent() {
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
    }

  // }

}

