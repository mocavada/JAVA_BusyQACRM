import { Component, OnInit } from '@angular/core';
import { Trainer } from '../../model/academics-trainer';
import { SalesApiService } from '../../services/_sales-api.service';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, ValidationErrors } from '@angular/forms';

@Component({
  selector: 'app-add-trainer',
  templateUrl: './add-trainer.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class AddTrainerComponent implements OnInit {

  validMessage = '';
  message: string;

  // nestedForm: FormGroup;
  createTrainerForm: FormGroup;

  constructor(private salesService: SalesApiService,
              private fb: FormBuilder,
              private router: Router) { }

  ngOnInit() {
    this.createTrainerForm = this.fb.group({
      trainerName: [],
      trainerEmail: [],
      trainerPhone: [],
      trainerSkype: [],
      trainerImage: []
    });
  }

  onSubmit(f: any) {
    if (f.valid) {
      this.validMessage = 'Your information has been saved. Thank you!';
      console.log('This form is good to go.');
      this.salesService.addTrainer(f.value);
      this.createTrainerForm.reset();
    } else {
      console.log(f.value);
    }

    this.router.navigate(['dashboard/admin']);

  }

  relaod() {
    window.location.reload();
  }

  getFormValidationErrors() {
    Object.keys(this.createTrainerForm.controls).forEach(key => {

    const controlErrors: ValidationErrors = this.createTrainerForm.get(key).errors;
    if (controlErrors != null) {
          Object.keys(controlErrors).forEach(keyError => {
            console.log('Key control: ' + key + ', keyError: ' + keyError + ', err value: ', controlErrors[keyError]);
          });
        }
      });
    }



}
