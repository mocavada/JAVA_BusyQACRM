import { SalesApiService } from '../../services/_sales-api.service';
import { FormBuilder, FormGroup, FormArray, ValidationErrors } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-courseschedule',
  templateUrl: './add-courseschedule.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class AddCoursescheduleComponent implements OnInit {
  validMessage = '';
  message: string;

  // nestedForm: FormGroup;
  createCourseScheduleForm: FormGroup;

  constructor(private salesService: SalesApiService,
              private fb: FormBuilder,
              private router: Router) { }

  ngOnInit() {
    this.createCourseScheduleForm = this.fb.group({
      name: [],
      dateStart: [],
      dateEnd: [],
      timeStart: [],
      timeEnd: [],
    });
  }

  onSubmit(f: any) {
    if (f.valid) {
      this.validMessage = 'Your information has been saved. Thank you!';
      console.log('This form is good to go.');
      this.salesService.addCourseSchedule(f.value);
      this.createCourseScheduleForm.reset();
    } else {
      console.log(f.value);
    }

    this.router.navigate(['dashboard/admin']);

  }

  relaod() {
    window.location.reload();
  }


  getFormValidationErrors() {
    Object.keys(this.createCourseScheduleForm.controls).forEach(key => {

    const controlErrors: ValidationErrors = this.createCourseScheduleForm.get(key).errors;
    if (controlErrors != null) {
          Object.keys(controlErrors).forEach(keyError => {
            console.log('Key control: ' + key + ', keyError: ' + keyError + ', err value: ', controlErrors[keyError]);
          });
        }
      });
    }

}
