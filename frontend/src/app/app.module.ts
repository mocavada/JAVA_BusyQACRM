


import { HomeComponent } from './home/home.component';
import { CrmHeaderComponent } from './header/crm-header.component';
import { BusyQaCrmComponent } from './busyqacrm/busyqacrm.component';
import { FooterComponent } from './footer/footer.component';
// PIPE
import { SearchItemPipe } from './busyqacrm/services/search-item.pipe';

// AUTH
import { RegisterComponent } from './busyqacrm/public/register/register.component';
import { LoginComponent } from './busyqacrm/public/login/login.component';
import { ResetPasswordComponent } from './busyqacrm/public/reset-password/reset-password.component';

// ADMIN
import { AdminComponent } from './busyqacrm/_admin/admin.component';
import { UsersListComponent } from './busyqacrm/_admin/users-list/users-list.component';
import { AddUsergroupComponent } from './busyqacrm/_admin/add-usergroup/add-usergroup.component';
import { UsergroupListComponent } from './busyqacrm/_admin/usergroup-list/usergroup-list.component';


// AUDIT
import { AuditComponent } from './busyqacrm/_audit/audit.component';
import { StudentsListComponent } from './busyqacrm/_audit/students-list/students-list.component';

// SALES
import { SearchLeadsComponent } from './busyqacrm/_sales/search-leads/search-leads.component';
import { LeadDetailsComponent } from './busyqacrm/_sales/lead-details/lead-details.component';
import { LeadItemComponent } from './busyqacrm/_sales/lead-item/lead-item.component';
import { SalesComponent } from './busyqacrm/_sales/sales.component';
import { LeadsListComponent } from './busyqacrm/_sales/leads-list/leads-list.component';
import { AddCourseComponent } from './busyqacrm/_sales/add-course/add-course.component';
import { CourseListComponent } from './busyqacrm/_sales/course-list/course-list.component';
import { CoursescheduleListComponent } from './busyqacrm/_sales/courseschedule-list/courseschedule-list.component';
import { AddCoursescheduleComponent } from './busyqacrm/_sales/add-courseschedule/add-courseschedule.component';
import { AddTrainerComponent } from './busyqacrm/_sales/add-trainer/add-trainer.component';
import { TrainerListComponent } from './busyqacrm/_sales/trainer-list/trainer-list.component';
import { UserDetailsComponent } from './busyqacrm/_sales/user-details/user-details.component';


import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';

// DEPENDENCIES
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, Injectable } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpInterceptor, HttpRequest, HttpHandler, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AutoSizeInputModule } from 'ngx-autosize-input';

import { httpInterceptorProviders } from './busyqacrm/security/auth-interceptor';
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
      UsergroupListComponent,
      AddUsergroupComponent,
      UsersListComponent,
      AuditComponent,
      StudentsListComponent,
      SalesComponent,
      LeadsListComponent,
      LeadDetailsComponent,
      LeadItemComponent,
      SearchLeadsComponent,
      AddCourseComponent,
      CourseListComponent,
      AddCoursescheduleComponent,
      CoursescheduleListComponent,
      TrainerListComponent,
      AddTrainerComponent,
      UserDetailsComponent,
      SearchItemPipe
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
