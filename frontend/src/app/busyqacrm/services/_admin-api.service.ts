import { UserRequest } from '../model/user-request';
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
export class AdminApiService {

  apiUrl = environment.serverAddress;
  private userUrl = this.apiUrl + '/user';
  private pmUrl = this.apiUrl + '/pm';
  private adminUrl = this.apiUrl + '/admin';
  info: any;

  constructor(private http: HttpClient, private token: TokenStorageService) { }

  getUserBoard(): Observable<string> {
    return this.http.get(this.userUrl, { responseType: 'text' });
  }

  getPMBoard(): Observable<string> {
    return this.http.get(this.pmUrl, { responseType: 'text' });
  }

  getAdminBoard(): Observable<string> {
    return this.http.get(this.adminUrl, { responseType: 'text' });
  }

  getUsersByTeam(): Observable<ApiResponse> {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
    // this is to get information to test in postman
    console.log(this.info.token);
    return this.http.get<ApiResponse>(this.adminUrl + '/auth/' + this.info.username);
  }

  getUserByUsername(username: string): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.adminUrl + '/user/' + username);
  }

  updateUser(username: string, user: UserRequest): Observable<ApiResponse> {
    return this.http.put<ApiResponse>(this.adminUrl + '/user/' + username, user);
  }

  deleteUser(username: string): Observable<ApiResponse> {
    return this.http.delete<ApiResponse>(this.adminUrl + '/user/' + username);
  }

  getUserInfo(username: string): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.userUrl + '/' + username);
  }

}
