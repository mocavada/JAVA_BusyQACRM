import { Component, OnInit, Input } from '@angular/core';
import { Student } from '../../model/client-student';

@Component({
  selector: 'app-student-item',
  templateUrl: './student-item.component.html',
  styleUrls: ['../.././busyqacrm.component.css']
})
export class StudentItemComponent implements OnInit {

  @Input() student: Student[];

  constructor() { }

  ngOnInit() {
  }

}
