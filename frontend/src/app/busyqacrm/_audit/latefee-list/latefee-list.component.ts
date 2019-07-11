import { LateFee } from './../../model/finance-latefee';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuditApiService } from '../../services/_audit-api.service';

@Component({
  selector: 'app-latefee-list',
  templateUrl: './latefee-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class LatefeeListComponent implements OnInit {

  lateFeeList: LateFee[];

  constructor(private auditService: AuditApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.auditService.lateFeeResult$.subscribe(data => {
      if (data != null) {
        this.lateFeeList = data;
        console.log('Successful Loading Trainer List!');
        console.log(this.lateFeeList);
      }
    });

    this.auditService.getAllLateFee();
    console.log(this.lateFeeList);

  }

}
