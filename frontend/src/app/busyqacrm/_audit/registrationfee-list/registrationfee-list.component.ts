import { RegistrationFee } from './../../model/finance-registrationfee';
import { Component, OnInit } from '@angular/core';
import { AuditApiService } from '../../services/_audit-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registrationfee-list',
  templateUrl: './registrationfee-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class RegistrationfeeListComponent implements OnInit {

  registrationFeeList: RegistrationFee[];

  constructor(private auditService: AuditApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.auditService.registrationFeeResult$.subscribe(data => {
      if (data != null) {
        this.registrationFeeList = data;
        console.log('Successful Loading registrationFeeList!');
        console.log(this.registrationFeeList);
      }
    });

    this.auditService.getAllRegistrationFee();
    console.log(this.registrationFeeList);

  }

}
