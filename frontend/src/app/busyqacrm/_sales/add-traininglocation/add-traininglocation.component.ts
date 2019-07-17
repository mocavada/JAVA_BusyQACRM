import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { SalesApiService } from '../../services/_sales-api.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-traininglocation',
  templateUrl: './add-traininglocation.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class AddTraininglocationComponent implements OnInit {

  validMessage = '';
  message: string;
  isOnlineYes: boolean;
  onlineValue = '';

  // nestedForm: FormGroup;
  createTrainingLocationForm: FormGroup;

  constructor(private salesService: SalesApiService,
              private fb: FormBuilder,
              private router: Router) {


              }

  ngOnInit() {
    this.createTrainingLocationForm = this.fb.group({
      isOnLine: [],
      name: [],
      street: [],
      city: [],
      state: [],
      zip: []

    });

    console.log(this.isOnlineYes);
  }

  onSubmit(f: any) {
    if (f.valid) {
      this.validMessage = 'Your information has been saved. Thank you!';
      console.log('This form is good to go.');

      if (f.value.isOnLine) {
          f.value.name = 'Online';
      }

      this.salesService.addTrainingLocation(f.value);
      this.createTrainingLocationForm.reset();
    } else {
      console.log(f.value);
    }
    // PLS CHANGE - Must Navigate to own page
    this.router.navigate(['dashboard/admin']);

  }

  relaod() {
    window.location.reload();
  }

  onClick() {
    this.isOnlineYes = !this.isOnlineYes;
    this.onlineValue = 'OnLine';
    console.log(this.onlineValue + 'is the value :' + this.isOnlineYes);
}


}
