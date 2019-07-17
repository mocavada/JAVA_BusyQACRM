import { Component, OnInit } from '@angular/core';
import { Lead } from '../../model/client-lead';
import { SalesApiService } from '../../services/_sales-api.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-leads-list-clientstatus',
  templateUrl: './leads-list-clientstatus.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class LeadsListClientstatusComponent implements OnInit {
  private sub: Subscription;
  clientStatusList: Lead[];

  constructor(private salesService: SalesApiService,
              private route: ActivatedRoute,
              private router: Router) {

  }

  ngOnInit() {
    this.salesService.leadResult$.subscribe(data => {
      if (data != null) {
        this.clientStatusList = data;
        console.log('Successful Loading Lead List!');
        console.log(this.clientStatusList);
      }

    });

    this.sub = this.route.paramMap.subscribe(
      params => {
        const status = params.get('status');
        this.salesService.getLeadsByClientStatus(status);
      }
    );


    console.log(this.clientStatusList);

  }

}
