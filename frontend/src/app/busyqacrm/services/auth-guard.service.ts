import { AuthService } from '../security/_auth-api.service';
import { TokenStorageService } from '../security/token-storage.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, CanActivate } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(public auth: AuthService,
              public router: Router,
              public token: TokenStorageService) {}

  canActivate(): boolean {
    if (!this.auth.isAuthenticated()) {
      this.router.navigate(['auth/login']);
      return false;
    }
    return true;
  }


}



