import { SalesApiService } from '../../services/_sales-api.service';
import { FormBuilder, FormGroup, FormArray } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class AddCourseComponent implements OnInit {
  validMessage = '';
  message: string;
  index1 = 1;

  // nestedForm: FormGroup;
  createCourseForm: FormGroup;

  constructor(private salesService: SalesApiService,
              private fb: FormBuilder) { }

  ngOnInit() {
    this.createCourseForm = this.fb.group({
      name: [],
      trainer: [],
      location: [],
      description: [],
      time: [],
      startDate: [],
      endDate: [],
      //
      classes: this.fb.array([this.addClassesGroup()])
    });
  }

  addClassesGroup() {
    return this.fb.group({
      name: [],
      description: [],
      units: []
    });
  }

  addClasses() {
    this.classesArray.push(this.addClassesGroup());
  }

  removeClasses(index: any) {
    this.classesArray.removeAt(index);
  }

  get classesArray() {
    return this.createCourseForm.get('classes') as FormArray;
  }

  onSubmit(f: any) {
    if (f.valid) {
      this.validMessage = 'Your information has been saved. Thank you!';
      console.log('This form is good to go.');
      this.salesService.addCourse(f.value);
      this.createCourseForm.reset();
    } else {
      console.log(f.value);
    }
  }

}
