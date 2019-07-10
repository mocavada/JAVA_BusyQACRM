import { Lead } from './../../model/client-lead';
import { SalesApiService } from '../../services/_sales-api.service';
import { Component, OnInit, Input } from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-leads-list',
  templateUrl: './leads-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class LeadsListComponent implements OnInit {

  leadList: Lead[];

  constructor(private salesService: SalesApiService,
              private router: Router) {

  }

  ngOnInit() {
    this.salesService.leadResult$.subscribe(data => {
      if (data != null) {
        this.leadList = data;
        console.log('Successful Loading Lead List!');
        console.log(this.leadList);
      }
    });

    this.salesService.getAllLeads();
    console.log(this.leadList);

  }

}



