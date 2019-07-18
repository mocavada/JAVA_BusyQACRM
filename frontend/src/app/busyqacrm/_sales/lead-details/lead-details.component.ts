import { CourseSchedule } from './../../model/academics-courseschedule';
import { findIndex } from 'lodash';
import { AuditApiService } from './../../services/_audit-api.service';
import { Traininglocation } from './../../model/academics-traininglocation';
import { Mail } from '../../model/util-mail';
import { SalesApiService } from './../../services/_sales-api.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';

import { FileUploader } from 'ng2-file-upload';

import 'rxjs/add/operator/map';
import { Paymentplan } from '../../model/finance-paymentplan';
import { Course } from './../../model/academics-course';
import { Trainer } from './../../model/academics-trainer';
import { Lead } from '../../model/client-lead';
import { RegistrationFee } from '../../model/finance-registrationfee';
import { Discount } from '../../model/finance-discount';
import { Tax } from '../../model/finance-tax';


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
  portalLinkString: any;

  showAddress: boolean;
  showCourse: boolean;
  showCourseSchedule: boolean;
  showTrainer: boolean;
  showTrainingLocation: boolean;
  showRegistrationFee: boolean;
  showDiscount: boolean;
  showPaymentPlan: boolean;
  showLateFee: boolean;
  showTax: boolean;
  showEditProperties: boolean;
  resetProperties: boolean;

  isWPSent: boolean;
  isTISent: boolean;
  isPLSent: boolean;
  isWPSent1: boolean;

  leadExample: Lead;
  registrationFeeList: RegistrationFee[];
  discountList: Discount[];
  taxList: Tax[];
  paymentPlanList: Paymentplan[];
  courseList: Course[];
  courseScheduleList: CourseSchedule[];
  trainerList: Trainer[];
  trainingLocationList: Traininglocation[];


  clientStatusList = ['Course_Interested', 'Send_Details', 'For_Payment', 'To_Student'];


  constructor(private salesService: SalesApiService,
              private auditService: AuditApiService,
              private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder) {
      this.showAddress = true;
      this.showCourse = true;
      this.showCourseSchedule = true;
      this.showTrainer = true;
      this.showTrainingLocation = true;
      this.showRegistrationFee = true;
      this.showDiscount = true;
      this.showTax = true;
      this.showPaymentPlan = true;
      this.showLateFee = true;





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

    this.auditService.getAllRegistrationFee();

    this.auditService.discountResult$.subscribe(data => {
      if (data != null) {
        this.discountList = data;
        console.log('Successful Loading discountList!');
        console.log(this.discountList);
      }
    });

    this.auditService.getAllDiscount();

    this.auditService.paymentPlanResult$.subscribe(data => {
      if (data != null) {
        this.paymentPlanList = data;
        console.log('Successful Loading paymentPlanList!');
        console.log(this.paymentPlanList);
      }
    });

    this.auditService.getAllPaymentPlan();

    this.auditService.taxResult$.subscribe(data => {
      if (data != null) {
        this.taxList = data;
        console.log('Successful Loading taxList!');
        console.log(this.taxList);
      }
    });

    this.auditService.getAllTax();

    this.salesService.courseResult$.subscribe(data => {
      if (data != null) {
        this.courseList = data;
        console.log('Successful Loading courseList!');
        console.log(this.courseList);
      }
    });

    this.salesService.getAllCourse();

    this.salesService.courseScheduleResult$.subscribe(data => {
      if (data != null) {
        this.courseScheduleList = data;
        console.log('Successful Loading courseScheduleList!');
        console.log(this.courseScheduleList);
      }
    });

    this.salesService.getAllCourseSchedules();

    this.salesService.trainerResult$.subscribe(data => {
      if (data != null) {
        this.trainerList = data;
        console.log('Successful Loading trainerList!');
        console.log(this.trainerList);
      }
    });

    this.salesService.getAllTrainer();

    this.salesService.trainingLocationResult$.subscribe(data => {
      if (data != null) {
        this.trainingLocationList = data;
        console.log('Successful Loading trainingLocationList!');
        console.log(this.trainingLocationList);
      }
    });

    this.salesService.getAllTrainingLocation();

    // ** Get Email from Url and Use it as Parameter to getLead Api Request
    this.sub = this.route.paramMap.subscribe(
      params => {
        const email = params.get('email');
        this.getLead(email);
      }
    );

    // console.log('welcome -' + this.welcomeString);

  }

  toggleAddressDisplay() {
    console.log(this.showAddress);
    this.showAddress = !this.showAddress;
  }

  toggleCourseDisplay() {
    console.log(this.showCourse);
    this.showCourse = !this.showCourse;
  }

  toggleCourseScheduleDisplay() {
    console.log(this.showCourseSchedule);
    this.showCourseSchedule = !this.showCourseSchedule;
  }

  toggleTrainerDisplay() {
    console.log(this.showTrainer);
    this.showTrainer = !this.showTrainer;
  }

  toggleTrainingLocationDisplay() {
    console.log(this.showTrainingLocation);
    this.showTrainingLocation = !this.showTrainingLocation;
  }

  toggleRegistrationFeeDisplay() {
    console.log(this.showRegistrationFee);
    this.showRegistrationFee = !this.showRegistrationFee;
  }

  toggleDiscountDisplay() {
    console.log(this.showDiscount);
    this.showDiscount = !this.showDiscount;
  }

   toggleTaxDisplay() {
    console.log(this.showTax);
    this.showTax = !this.showTax;
  }

  togglePaymentPlanDisplay() {
    console.log(this.showPaymentPlan);
    this.showPaymentPlan = !this.showPaymentPlan;
  }

  onClickEditProperties() {
    console.log('CLICK');
    this.showEditProperties = !this.showEditProperties;

    console.log('RP ' + this.showEditProperties);
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
      id: this.leadExample.id,
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
      isCurrentlyEmployed: this.leadExample.isCurrentlyEmployed,
      isCurrentlyITEmployed: this.leadExample.isCurrentlyITEmployed,
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
      tax: this.leadExample.tax,
      paymentPlan: this.leadExample.paymentPlan,
         // ACADEMICS PROPERTIES
      course: this.leadExample.course,
      totalCourseFee: this.leadExample.totalCourseFee,
      courseSchedule: this.leadExample.courseSchedule,

      trainer: this.leadExample.trainer,
      trainingLocation: this.leadExample.trainingLocation,
    });

    this.welcomeString = this.leadExample.firstName + '#' +
                         this.leadExample.course.name + '#' +
                         this.leadExample.course.description + '#' +
                         this.leadExample.trainingLocation.name + '#' +
                         this.leadExample.courseSchedule.timeStart + ' to ' +
                         this.leadExample.courseSchedule.timeEnd  + '#' +
                         this.leadExample.trainer.trainerName + '#' +
                         this.leadExample.courseSchedule.dateStart + '#' +
                         this.leadExample.courseSchedule.dateEnd;


    this.portalLinkString = this.leadExample.firstName + '#' +
    'http://localhost:4200' + this.router.url;

    console.log('Message Strings - ' + this.welcomeString);
    console.log('This URL - ' + this.router.url);
  }

  updateForm() {
    this.editCLientForm = this.fb.group({
      // USER
      id: [],
      email: [],
      firstName: [],
      lastName: [],
      phoneNumber: [],
      emergencyPhone: [],

      // LEAD
      clientStatus: [],
      leadSource: [],
      comments: [],
      isCurrentlyEmployed: '',
      isCurrentlyITEmployed: '',
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

      registrationFee: [],
      discount: [],
      tax: [],
      paymentPlan: [],

      course: [],
      totalCourseFee: [],
      courseSchedule: [],
      trainer: [],
      trainingLocation: []

    });

  }

  onUpdate(f: any) {
    if (f.valid) {

      if (f.value.clientStatus === 'Send_Details' && !this.showEditProperties) {
        console.log('Send Details Indeed');
        f.value.course = this.leadExample.course.courseId;
        f.value.courseSchedule = this.leadExample.courseSchedule.courseScheduleId;
        f.value.trainer = this.leadExample.trainer.trainerId;
        f.value.trainingLocation = this.leadExample.trainingLocation.trainingLocationId;

        f.value.registrationFee = this.leadExample.registrationFee.registrationFeeId;
        f.value.discount = this.leadExample.discount.discountId;
        f.value.tax = this.leadExample.tax.taxId;
        f.value.paymentPlan = this.leadExample.paymentPlan.paymentPlanId;
      }

      if (!f.value.course &&
          !f.value.courseSchedule &&
          !f.value.trainer &&
          !f.value.trainingLocation &&
          !f.value.registrationFee &&
          !f.value.discount &&
          !f.value.tax &&
          !f.value.paymentPlan) {

          console.log('All Null');

      } else {
        f.value.clientStatus = 'Send_Details';
        console.log('Success Input');
      }

      this.validMessage = 'Your Information Has Been Updated!';

      console.log(f.value.course);


      this.salesService
      .updateLeadByEmail(this.route.snapshot.params.email, f.value)
      .subscribe(
        data => {
          this.message = 'The Lead has been updated!';
          // this.router.navigate(['/dashboard/sales/lead']);
          window.location.reload();
          return true;

        },
        error => {
          alert('Cannot Update Lead! Complete Lead Properties');
        });
    } else {
      this.validMessage = 'Please make sure the inputs are valid!';
    }
  }



  // onSendPortalLink() {
  //   if (confirm('Are you sure you want to send portal link to this lead?')) {
  //     this.salesService.sendEmailWithAttachment(this.route.snapshot.params.email)
  //     .subscribe(
  //       () => this.confirmationMessage = 'The portal link has been sent.',
  //       (error: any) => console.error(error)
  //     );
  //   }
  // }


  onSendPortalLink() {
    console.log(this.leadExample);
    this.mail = new Mail(this.leadExample.email,
                        'BusyQA Portal Link',
                        this.portalLinkString
                        );
    if (confirm('Are you sure you want to send Portal Link?')) {
      this.salesService.sendPortalLinkMail(this.mail)
      .subscribe(
        data => {
          this.confirmationMessage = 'Portal Link Was Sent Successfully!';
          this.isWPSent = true;
          return true;
        },
        (error: any) => console.error(error)
      );
    }
  }


  onSendWelcomePackage() {
    console.log(this.leadExample);
    this.mail = new Mail(this.leadExample.email,
                        'BusyQA Welcome Package',
                        this.welcomeString
                        );
    if (confirm('Are you sure you want to send the welcome package?')) {
      this.salesService.sendWelcomePackageMail(this.mail)
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
