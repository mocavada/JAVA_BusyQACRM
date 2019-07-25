import { Discount } from './finance-discount';
import { RegistrationFee } from './finance-registrationfee';
import { Traininglocation } from './academics-traininglocation';
import { Trainer } from './academics-trainer';
import { CourseSchedule } from './academics-courseschedule';
import { Paymentplan } from './finance-paymentplan';
import { Course } from './academics-course';
import { User } from './auth-user';
import { Tax } from './finance-tax';


export class Lead extends User {
    clientStatus: string;
    leadSource: string;
    comments: string;
    isCurrentlyEmployed: boolean;
    isCurrentlyITEmployed: boolean;
    desiredJob: string;

    mailingStreet: string;
    mailingCity: string;
    mailingState: string;
    mailingZip: string;
    mailingCountry: string;

    isRegistrationFeePaid: boolean;
    isPlanAgreementSigned: boolean;
    isDiscountGiven: boolean;

    registrationFee: RegistrationFee;
    discount: Discount;
    tax: Tax;
    paymentPlan: Paymentplan;

    course: Course;
    totalCourseFee: number;

    courseSchedule: CourseSchedule;
    trainer: Trainer;
    trainingLocation: Traininglocation;

}
