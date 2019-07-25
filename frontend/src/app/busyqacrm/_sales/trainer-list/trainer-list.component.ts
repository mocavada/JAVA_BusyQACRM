import { Component, OnInit } from '@angular/core';
import { Trainer } from '../../model/academics-trainer';
import { SalesApiService } from '../../services/_sales-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-trainer-list',
  templateUrl: './trainer-list.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class TrainerListComponent implements OnInit {

  trainerList: Trainer[];

  constructor(private salesService: SalesApiService,
              private router: Router) {
  }

  ngOnInit() {
    this.salesService.trainerResult$.subscribe(data => {
      if (data != null) {
        this.trainerList = data;
        console.log('Successful Loading Trainer List!');
        console.log(this.trainerList);
      }
    });

    this.salesService.getAllTrainer();
    console.log(this.trainerList);

  }
}
