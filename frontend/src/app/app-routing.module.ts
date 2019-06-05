import { SearchLeadsComponent } from './busyqacrm/_sales/search-leads/search-leads.component';
import { AddLeadComponent } from './busyqacrm/_sales/add-lead/add-lead.component';
import { LeadDetailsComponent } from './busyqacrm/_sales/lead-details/lead-details.component';




import { Routes, RouterModule, CanActivate } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';


import { HomeComponent } from './home/home.component';

import { AdminComponent } from './busyqacrm/_admin/admin.component';
import { AuditComponent } from './busyqacrm/_audit/audit.component';
import { SalesComponent } from './busyqacrm/_sales/sales.component';


import { AuthGuardService } from './busyqacrm/services/auth-guard.service';
import { RegisterComponent } from './busyqacrm/auth/register/register.component';
import { LoginComponent } from './busyqacrm/auth/login/login.component';
import { ResetPasswordComponent } from './busyqacrm/auth/reset-password/reset-password.component';

export const router: Routes = [
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'auth', children: [
      { path: 'signup', component: RegisterComponent },
      { path: 'login', component: LoginComponent },
      { path: 'resetpassword', component: ResetPasswordComponent, canActivate: [AuthGuardService] }
    ]},

    { path: 'dashboard', children: [
      { path: 'admin', component: AdminComponent},
      { path: 'audit', component: AuditComponent },
      { path: 'sales', component: SalesComponent },
      { path: 'sales/lead/:email', component: LeadDetailsComponent },
      { path: 'sales/addlead', component: AddLeadComponent },
      { path: 'sales/searchlead', component: SearchLeadsComponent }

    ]}

    // { path: 'dashboard', children: [
    //   { path: '', component: BusyQaCrmComponent, canActivate: [AuthGuardService] },
    //   { path: 'leads', component: LeadsListComponent, canActivate: [AuthGuardService] },
    //   { path: 'students', component: StudentsListComponent, canActivate: [AuthGuardService] },
    //   { path: 'users', component: UsersListComponent, canActivate: [AuthGuardService] },

    // ]}

  ];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);



