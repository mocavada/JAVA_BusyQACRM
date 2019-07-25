import { LateFee } from './../../model/finance-latefee';
import { AuditApiService } from './../../services/_audit-api.service';
import { Payment } from './../../model/finance-payment';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Tax } from '../../model/finance-tax';
import { Student } from '../../model/client-student';
import { Location } from '@angular/common';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class StudentDetailsComponent implements OnInit {

  private sub: Subscription;
  updateStudentForm: FormGroup;
  addPaymentForm: FormGroup;

  validMessage = '';
  confirmationMessage = '';
  message: string;

  showLateFee: boolean;
  showEditProperties: boolean;

  studentExample: any;
  paymentExample: any;
  lateFeeList: LateFee[];
  paymentList: Payment[];


  constructor(private auditService: AuditApiService,
              private route: ActivatedRoute,
              private router: Router,
              private fb: FormBuilder,
              private location: Location) {

              this.showLateFee = true;
  }

  ngOnInit() {
    this.studentForm();
    this.paymentForm();

    this.auditService.lateFeeResult$.subscribe(data => {
      if (data != null) {
        this.lateFeeList = data;
        console.log('Successful Loading LateFee List!');
        console.log(this.lateFeeList);
      }
    });

    this.auditService.getAllLateFee();
    console.log(this.lateFeeList);


    this.auditService.paymentResult$.subscribe(data => {
      if (data != null) {
        this.paymentList = data;
        console.log('Success Payment List!');
        console.log(this.paymentList);
      }
    });

    this.sub = this.route.paramMap.subscribe(
      params => {
        const email = params.get('email');
        this.getStudent(email);
        this.auditService.getPaymentsByStudentEmail(email);
      }
    );


    console.log(this.paymentList);



    // console.log('welcome -' + this.welcomeString);
  }

  toggleLateFeeeeDisplay() {
    console.log(this.showLateFee);
    this.showLateFee = !this.showLateFee;
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
    if (this.updateStudentForm) {
      this.updateStudentForm.reset();
    }
    this.studentExample = data;

    this.updateStudentForm.patchValue({
      // USER
      id: this.studentExample.id,
      firstName: this.studentExample.firstName,
      lastName: this.studentExample.lastName,
      phone: this.studentExample.phoneNumber,
      email: this.studentExample.email,
      emergencyPhone: this.studentExample.emergencyPhone,
      dtype: this.studentExample.dtype,
      userState: this.studentExample.userState,

      // LEAD
      clientStatus: this.studentExample.clientStatus,
      leadSource: this.studentExample.leadSource,
      comments: this.studentExample.comments,
      isCurrentlyEmployed: this.studentExample.isCurrentlyEmployed,
      currentlyITEmployed: this.studentExample.isCurrentlyITEmployed,
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
        // FINANCE PROPERTIES
      registrationFee: this.studentExample.registrationFee,
      discount: this.studentExample.discount,
      tax: this.studentExample.tax,
      paymentPlan: this.studentExample.paymentPlan,
      // ACADEMICS PROPERTIES
      course: this.studentExample.course,
      totalCourseFee: this.studentExample.totalCourseFee,
      courseSchedule: this.studentExample.courseSchedule,

      trainer: this.studentExample.trainer,
      trainingLocation: this.studentExample.trainingLocation,

      // STUDENT HERE
      amountPaid: this.studentExample.amountPaid,
      balance: this.studentExample.balance,
      weeklyPayment: this.studentExample.weeklyPayment,
      isPaymentLate: this.studentExample.isPaymentLate,
      payments: this.studentExample.payments,
      lateFee: this.studentExample.lateFee,
    });

  }

  paymentForm() {
    this.addPaymentForm = this.fb.group({
      amount: [],
      remarks: [],
      paymentDate: []
    });
  }

  studentForm() {
    this.updateStudentForm = this.fb.group({
      // USER
      isPaymentLate: [],
      lateFee: [],
    });
  }

  onAddPayment(f: any) {
    if (f.valid) {
      this.validMessage = 'Your information has been updated!';

      this.auditService
      .addPaymentByEmail(this.route.snapshot.params.email, f.value)
      .subscribe(
        data => {
          this.message = 'This Student Payment is Postedd!';
          this.paymentExample = data;
          this.addPaymentForm.reset();
          window.location.reload();
          return true;
        },
        error => {
          alert('Couldnt Post Student Payment!'); });
    } else {
      this.validMessage = 'Please make sure the inputs are valid!';
    }
  }


  onUpdateStudent(f: any) {
    if (f.valid) {
      this.validMessage = 'Your information has been updated!';

      if (!f.value.lateFee) {
        f.value.lateFee = this.studentExample.LateFee.lateFeeId;
      }

      // f.value.payments.studentId = this.studentExample.id;
      this.auditService
      .updateStudentByEmail(this.route.snapshot.params.email, f.value)
      .subscribe(
        data => {
          this.message = 'This Student Info has been Updated!';
          this.addPaymentForm.reset();
          window.location.reload();
          return true;
        },
        error => {
          alert('Couldnt Update this Student Info! Please Select Late Fee'); });
    } else {
      this.validMessage = 'Please make sure the inputs are valid!';
    }
  }


  cancel() {
    this.location.back(); // <-- go back to previous location on cancel
  }


}
