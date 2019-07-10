import { Component, OnInit, Output, Input } from '@angular/core';
import { AuthService } from '../_auth-api.service';
import { TokenStorageService } from '../token-storage.service';
import { AuthLoginInfo } from '../../model/auth-login';
import { environment } from '../../../../environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class LoginComponent implements OnInit {
  // @Input() authority: any;
  // @Input() username: any;
  username: any;
  authority: any;
  isClient: boolean;

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  private loginInfo: AuthLoginInfo;

  constructor(private authService: AuthService,
              private tokenStorage: TokenStorageService,
              private router: Router) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
    }
    console.log(this.tokenStorage.getToken());
    this.roleAccess();

    this.tokenStorage.getUsername();
    console.log(this.isClient);
  }

  onSubmit() {
    console.log(this.form);

    this.loginInfo = new AuthLoginInfo(
      this.form.username,
      this.form.password);

    this.authService.attemptAuth(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.redirectToDashboard();
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      }
    );

    console.log('test' + this.username);

  }


  roleAccess() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();

    // Find the User ROLE
      this.roles.find(role => {
        if (this.roles.includes('ROLE_ADMIN')) {
          this.authority = 'admin';
          this.isClient = false;
          return false;

        } else if (this.roles.includes('ROLE_AUDIT')) {
          this.authority = 'audit';
          this.isClient = false;
          return false;

        } else if (this.roles.includes('ROLE_SALES')) {
          this.authority = 'sales';
          this.isClient = false;
          return false;

        } else {
          this.authority = 'users';
          this.isClient = true;
          return true;

        }
      });

  //     // Find the User USERNAME
      this.username = this.tokenStorage.getUsername();
    }
  }

  redirectToDashboard() {
    if (this.router.url === '/auth/login') {
      window.location.reload();
      // if (this.router.url === '/auth/login') {
      //   setTimeout(() => {
      //     this.router.navigate(['/dashboard/']);
      //   }, 1000 );
      // }
    } else {
 // Stay here or do something
 // for the case 'However if he is on a safe page I don't want to redirected him.'
    }

    // window.location.reload();

  }
}

