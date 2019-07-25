import { ApiResponse } from '../model/util-apiresponse';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Subject, Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { JwtResponse } from '../model/auth-jwtresponse';
import { AuthLoginInfo } from '../model/auth-login';
import { SignUp } from '../model/auth-signup';
import { environment } from '../../../environments/environment';

import { TokenStorageService } from './token-storage.service';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl = environment.serverAddress;
  private loginUrl = this.apiUrl + '/api/auth/signin';
  private signUpUrl = this.apiUrl + '/api/auth/signup';
  private resetCredentialUrl = this.apiUrl + '/api/auth/resetpassword/';
  info: any;

  signUpResult$ = new BehaviorSubject <[SignUp]>(null);

  constructor(private http: HttpClient,
              private token: TokenStorageService,
              public jwtHelper: JwtHelperService) {
  }


  public isAuthenticated(): boolean {
    // const token = localStorage.getItem('token');
    const token = this.token.getToken();
    // Check whether the token is expired and return
    // true or false
    return !this.jwtHelper.isTokenExpired(token);
  }

  attemptAuth(credentials: AuthLoginInfo): Observable<JwtResponse> {
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  signUp(info: SignUp): Observable<string> {
    return this.http.post<string>(this.signUpUrl, info, httpOptions);
  }

  resetUserPassword(credentials: AuthLoginInfo): Observable<ApiResponse> {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()};

    return this.http.put<ApiResponse>(this.resetCredentialUrl + this.info.username, credentials, httpOptions);
  }

  // signUp(signup: SignUp) {
  //   this.http
  //   .post<any>(this.signUpUrl, signup)
  //   .subscribe(data => {
  //     console.log(data);
  //     this.signUpResult$.next(data);
  //   }, err => {
  //     console.log('Something Wrong with Sign Up' + err);
  //   });
  // }

}

