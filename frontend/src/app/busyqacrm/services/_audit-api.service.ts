import { Tax } from './../model/finance-tax';
import { RegistrationFee } from '../model/finance-registrationfee';
import { Paymentplan } from './../model/finance-paymentplan';
import { LateFee } from './../model/finance-latefee';
import { Discount } from './../model/finance-discount';
import { Student } from './../model/client-student';

import { TokenStorageService } from '../security/token-storage.service';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Subject, Observable } from 'rxjs';
import { Payment } from '../model/finance-payment';

@Injectable({
  providedIn: 'root'
})
export class AuditApiService {
  auditApiUrl = environment.serverAddress + '/audit';
  getAllStudentUrl = this.auditApiUrl + '/usersList/Student';
  getStudentByEmailUrl = this.auditApiUrl + '/student/';
  updateLeadByEmailUrl = this.auditApiUrl + '/updateStudent/';
  // PAYMENT
  getPaymentsByStudentURL = this.auditApiUrl + '/studentPayments/';
  // DISCOUNT
  addDiscountUrl = this.auditApiUrl + '/addDiscount';
  getAllDiscountUrl = this.auditApiUrl + '/discountList';
   // LATE FEE
  addLateFeeUrl = this.auditApiUrl + '/addLateFee';
  getAllLateFeeUrl = this.auditApiUrl + '/lateFeeList';
   // PAYMENT PLAN
  addPaymentPlanUrl = this.auditApiUrl + '/addPaymentPlan';
  getAllPaymentPlanUrl = this.auditApiUrl + '/paymentPlanList';
   // REGISTRATION FEE
   addRegistrationFeeUrl = this.auditApiUrl + '/addRegistrationFee';
   getAllRegistrationFeeUrl = this.auditApiUrl + '/registrationFeeList';
  // TAX
   addTaxUrl = this.auditApiUrl + '/addTax';
   getAllTaxUrl = this.auditApiUrl + '/taxList';

  studentResult$ = new BehaviorSubject <[Student]>(null);
  paymentResult$ = new BehaviorSubject <[Payment]>(null);
  discountResult$ = new BehaviorSubject <[Discount]>(null);
  lateFeeResult$ = new BehaviorSubject <[LateFee]>(null);
  paymentPlanResult$ = new BehaviorSubject <[Paymentplan]>(null);
  registrationFeeResult$ = new BehaviorSubject <[RegistrationFee]>(null);
  taxResult$ = new BehaviorSubject <[Tax]>(null);

  info: any;

  constructor(private http: HttpClient) { }
  // STUDENT SERVICE
  getAllStudent() {
    this.http.get<[Student]>(this.getAllStudentUrl).subscribe(data => {
      this.studentResult$.next(data);
    }, err => {
      console.log('Something Wrong Getting Students List! ' + err);
    });
  }

  getStudentByEmail(email: string) {
    return this.http.get(this.getStudentByEmailUrl + email);
  }

  updateStudentByEmail(email: string, client: Student) {
    const body = JSON.stringify(client);
    return this.http.put(this.updateLeadByEmailUrl + email, client);
  }

  // PAYMENT
  getPaymentsByStudent(id: number) {
    this.http.get<[Payment]>(this.getPaymentsByStudentURL + id).subscribe(data => {
      this.paymentResult$.next(data);
    }, err => {
      console.log('Something Wrong Getting Student Payments List! ' + err);
    });
  }

  // DISCOUNT SCHEDULE
  addDiscount(discount: Discount) {
    this.http
    .post<any>(this.addDiscountUrl, discount)
    .subscribe(data => {
      console.log(data);
      this.discountResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding Discount' + err);
    });
  }

  getAllDiscount() {
    this.http.get<[Discount]>(this.getAllDiscountUrl)
    .subscribe(data => {
      this.discountResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting Discount');
    });
  }

   // LATE FEE
   addLateFee(latefee: LateFee) {
    this.http
    .post<any>(this.addLateFeeUrl, latefee)
    .subscribe(data => {
      console.log(data);
      this.lateFeeResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding Late Fee' + err);
    });
  }

  getAllLateFee() {
    this.http.get<[LateFee]>(this.getAllLateFeeUrl)
    .subscribe(data => {
      this.lateFeeResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting Late Fee');
    });
  }

  // PAYMENT PLAN FEE
  addPaymentPlan(paymentplan: Paymentplan) {
    this.http
    .post<any>(this.addPaymentPlanUrl, paymentplan)
    .subscribe(data => {
      console.log(data);
      this.paymentPlanResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding PAYMENT PLAN' + err);
    });
  }

  getAllPaymentPlan() {
    this.http.get<[Paymentplan]>(this.getAllPaymentPlanUrl)
    .subscribe(data => {
      this.paymentPlanResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting PAYMENT PLAN');
    });
  }


  // REGISTRATION FEE
  addRegistrationFee(registrationfee: RegistrationFee) {
    this.http
    .post<any>(this.addRegistrationFeeUrl, registrationfee)
    .subscribe(data => {
      console.log(data);
      this.registrationFeeResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding Registration Fee' + err);
    });
  }

  getAllRegistrationFee() {
    this.http.get<[RegistrationFee]>(this.getAllRegistrationFeeUrl)
    .subscribe(data => {
      this.registrationFeeResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting Registration Fee');
    });
  }

  // TAX
  addTax(tax: Tax) {
    this.http
    .post<any>(this.addTaxUrl, tax)
    .subscribe(data => {
      console.log(data);
      this.taxResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding Tax' + err);
    });
  }

  getAllTax() {
    this.http.get<[Tax]>(this.getAllTaxUrl)
    .subscribe(data => {
      this.taxResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting Tax');
    });
  }


}
