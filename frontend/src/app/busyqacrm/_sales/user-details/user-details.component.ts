import { Course } from './../../model/academics-course';
import { Mail } from '../../model/util-mail';
import { SalesApiService } from './../../services/_sales-api.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Lead } from '../../model/client-lead';
import { AuditApiService } from '../../services/_audit-api.service';
import { Paymentplan } from '../../model/finance-paymentplan';



@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class UserDetailsComponent implements OnInit {

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
  paymentPlanList: Paymentplan[];
  courseList: Course[];


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

    this.auditService.paymentPlanResult$.subscribe(data => {
      if (data != null) {
        this.paymentPlanList = data;
        console.log('Successful Loading paymentPlanList!');
        console.log(this.paymentPlanList);
      }
    });

    this.auditService.getAllPaymentPlan();

    this.salesService.courseResult$.subscribe(data => {
      if (data != null) {
        this.courseList = data;
        console.log('Successful Loading courseList!');
        console.log(this.courseList);
      }
    });

    this.salesService.getAllCourse();

    // ** Get Email from Url and Use it as Parameter to getLead Api Request
    this.sub = this.route.paramMap.subscribe(
      params => {
        const username = params.get('username');
        this.getLeadByUsername(username);
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

  togglePaymentPlanDisplay() {
    console.log(this.showPaymentPlan);
    this.showPaymentPlan = !this.showPaymentPlan;
  }

  onClickEditProperties() {
    console.log('CLICK');
    this.showEditProperties = !this.showEditProperties;

    console.log('RP ' + this.showEditProperties);
  }

  getLeadByUsername(username: string): void {
    this.salesService.getLeadByUsername(username)
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
      paymentPlan: [],
      course: [],

    });

  }

  onUpdate(f: any) {
    if (f.valid) {

      if (f.value.clientStatus === 'Send_Details' && !this.showEditProperties) {
        console.log('Send Details Indeed');
        f.value.course = this.leadExample.course.courseId;
        f.value.paymentPlan = this.leadExample.paymentPlan.paymentPlanId;
      }

      if (!f.value.course &&
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



}
