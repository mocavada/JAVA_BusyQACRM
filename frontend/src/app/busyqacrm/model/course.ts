import { Class } from './class';

export class Course {
    id: number;
    name: string;
    description: string;
    location: string;
    trainer: string;
    startDate: Date;
    endDate: Date;
    classes: Array<Class>;
}
