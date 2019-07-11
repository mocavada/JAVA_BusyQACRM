import { LateFee } from './../../model/finance-latefee';
import { AuditApiService } from './../../services/_audit-api.service';
import { Payment } from './../../model/finance-payment';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Tax } from '../../model/finance-tax';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class StudentDetailsComponent implements OnInit {

  private sub: Subscription;
  editCLientForm: FormGroup;
  validMessage = '';
  confirmationMessage = '';
  message: string;
  studentExample: any;

  messageObject: any;
  welcomeString: any;

  showCourse: boolean;
  showAddress: boolean;
  isWPSent: boolean;
  isTISent: boolean;
  isPLSent: boolean;
  isWPSent1: boolean;

  paymentList: Payment[];
  taxList: Tax[];
  lateFeeList: LateFee[];

  constructor(private auditService: AuditApiService,
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

    this.auditService.lateFeeResult$.subscribe(data => {
      if (data != null) {
        this.lateFeeList = data;
        console.log('Successful Loading Late Fee List!');
        console.log(this.lateFeeList);
      }
    });

    this.auditService.taxResult$.subscribe(data => {
      if (data != null) {
        this.taxList = data;
        console.log('Successful Loading Tax List!');
        console.log(this.taxList);
      }
    });

    this.auditService.getAllLateFee();
    console.log(this.lateFeeList);

    this.auditService.getAllTax();
    console.log(this.taxList);


    this.sub = this.route.paramMap.subscribe(
      params => {
        const email = params.get('email');
        this.getStudent(email);
      }
    );



    // console.log('welcome -' + this.welcomeString);
  }


  getStudent(email: string): void {
    this.auditService.getStudentByEmail(email)
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
    this.studentExample = data;

    this.editCLientForm.patchValue({
      // USER
      id: this.studentExample.id,
      firstName: this.studentExample.firstName,
      lastName: this.studentExample.lastName,
      phone: this.studentExample.phone,
      email: this.studentExample.email,
      emergencyPhone: this.studentExample.emergencyPhone,

      // LEAD
      clientStatus: this.studentExample.clientStatus,
      leadSource: this.studentExample.leadSource,
      comments: this.studentExample.comments,
      currentlyEmployed: this.studentExample.currentlyEmployed,
      currentlyITEmployed: this.studentExample.currentlyITEmployed,
      desiredJob: this.studentExample.desiredJob,

       // ADDRESS
       mailingStreet: this.studentExample.mailingStreet,
       mailingCity: this.studentExample.mailingCity,
       mailingState: this.studentExample.mailingState,
       mailingZip: this.studentExample.mailingZip,
       mailingCountry: this.studentExample.mailingCountry,

       // BOOLEANS STATUS
       isRegistrationFeePaid: this.studentExample.isRegistrationFeePaid,
       isPlanAgreementSigned: this.studentExample.isPlanAgreementSigned,
       isDiscountGiven: this.studentExample.isDiscountGiven,


      // ACADEMICS
      course: this.studentExample.course,
      courseid: this.studentExample.course.id,
      coursename: this.studentExample.course.name,

      // DATE
      createdTime: this.studentExample.createdTime,
      modifiedTime: this.studentExample.modifiedTime,

    });

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
      this.auditService
      .updateStudentByEmail(this.route.snapshot.params.email, this.editCLientForm.value)
      .subscribe(
        data => {
          this.message = 'The student has been updated!';
          return true;
        },
        error => {
          alert('Couldnt update this student!'); });
    } else {
      this.validMessage = 'Please make sure the inputs are valid!';
    }
  }

}
