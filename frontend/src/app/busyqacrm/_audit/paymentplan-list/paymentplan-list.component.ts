import { Paymentplan } from './../../model/finance-paymentplan';
import { Component, OnInit } from '@angular/core';
import { AuditApiService } from '../../services/_audit-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-paymentplan-list',
  templateUrl: './paymentplan-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class PaymentplanListComponent implements OnInit {

  paymentPlanList: Paymentplan[];

  constructor(private auditService: AuditApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.auditService.paymentPlanResult$.subscribe(data => {
      if (data != null) {
        this.paymentPlanList = data;
        console.log('Successful Loading paymentPlanList!');
        console.log(this.paymentPlanList);
      }
    });

    this.auditService.getAllPaymentPlan();
    console.log(this.paymentPlanList);

  }
}
