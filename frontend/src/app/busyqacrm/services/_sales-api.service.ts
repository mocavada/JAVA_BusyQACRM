import { Mail } from './../model/mail';
import { Course } from './../model/course';
import { Client } from '../model/client';
import { Lead } from '../model/lead';
import { LeadRequest } from '../model/lead-request';
import { TokenStorageService } from '../auth/token-storage.service';
import { User } from '../model/user';
import { ApiResponse } from '../model/api-response';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Subject, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SalesApiService {
  salesApiUrl = environment.serverAddress + '/sales';
  clientResult$ = new BehaviorSubject <[Client]>(null);
  courseResult$ = new BehaviorSubject <[Course]>(null);
  info: any;

  constructor(private http: HttpClient,
              private token: TokenStorageService) { }

  getLeadsList() {
    this.http.get<[Client]>(this.salesApiUrl + '/leadslist').subscribe(data => {
      this.clientResult$.next(data);
    }, err => {
      console.log('Something Wrong Getting Leads List! ' + err);
    });
  }

  getLeadByEmail(email: string) {
    return this.http.get(this.salesApiUrl + '/lead/' + email);
  }

  pullCourseList(courseList: [Course]) {
    this.courseResult$.next(courseList);
  }

  getCourseList() {
    this.http.get<[Course]>(this.salesApiUrl + '/courselist')
    .subscribe(data => {
      this.pullCourseList(data);
    }, err => {
      console.log('Something Wrong With Getting CourseList');
    });
  }

  postClient(client: Client) {
    this.http
    .post<any>(this.salesApiUrl + '/addlead', client)
    .subscribe(data => {
      console.log(data);
      this.clientResult$.next(data);
    }, err => {
      console.log('Something Wrong with Post Client' + err);
    });
  }

  postCourse(course: Course) {
    this.http
    .post<any>(this.salesApiUrl + '/addcourse', course)
    .subscribe(data => {
      console.log(data);
      this.courseResult$.next(data);
    }, err => {
      console.log('Something Wrong with Post Course' + err);
    });
  }

  updateLead(client: Client) {
    return this.http
    .patch<any>(this.salesApiUrl + '/updatelead', client)
    .subscribe(data => {
      console.log(data);
      this.clientResult$.next(data);
    }, err => {
      console.log('Something Wrong with Post Client' + err);
    });
  }

  updateLeadLead(email: string, client: Client) {
    const body = JSON.stringify(client);
    return this.http.put(this.salesApiUrl + '/updateleadlead/' + email, client);
  }

  // SEND WELCOME PACKAGE, INSTRUCTORS INFO and COURSE INFO
  sendTemplateEmail(mail: Mail) {
    return this.http
    .post(this.salesApiUrl + '/sendEmailWithTemplate/', mail);
  }

  // SEND EMAIL WITH ATTACHMENT
  sendEmailWithAttachment(email: string) {
    return this.http
    .get(this.salesApiUrl + '/sendEmailWithAttachment/' + email);
  }







  // addLead(entry: Client) {

  //   this.http
  //     .post<[Client]>(this.salesApiUrl + '/updatelead/', entry)
  //     .subscribe(data => {
  //       this.clientResult$.next(data);
  //       console.log(data);
  //     }, err => {
  //       console.log('Something wrong in Posting Data');
  //   });
  // }

  // updateLead(entry: Client) {
  //     const body = JSON.stringify(entry);
  //     return this.http.put(this.salesApiUrl + '/updatelead/', entry);
  // }

  // deleteClient(id: number) {
  //   return this.http.delete(this.salesApiUrl + '/deleteclient/' + id);
  // }






  // listLeads() {
  //   // this.info = {
  //   //   token: this.token.getToken(),
  //   //   username: this.token.getUsername(),
  //   //   authorities: this.token.getAuthorities()
  //   // };
  //   return this.http.get(this.pmUrl + '/leads');
  // }

  // listLeadById(id: number) {
  //   return this.http.get(this.pmUrl + '/leads/' + id);
  // }

  // updateLead(id: number, lead: Lead) {
  //   const body = JSON.stringify(lead);
  //   return this.http.put(this.pmUrl + '/leads/' + id, lead);
  // }

  // deleteLead(id: number) {
  //   return this.http.delete(this.pmUrl + '/leads/' + id);
  // }

  // changeLeadToStudent(id: number) {
  //   return this.http.delete(this.pmUrl + '/changeLeadToStudent/' + id);
  // }

  // signUpLead(leadRequest: LeadRequest): Observable<ApiResponse> {
  //   return this.http.post<ApiResponse>(this.leadSignUpUrl, leadRequest);
  // }



}
