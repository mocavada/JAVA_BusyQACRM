import { Component, OnInit } from '@angular/core';
import { Traininglocation } from '../../model/academics-traininglocation';
import { SalesApiService } from '../../services/_sales-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-traininglocation-list',
  templateUrl: './traininglocation-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class TraininglocationListComponent implements OnInit {

  trainingLocationList: Traininglocation[];

  constructor(private salesService: SalesApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.salesService.trainingLocationResult$.subscribe(data => {
      if (data != null) {
        this.trainingLocationList = data;
        console.log('Successful Loading trainingLocationList!');
        console.log(this.trainingLocationList);
      }
    });

    this.salesService.getAllTrainingLocation();
    console.log(this.trainingLocationList);

  }

}
