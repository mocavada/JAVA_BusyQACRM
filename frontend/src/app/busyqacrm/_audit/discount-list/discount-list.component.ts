
import { Component, OnInit } from '@angular/core';
import { AuditApiService } from '../../services/_audit-api.service';
import { Router } from '@angular/router';
import { Discount } from '../../model/finance-discount';

@Component({
  selector: 'app-discount-list',
  templateUrl: './discount-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class DiscountListComponent implements OnInit {

  discountList: Discount[];

  constructor(private auditService: AuditApiService,
              ) {
  }

  ngOnInit() {
    this.auditService.discountResult$.subscribe(data => {
      if (data != null) {
        this.discountList = data;
        console.log('Successful Loading Discount List!');
        console.log(this.discountList);
      }
    });

    this.auditService.getAllDiscount();
    console.log(this.discountList);

  }

}
