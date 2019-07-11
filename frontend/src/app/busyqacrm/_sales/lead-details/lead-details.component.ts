
import { Course } from './../../model/academics-course';
import { Mail } from '../../model/util-mail';
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
  confirmationMessage = '';
  message: string;
  mail: Mail;
  leadExample: any;

  messageObject: any;
  welcomeString: any;
  showCourse: boolean;
  showAddress: boolean;
  isWPSent: boolean;
  isTISent: boolean;
  isPLSent: boolean;
  isWPSent1: boolean;



  courseList: Course[];

  constructor(private salesService: SalesApiService,
              private route: ActivatedRoute,
              private fb: FormBuilder) {
      this.showCourse = true;
      this.showAddress = true;
      this.isWPSent = true;
      // this.isTISent = false;
      // this.isPLSent = false;

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

    this.salesService.courseResult$.subscribe(data => {
      if (data != null) {
        this.courseList = data;
        console.log('Successful Loading Lead List!');
        console.log(this.courseList);
      }
    });

    this.salesService.getAllCourse();
    console.log(this.courseList);


    this.sub = this.route.paramMap.subscribe(
      params => {
        const email = params.get('email');
        this.getLead(email);
      }
    );



    // console.log('welcome -' + this.welcomeString);
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
      // USER
      id: this.leadExample.id,
      firstName: this.leadExample.firstName,
      lastName: this.leadExample.lastName,
      phone: this.leadExample.phone,
      email: this.leadExample.email,
      emergencyPhone: this.leadExample.emergencyPhone,

      // LEAD
      clientStatus: this.leadExample.clientStatus,
      leadSource: this.leadExample.leadSource,
      comments: this.leadExample.comments,
      currentlyEmployed: this.leadExample.currentlyEmployed,
      currentlyITEmployed: this.leadExample.currentlyITEmployed,
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


      // ACADEMICS
      course: this.leadExample.course,
      courseid: this.leadExample.course.id,
      coursename: this.leadExample.course.name,

      // DATE
      createdTime: this.leadExample.createdTime,
      modifiedTime: this.leadExample.modifiedTime,

    });
    this.welcomeString = this.leadExample.firstName + '@' +
                         this.leadExample.course.name + '@' +
                         this.leadExample.course.description;

    console.log('Message Strings - ' + this.welcomeString);
  }


  updateForm() {
    this.editCLientForm = this.fb.group({
      // USER
      id: '',
      email: ['', Validators.required],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phone: ['', Validators.required],
      emergencyPhone: '',

      // LEAD
      clientStatus: '',
      leadSource: '',
      comments: '',
      currentlyEmployed: '',
      currentlyITEmployed: '',
      desiredJob: '',

       // ADDRESS
       mailingStreet: '',
       mailingCity: '',
       mailingState: '',
       mailingZip: '',
       mailingCountry: '',

      // BOOLEANS
      isRegistrationFeePaid: '',
      isPlanAgreementSigned: '',
      isDiscountGiven: '',

      // ACADEMICS
      course: this.fb.group({
        id: [0]
      })

    });

  }

  onUpdate() {
    if (this.editCLientForm.valid) {
      this.validMessage = 'Your information has been updated!';
      this.salesService
      .updateLeadByEmail(this.route.snapshot.params.email, this.editCLientForm.value)
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

