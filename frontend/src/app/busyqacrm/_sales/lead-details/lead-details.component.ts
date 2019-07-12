import { AuditApiService } from './../../services/_audit-api.service';
import { Traininglocation } from './../../model/academics-traininglocation';
import { Mail } from '../../model/util-mail';
import { SalesApiService } from './../../services/_sales-api.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

import 'rxjs/add/operator/map';
import { Paymentplan } from '../../model/finance-paymentplan';
import { Course } from './../../model/academics-course';
import { CourseSchedule } from '../../model/academics-courseschedule';
import { Trainer } from './../../model/academics-trainer';
import { Lead } from '../../model/client-lead';
import { RegistrationFee } from '../../model/finance-registrationfee';
import { Discount } from '../../model/finance-discount';


@Component({
  selector: 'app-lead-details',
  templateUrl: './lead-details.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class LeadDetailsComponent implements OnInit {

  private sub: Subscription;
  editCLientForm: FormGroup;
  validMessage = '';
  confirmationMessage = '';
  message: string;
  mail: Mail;

  messageObject: any;
  welcomeString: any;
  showCourse: boolean;
  showAddress: boolean;
  isWPSent: boolean;
  isTISent: boolean;
  isPLSent: boolean;
  isWPSent1: boolean;

  leadExample: Lead;
  registrationFeeList: RegistrationFee[];
  discountList: Discount[];
  paymentPlanList: Paymentplan[];
  courseList: Course[];
  courseScheduleList: CourseSchedule[];
  trainerList: Trainer[];
  trainingLocationList: Traininglocation[];


  constructor(private salesService: SalesApiService,
              private auditService: AuditApiService,
              private route: ActivatedRoute,
              private fb: FormBuilder) {
      this.showCourse = true;
      this.showAddress = true;
      this.isWPSent = true;

  }

  toggleCourseDisplay() {
    console.log(this.showCourse);
    this.showCourse = !this.showCourse;
  }

  toggleAddressDisplay() {
    console.log(this.showAddress);
    this.showAddress = !this.showAddress;
  }

  ngOnInit() {
    this.updateForm();
    this.auditService.registrationFeeResult$.subscribe(data => {
      if (data != null) {
        this.registrationFeeList = data;
        console.log('Successful Loading registrationFeeList!');
        console.log(this.registrationFeeList);
      }
    });

    this.auditService.discountResult$.subscribe(data => {
      if (data != null) {
        this.discountList = data;
        console.log('Successful Loading discountList!');
        console.log(this.discountList);
      }
    });

    this.auditService.paymentPlanResult$.subscribe(data => {
      if (data != null) {
        this.paymentPlanList = data;
        console.log('Successful Loading paymentPlanList!');
        console.log(this.paymentPlanList);
      }
    });

    this.salesService.courseResult$.subscribe(data => {
      if (data != null) {
        this.courseList = data;
        console.log('Successful Loading courseList!');
        console.log(this.courseList);
      }
    });

    this.salesService.courseScheduleResult$.subscribe(data => {
      if (data != null) {
        this.courseScheduleList = data;
        console.log('Successful Loading courseScheduleList!');
        console.log(this.courseScheduleList);
      }
    });

    this.salesService.trainerResult$.subscribe(data => {
      if (data != null) {
        this.trainerList = data;
        console.log('Successful Loading trainerList!');
        console.log(this.trainerList);
      }
    });

    this.salesService.trainingLocationResult$.subscribe(data => {
      if (data != null) {
        this.trainingLocationList = data;
        console.log('Successful Loading trainingLocationList!');
        console.log(this.trainingLocationList);
      }
    });

    this.auditService.getAllRegistrationFee();
    this.auditService.getAllDiscount();
    this.auditService.getAllPaymentPlan();
    this.salesService.getAllCourse();
    this.salesService.getAllCourseSchedules();
    this.salesService.getAllTrainer();
    this.salesService.getAllTrainingLocation();

    // ** Get Email from Url and Use it as Parameter to getLead Api Request
    this.sub = this.route.paramMap.subscribe(
      params => {
        const email = params.get('email');
        this.getLead(email);
      }
    );
    console.log('welcome -' + this.welcomeString);

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

      // DATE
      createdTime: this.leadExample.createdTime,
      modifiedTime: this.leadExample.modifiedTime,

      // USER
      firstName: this.leadExample.firstName,
      lastName: this.leadExample.lastName,
      phone: this.leadExample.phoneNumber,
      email: this.leadExample.email,
      emergencyPhone: this.leadExample.emergencyPhone,
      dtype: this.leadExample.dtype,
      userState: this.leadExample.userState,

      // LEAD
      clientStatus: this.leadExample.clientStatus,
      leadSource: this.leadExample.leadSource,
      comments: this.leadExample.comments,
      currentlyEmployed: this.leadExample.isCurrentlyEmployed,
      currentlyITEmployed: this.leadExample.isCurrentlyITEmployed,
      desiredJob: this.leadExample.desiredJob,

       // ADDRESS
       mailingStreet: this.leadExample.mailingStreet,
       mailingCity: this.leadExample.mailingCity,
       mailingState: this.leadExample.mailingState,
       mailingZip: this.leadExample.mailingZip,
       mailingCountry: this.leadExample.mailingCountry,

       // BOOLEANS STATUS
       isRegistrationFeePaid: this.leadExample.isRegistrationFeePaid,
       isPlanAgreementSigned: this.leadExample.isPlanAgreementSigned,
       isDiscountGiven: this.leadExample.isDiscountGiven,
      // FINANCE PROPERTIES
      registrationFee: this.leadExample.registrationFee,
      discount: this.leadExample.discount,
      paymentPlan: this.leadExample.paymentPlan,
      // ACADEMICS PROPERTIES
      course: this.leadExample.course,
      totalCourseFee: this.leadExample.totalCourseFee,

      trainer: this.leadExample.trainer,
      trainingLocation: this.leadExample.trainingLocation
    });

    this.welcomeString = this.leadExample.firstName + '@' +
                         this.leadExample.course.name + '@' +
                         this.leadExample.course.description;

    console.log('Message Strings - ' + this.welcomeString);
  }

  // this.createTrainingLocationForm = this.fb.group({
  //   isOnLine: [],
  //   name: [],
  //   street: [],
  //   city: [],
  //   state: [],
  //   address: [],
  // });

  // console.log(this.isOnlineYes);

  updateForm() {
    this.editCLientForm = this.fb.group({
      // USER
      id: [],
      email: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phone: ['', Validators.required],
      emergencyPhone: [],

      // LEAD
      clientStatus: [],
      leadSource: [],
      comments: [],
      currentlyEmployed: [],
      currentlyITEmployed: [],
      desiredJob: [],

       // ADDRESS
       mailingStreet: [],
       mailingCity: [],
       mailingState: [],
       mailingZip: [],
       mailingCountry: [],

      // BOOLEANS
      isRegistrationFeePaid: [],
      isPlanAgreementSigned: [],
      isDiscountGiven: [],

      // FINANCE PROPERTIES
      registrationFee: this.fb.group({
        id: []
      }),
      discount: this.fb.group({
        id: []
      }),
      paymentPlan: this.fb.group({
        id: []
      }),

      // ACADEMICS
      course: this.fb.group({
        id: []
      }),
      totalCourseFee: [],
      courseSchedule: this.fb.group({
        id: []
      }),
      trainer: this.fb.group({
        id: []
      }),
      trainingLocation: this.fb.group({
        id: []
      })
    });

  }

  onUpdate(f: any) {
    if (f.valid) {
      this.validMessage = 'Your Information Has Been Updated!';
      this.salesService
      .updateLeadByEmail(this.route.snapshot.params.email, f.value)
      .subscribe(
        data => {
          this.message = 'The Lead has been updated!';
          return true;
        },
        error => {
          alert('Cannot Update lead!');
        });
    } else {
      this.validMessage = 'Please make sure the inputs are valid!';
    }
  }



  onSendPortalLink() {
    if (confirm('Are you sure you want to send portal link to this lead?')) {
      this.salesService.sendEmailWithAttachment(this.route.snapshot.params.email)
      .subscribe(
        () => this.confirmationMessage = 'The portal link has been sent.',
        (error: any) => console.error(error)
      );
    }
  }


  onSendTemplate() {
    console.log(this.leadExample);
    this.mail = new Mail(this.leadExample.email,
                        'BusyQA Welcome Package',
                        this.welcomeString
                        );
    if (confirm('Are you sure you want to send the welcome package?')) {
      this.salesService.sendTemplateEmail(this.mail)
      .subscribe(
        data => {
          this.confirmationMessage = 'Welcome Package Was Sent Successfully!';
          this.isWPSent = true;
          return true;
        },
        (error: any) => console.error(error)
      );
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


  // }

}

