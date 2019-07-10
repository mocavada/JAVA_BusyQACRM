import { Course } from './../../model/academics-course';
import { Mail } from '../../model/util-mail';
import { SalesApiService } from './../../services/_sales-api.service';
import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';



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
        const username = params.get('username');
        this.getLead(username);
      }
    );

  }

  getLead(username: string): void {
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


}
