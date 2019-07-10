import { Usergroup } from './../model/auth-usergroup';
import { User } from './../model/auth-user';
import { TokenStorageService } from '../security/token-storage.service';
import { ApiResponse } from '../model/util-apiresponse';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Subject, Observable } from 'rxjs';
import { Lead } from '../model/client-lead';

@Injectable({
  providedIn: 'root'
})
export class AdminApiService {

  adminApiUrl = environment.serverAddress + '/admin';
  addUserGroupUrl = this.adminApiUrl + '/addUserGroup';
  getAllUserGroupsUrl = this.adminApiUrl + '/userGroupsList';

  getAllUserUrl = this.adminApiUrl + '/usersList/Lead/EMPLOYEE';

  leadResult$ = new BehaviorSubject <[Lead]>(null);
  userGroupResult$ = new BehaviorSubject<[Usergroup]>(null);

  constructor(private http: HttpClient,
              private token: TokenStorageService) { }


  // USER GROUP
  addUserGroup(usergroup: Usergroup) {
    this.http
    .post<any>(this.addUserGroupUrl, usergroup)
    .subscribe(data => {
      console.log(data);
      this.userGroupResult$.next(data);
    }, err => {
      console.log('Something Wrong with Adding User Group' + err);
    });
  }

  getAllUserGroups() {
    this.http.get<[Usergroup]>(this.getAllUserGroupsUrl)
    .subscribe(data => {
      this.userGroupResult$.next(data);
    }, err => {
      console.log('Something Wrong Getting User Groups List! ' + err);
    });
  }

   // EMPLOYEE
  getAllUsers() {
    this.http.get<[Lead]>(this.getAllUserUrl)
    .subscribe(data => {
      this.leadResult$.next(data);
    }, err => {
      console.log('Something Wrong Getting User List! ' + err);
    });
  }






  // getLeadByEmail(email: string) {
  //   return this.http.get(this.getLeadByEmailUrl + email);
  // }

  // updateLeadByEmail(email: string, client: Lead) {
  //   const body = JSON.stringify(client);
  //   return this.http.put(this.updateLeadByEmailUrl + email, client);
  // }

  // changeLeadToStudent(email: string) {
  //   return this.http.delete(this.leadToStudentUrl + email);
  // }
}
