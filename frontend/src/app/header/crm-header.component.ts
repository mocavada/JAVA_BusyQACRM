import { TokenStorageService } from '../busyqacrm/security/token-storage.service';
import { environment } from '../../environments/environment';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import 'rxjs/add/operator/finally';

@Component({
  selector: 'app-crm-header',
  templateUrl: './crm-header.component.html',
  styleUrls: ['./crm-header.component.css']
})
export class CrmHeaderComponent implements OnInit {
  // @Input() authority: any;
  // @Input() roles: any;
  // @Input() username: any;

  @Input() hideHeader: any;

  roles: string[];
  authority: string;
  username: string;
  isClient: boolean;
  private urlRoot = environment.serverAddress;
  path: any;

  title = 'BusyQA';
  showHideitem: boolean;
  constructor(private http: HttpClient,
              private router: Router,
              private tokenStorage: TokenStorageService,
    ) {}

  ngOnInit() {
    this.showHideitem = false;
    this.showNav();
    this.roleAccess();

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
          this.authority = 'user';
          this.isClient = true;
          return true;
        }
      });

      // Find the User USERNAME
      this.username = this.tokenStorage.getUsername();
    }
  }

  showNav() {
    if (this.tokenStorage.getToken()) {
      this.roles = this.tokenStorage.getAuthorities();
      this.showHideitem = true;
    }
  }

  logout() {
    this.tokenStorage.signOut();
    console.log('click : ' + this.router.url);
//     if (this.router.url === '/dashboard' || '/dashboard/*') {
//       // this.toastMessagesService.show("Logged out"); // display a toast style message if you have one :)
//         // this.router.navigate(['/']);
//         this.reloadPage();
//     } else {
//  // Stay here or do something
//  // for the case 'However if he is on a safe page I don't want to redirected him.'
//     }


    this.reloadPage();



  }

  reloadPage() {
    this.router.navigate(['auth/login']);

  }



}
