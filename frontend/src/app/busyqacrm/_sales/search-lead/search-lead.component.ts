import { Component, OnInit } from '@angular/core';
import { SearchItemPipe } from '../../services/search-item.pipe';
import { HttpClient } from '@angular/common/http';
import { SalesApiService } from '../../services/_sales-api.service';
import { Lead } from '../../model/client-lead';
import { Router } from '@angular/router';


@Component({
  selector: 'app-search-lead',
  templateUrl: './search-lead.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class SearchLeadComponent implements OnInit {

  leadList: Lead[];
  lead: any;
  query: string;
  currentLead: object;
  searchItem: SearchItemPipe;


  constructor(private http: HttpClient,
              private salesService: SalesApiService,
              private router: Router) {
              this.query = '';
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

  showLead(item: any) {
    this.query = item.firstName;
    item.highlight = !item.highlight;
    this.currentLead = item;
  }


}
