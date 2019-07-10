import { Component, OnInit, Input } from '@angular/core';
import { Lead } from './../../model/client-lead';

@Component({
  selector: 'app-lead-item',
  templateUrl: './lead-item.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class LeadItemComponent implements OnInit {

  @Input() lead: Lead[];

  constructor() { }

  ngOnInit() {
  }

}
