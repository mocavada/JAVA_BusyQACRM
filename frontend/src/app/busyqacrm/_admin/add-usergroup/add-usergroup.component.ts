import { AdminApiService } from './../../services/_admin-api.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, ValidationErrors } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-usergroup',
  templateUrl: './add-usergroup.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class AddUsergroupComponent implements OnInit {
  validMessage = '';
  message: string;

  // nestedForm: FormGroup;
  createUserGroupForm: FormGroup;

  constructor(private adminService: AdminApiService,
              private fb: FormBuilder,
              private router: Router) { }

  ngOnInit() {
    this.createUserGroupForm = this.fb.group({
      role: [],
      groups: []
    });
  }

  onSubmit(f: any) {
    if (f.valid) {
      this.validMessage = 'Your information has been saved. Thank you!';
      console.log('This form is good to go.');
      this.adminService.addUserGroup(f.value);
      this.createUserGroupForm.reset();
    } else {
      console.log(f.value);
    }

    this.router.navigate(['dashboard/admin']);

  }

  relaod() {
    window.location.reload();
  }


  getFormValidationErrors() {
    Object.keys(this.createUserGroupForm.controls).forEach(key => {

    const controlErrors: ValidationErrors = this.createUserGroupForm.get(key).errors;
    if (controlErrors != null) {
          Object.keys(controlErrors).forEach(keyError => {
            console.log('Key control: ' + key + ', keyError: ' + keyError + ', err value: ', controlErrors[keyError]);
          });
        }
      });
    }

}
