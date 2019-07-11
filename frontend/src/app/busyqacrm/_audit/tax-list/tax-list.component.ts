import { Component, OnInit } from '@angular/core';
import { Tax } from '../../model/finance-tax';
import { AuditApiService } from '../../services/_audit-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tax-list',
  templateUrl: './tax-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class TaxListComponent implements OnInit {

  taxList: Tax[];

  constructor(private auditService: AuditApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.auditService.taxResult$.subscribe(data => {
      if (data != null) {
        this.taxList = data;
        console.log('Successful Loading taxList!');
        console.log(this.taxList);
      }
    });

    this.auditService.getAllTax();
    console.log(this.taxList);

  }

}
