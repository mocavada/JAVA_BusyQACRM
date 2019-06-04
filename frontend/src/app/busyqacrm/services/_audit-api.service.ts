import { Client } from './../model/client';
import { TokenStorageService } from '../auth/token-storage.service';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Subject, Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AuditApiService {
  auditApiUrl = environment.serverAddress + '/audit';
  clientResult$ = new BehaviorSubject <[Client]>(null);

  info: any;

  constructor(private http: HttpClient) { }

  getStudentsList() {
    this.http.get<[Client]>(this.auditApiUrl + '/studentslist').subscribe(data => {
      this.clientResult$.next(data);
    }, err => {
      console.log('Something Wrong Getting Students List! ' + err);
    });
  }

}
