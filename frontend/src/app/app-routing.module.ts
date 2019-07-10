
import { UsersListComponent } from './busyqacrm/_admin/users-list/users-list.component';
import { CoursescheduleListComponent } from './busyqacrm/_sales/courseschedule-list/courseschedule-list.component';
import { CourseListComponent } from './busyqacrm/_sales/course-list/course-list.component';
import { Routes, RouterModule, CanActivate } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { AdminComponent } from './busyqacrm/_admin/admin.component';
// AUDIT
import { AuditComponent } from './busyqacrm/_audit/audit.component';
import { StudentsListComponent } from './busyqacrm/_audit/students-list/students-list.component';
// SALES
import { SalesComponent } from './busyqacrm/_sales/sales.component';
import { LeadsListComponent } from './busyqacrm/_sales/leads-list/leads-list.component';
import { SearchLeadsComponent } from './busyqacrm/_sales/search-leads/search-leads.component';
import { LeadDetailsComponent } from './busyqacrm/_sales/lead-details/lead-details.component';
import { UserDetailsComponent } from './busyqacrm/_sales/user-details/user-details.component';

import { AuthGuardService } from './busyqacrm/services/auth-guard.service';
import { RegisterComponent } from './busyqacrm/security/register/register.component';
import { LoginComponent } from './busyqacrm/security/login/login.component';
import { ResetPasswordComponent } from './busyqacrm/security/reset-password/reset-password.component';



export const router: Routes = [
    { path: '', redirectTo: 'auth/login', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'auth', children: [
      { path: 'signup', component: RegisterComponent },
      { path: 'login', component: LoginComponent },
      { path: 'resetpassword', component: ResetPasswordComponent, canActivate: [AuthGuardService] }
    ]},

    { path: 'dashboard', children: [
      { path: 'admin', component: AdminComponent},
      { path: 'admin/userlist', component: UsersListComponent},
      { path: 'audit', component: AuditComponent },
      { path: 'audit/studentslist', component: StudentsListComponent },
      { path: 'sales', component: SalesComponent },
      { path: 'sales/leadslist', component: LeadsListComponent },
      { path: 'sales/lead/:email', component: LeadDetailsComponent },
      { path: 'sales/leadbyuser/:username', component: UserDetailsComponent },
      { path: 'sales/searchlead', component: SearchLeadsComponent },
      { path: 'sales/courselist', component: CourseListComponent },
      { path: 'sales/courseschedulelist', component: CoursescheduleListComponent }

    ]}

    // { path: 'dashboard', children: [
    //   { path: '', component: BusyQaCrmComponent, canActivate: [AuthGuardService] },
    //   { path: 'leads', component: LeadsListComponent, canActivate: [AuthGuardService] },
    //   { path: 'students', component: StudentsListComponent, canActivate: [AuthGuardService] },
    //   { path: 'auth', component: UsersListComponent, canActivate: [AuthGuardService] },

    // ]}

  ];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);



