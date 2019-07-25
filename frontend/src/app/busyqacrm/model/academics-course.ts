import { Class } from './academics-class';

export class Course {
    courseId: number;
    name: string;
    batch: string;
    description: string;
    fee: number;
    classes: Class;

    createdTime: Date;
    modifiedTime: Date;
}
