import { HomeComponent } from './home/home.component';
import { CrmHeaderComponent } from './header/crm-header.component';
import { BusyQaCrmComponent } from './busyqacrm/busyqacrm.component';
import { FooterComponent } from './footer/footer.component';

// AUTH
import { RegisterComponent } from './busyqacrm/auth/register/register.component';
import { LoginComponent } from './busyqacrm/auth/login/login.component';
import { ResetPasswordComponent } from './busyqacrm/auth/reset-password/reset-password.component';

// ADMIN
import { AdminComponent } from './busyqacrm/_admin/admin.component';
import { UsersListComponent } from './busyqacrm/_admin/users-list/users-list.component';
import { AddUserComponent } from './busyqacrm/_admin/add-user/add-user.component';
import { AddCourseComponent } from './busyqacrm/_admin/add-course/add-course.component';

// AUDIT
import { AuditComponent } from './busyqacrm/_audit/audit.component';
import { StudentsListComponent } from './busyqacrm/_audit/students-list/students-list.component';

// SALES
import { SearchLeadsComponent } from './busyqacrm/_sales/search-leads/search-leads.component';
import { AddLeadComponent } from './busyqacrm/_sales/add-lead/add-lead.component';
import { LeadDetailsComponent } from './busyqacrm/_sales/lead-details/lead-details.component';
import { SalesComponent } from './busyqacrm/_sales/sales.component';
import { LeadsListComponent } from './busyqacrm/_sales/leads-list/leads-list.component';


import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

// DEPENDENCIES
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injectable } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpInterceptor, HttpRequest, HttpHandler, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AutoSizeInputModule } from 'ngx-autosize-input';

import { httpInterceptorProviders } from './busyqacrm/auth/auth-interceptor';
import { routes } from './app-routing.module';
import { JwtHelperService, JWT_OPTIONS  } from '@auth0/angular-jwt';

// ANGULAR MATERIAL
import {MatButtonModule,
        MatCheckboxModule,
        MatTabsModule} from '@angular/material';
import {MatGridListModule} from '@angular/material/grid-list';

// FONT AWESOME
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';
import { fab } from '@fortawesome/free-brands-svg-icons';
library.add(fas, far, fab);

import { AppComponent } from './app.component';


@NgModule({
   declarations: [
      AppComponent,
      CrmHeaderComponent,
      BusyQaCrmComponent,
      FooterComponent,
      ResetPasswordComponent,
      LoginComponent,
      RegisterComponent,
      HomeComponent,
      AdminComponent,
      UsersListComponent,
      AddUserComponent,
      AuditComponent,
      StudentsListComponent,
      SalesComponent,
      LeadsListComponent,
      LeadDetailsComponent,
      AddLeadComponent,
      SearchLeadsComponent,
      AddCourseComponent
   ],
   imports: [
      BrowserModule,
      BrowserAnimationsModule,
      FormsModule,
      ReactiveFormsModule,
      HttpClientModule,
      FontAwesomeModule,
      AutoSizeInputModule,
      routes,
      NgMultiSelectDropDownModule.forRoot(),
      MatButtonModule,
      MatCheckboxModule,
      MatTabsModule,
      MatGridListModule
   ],
   providers: [
      httpInterceptorProviders,
      { provide: JWT_OPTIONS, useValue: JWT_OPTIONS },
      JwtHelperService,
      // { provide: NG_VALUE_ACCESSOR,
      //    multi: true,
      //    useExisting: forwardRef(() => MyControlComponent),}
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
