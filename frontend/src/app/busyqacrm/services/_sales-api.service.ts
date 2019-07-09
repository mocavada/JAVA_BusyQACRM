import { Traininglocation } from './../model/academics-traininglocation';
import { Trainer } from './../model/academics-trainer';
import { CourseSchedule } from './../model/academics-courseschedule';
import { Course } from './../model/academics-course';
import { Lead } from './../model/client-lead';
import { Mail } from '../model/util-mail';

import { TokenStorageService } from '../security/token-storage.service';
import { User } from '../model/auth-user';
import { ApiResponse } from '../model/util-apiresponse';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Subject, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SalesApiService {
  salesApiUrl = environment.serverAddress + '/sales';
  getAllLeadsUrl = this.salesApiUrl + '/usersList/Lead/CLIENT';
  getLeadByEmailUrl = this.salesApiUrl + '/lead/';
  updateLeadByEmailUrl = this.salesApiUrl + '/updateLead/';
  leadToStudentUrl = this.salesApiUrl + '/leadToStudent/';
  // COURSE
  addCourseUrl = this.salesApiUrl + '/addCourse';
  getAllCourseUrl = this.salesApiUrl + '/getAllCourse';

  // COURSE SCHEDULE
  addCourseScheduleUrl = this.salesApiUrl + '/addCourseSchedule';
  getAllCourseScheduleUrl = this.salesApiUrl + '/getAllCourseSchedule';

  // TRAINER
  addTrainerUrl = this.salesApiUrl + '/addTrainer';
  getAllTrainerUrl = this.salesApiUrl + '/getAllTrainer';

  // TRAINING LOCATION
  addTrainingLocationUrl = this.salesApiUrl + '/addTrainingLocation';
  getAllTrainingLocationUrl = this.salesApiUrl + '/getAllTrainingLocation';

  leadResult$ = new BehaviorSubject <[Lead]>(null);
  courseResult$ = new BehaviorSubject <[Course]>(null);
  courseScheduleResult$ = new BehaviorSubject <[CourseSchedule]>(null);
  trainerResult$ = new BehaviorSubject <[Trainer]>(null);
  trainingLocationResult$ = new BehaviorSubject <[Traininglocation]>(null);

  info: any;

  constructor(private http: HttpClient,
              private token: TokenStorageService) { }

  // LEAD
  getAllLeads() {
    this.http.get<[Lead]>(this.getAllLeadsUrl)
    .subscribe(data => {
      this.leadResult$.next(data);
    }, err => {
      console.log('Something Wrong Getting Leads List! ' + err);
    });
  }

  getLeadByEmail(email: string) {
    return this.http.get(this.getLeadByEmailUrl + email);
  }

  updateLeadByEmail(email: string, client: Lead) {
    const body = JSON.stringify(client);
    return this.http.put(this.updateLeadByEmailUrl + email, client);
  }

  changeLeadToStudent(email: string) {
    return this.http.delete(this.leadToStudentUrl + email);
  }

  // COURSES
  addCourse(course: Course) {
    this.http
    .post<any>(this.addCourseUrl, course)
    .subscribe(data => {
      console.log(data);
      this.courseResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding Course' + err);
    });
  }

  getAllCourse() {
    this.http.get<[Course]>(this.getAllCourseUrl)
    .subscribe(data => {
      this.courseResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting CourseList');
    });
  }

  // COURSES SCHEDULE
  addCourseSchedule(courseSchedule: CourseSchedule) {
    this.http
    .post<any>(this.addCourseScheduleUrl, courseSchedule)
    .subscribe(data => {
      console.log(data);
      this.courseScheduleResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding Course' + err);
    });
  }

  getAllCourseSchedules() {
    this.http.get<[CourseSchedule]>(this.getAllCourseScheduleUrl)
    .subscribe(data => {
      this.courseScheduleResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting CourseList');
    });
  }

  // TRAINER SCHEDULE
  addTrainer(trainer: Trainer) {
    this.http
    .post<any>(this.addTrainerUrl, trainer)
    .subscribe(data => {
      console.log(data);
      this.trainerResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding Trainer' + err);
    });
  }

  getAllTrainer() {
    this.http.get<[Trainer]>(this.getAllTrainerUrl)
    .subscribe(data => {
      this.trainerResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting Trainer');
    });
  }

  // TRAINING LOCATION
  addTrainingLocation(traininglocation: Traininglocation) {
    this.http
    .post<any>(this.addTrainingLocationUrl, traininglocation)
    .subscribe(data => {
      console.log(data);
      this.trainingLocationResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding Training Location' + err);
    });
  }

  getAllTrainingLocation() {
    this.http.get<[Traininglocation]>(this.getAllTrainingLocationUrl)
    .subscribe(data => {
      this.trainingLocationResult$.next(data);
    }, err => {
      console.log('Something Wrong With Getting Training Location');
    });
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



  // postClient(client: Lead) {
  //   this.http
  //   .post<any>(this.salesApiUrl + '/addlead', client)
  //   .subscribe(data => {
  //     console.log(data);
  //     this.clientResult$.next(data);
  //   }, err => {
  //     console.log('Something Wrong with Post Client' + err);
  //   });
  // }

   // updateLeadByEmail(client: Lead) {
  //   return this.http
  //   .patch<any>(this.salesApiUrl + '/updatelead', client)
  //   .subscribe(data => {
  //     console.log(data);
  //     this.clientResult$.next(data);
  //   }, err => {
  //     console.log('Something Wrong with Lead Update' + err);
  //   });
  // }




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
