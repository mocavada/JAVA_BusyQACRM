import { Course } from './course';
import { Payment } from './payment';

export class Client {
    id: number;
    clientStatus: string;
    leadStatus: string;
    firstName: string;
    lastName: string;
    phone: string;
    email: string;
    emergencyPhone: string;

     registrationFee: number;
     course: Course;
     createdTime: Date;
     modifiedTime: Date;
     lastActivityTime: any;

    // FOR LEADS ONLY
     leadSource: string;
     comments: string;
     currentlyEmployed: boolean;
     currentlyITEmployed: boolean;
     desiredJob: string;

    // ADDRESS
     mailingCity: string;
     mailingCountry: string;
     mailingState: string;
     mailingStreet: string;
     mailingZip: string;

    // PLAN
     paymentPlan: string;
     planAgreement: any;
     paymentPlanStatus: string;
     registrationFeePaid: boolean;

    // FOR STUDENTS ONLY
     totalFee: number;
     balance: number;

     payments: Array<Payment>;

}
