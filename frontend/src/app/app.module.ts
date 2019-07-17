
import { LeadsListClientstatusComponent } from './busyqacrm/_sales/leads-list-clientstatus/leads-list-clientstatus.component';

import { TestWeatherService } from './busyqacrm/services/test-weather.service';

import { HomeComponent } from './home/home.component';
import { CrmHeaderComponent } from './header/crm-header.component';
import { BusyQaCrmComponent } from './busyqacrm/busyqacrm.component';
import { FooterComponent } from './footer/footer.component';
// PIPE
import { SearchItemPipe } from './busyqacrm/services/search-item.pipe';
import { TextBoldPipe } from './busyqacrm/services/text-bold.pipe';

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
import { TaxListComponent } from './busyqacrm/_audit/tax-list/tax-list.component';
import { TaxAddComponent } from './busyqacrm/_audit/tax-add/tax-add.component';
import { RegistrationfeeListComponent } from './busyqacrm/_audit/registrationfee-list/registrationfee-list.component';
import { RegistrationfeeAddComponent } from './busyqacrm/_audit/registrationfee-add/registrationfee-add.component';
import { PaymentplanListComponent } from './busyqacrm/_audit/paymentplan-list/paymentplan-list.component';
import { PaymentplanAddComponent } from './busyqacrm/_audit/paymentplan-add/paymentplan-add.component';
import { LatefeeListComponent } from './busyqacrm/_audit/latefee-list/latefee-list.component';
import { LatefeeAddComponent } from './busyqacrm/_audit/latefee-add/latefee-add.component';
import { DiscountListComponent } from './busyqacrm/_audit/discount-list/discount-list.component';
import { DiscountAddComponent } from './busyqacrm/_audit/discount-add/discount-add.component';
import { SearchStudentComponent } from './busyqacrm/_audit/search-student/search-student.component';
import { StudentItemComponent } from './busyqacrm/_audit/student-item/student-item.component';
import { StudentDetailsComponent } from './busyqacrm/_audit/student-details/student-details.component';
import { FinanceComponent } from './busyqacrm/_audit/finance.component';


// SALES
import { SearchLeadComponent } from './busyqacrm/_sales/search-lead/search-lead.component';
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
import { AddTraininglocationComponent } from './busyqacrm/_sales/add-traininglocation/add-traininglocation.component';
import { TraininglocationListComponent } from './busyqacrm/_sales/traininglocation-list/traininglocation-list.component';

import { UserDetailsComponent } from './busyqacrm/_sales/user-details/user-details.component';
import { AcademicsComponent } from './busyqacrm/_sales/academics.component';
import { OverviewSalesComponent } from './busyqacrm/_sales/overview-sales/overview-sales.component';



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
      StudentDetailsComponent,
      FinanceComponent,
      StudentItemComponent,
      SearchStudentComponent,
      TaxListComponent,
      TaxAddComponent,
      RegistrationfeeAddComponent,
      RegistrationfeeListComponent,
      PaymentplanAddComponent,
      PaymentplanListComponent,
      LatefeeAddComponent,
      LatefeeListComponent,
      DiscountAddComponent,
      DiscountListComponent,
      SalesComponent,
      OverviewSalesComponent,
      AcademicsComponent,
      LeadsListComponent,
      LeadsListClientstatusComponent,
      LeadDetailsComponent,
      LeadItemComponent,
      SearchLeadComponent,
      AddCourseComponent,
      CourseListComponent,
      AddCoursescheduleComponent,
      CoursescheduleListComponent,
      TrainerListComponent,
      AddTrainerComponent,
      AddTraininglocationComponent,
      TraininglocationListComponent,
      UserDetailsComponent,
      SearchItemPipe,
      TextBoldPipe
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
      JwtHelperService, TestWeatherService
      // { provide: NG_VALUE_ACCESSOR,
      //    multi: true,
      //    useExisting: forwardRef(() => MyControlComponent),}
   ],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
