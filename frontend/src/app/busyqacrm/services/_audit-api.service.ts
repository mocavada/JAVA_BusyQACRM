import { Student } from './../model/client-student';

import { TokenStorageService } from '../security/token-storage.service';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Subject, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuditApiService {
  auditApiUrl = environment.serverAddress + '/audit';
  getStudentsListUrl = this.auditApiUrl + '/usersList/Student';
  studentResult$ = new BehaviorSubject <[Student]>(null);

  info: any;

  constructor(private http: HttpClient) { }

  getStudentsList() {
    this.http.get<[Student]>(this.getStudentsListUrl).subscribe(data => {
      this.studentResult$.next(data);
    }, err => {
      console.log('Something Wrong Getting Students List! ' + err);
    });
  }

}
