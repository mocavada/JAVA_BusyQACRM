import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { AuthService } from '../_auth-api.service';
import { SignUp } from '../../model/auth-signup';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {};
  signupInfo: SignUp;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() { }

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignUp(
      this.form.firstName,
      this.form.username,
      this.form.email,
      this.form.password);


    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        console.log(data);
        this.isSignedUp = true;
        this.isSignUpFailed = false;

      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
    // this.router.navigate(['home']);

  }
}

