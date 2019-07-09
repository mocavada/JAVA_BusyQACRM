import { Usergroup } from './auth-usergroup';
import { User } from './auth-user';

export class Employee extends User {
    jobTitle: string;
    jobDescription: string;
    jobStatus: string;
    annualSalary: number;
}


//   id: number;
//   username: string;
//   password: string;
//   email: string;
//   firstName: string;
//   lastName: string;
//   phoneNumber: string;
//   emergencyPhone: string;
//   dtype: string;
//   createdTime: Date;
//   modifiedTime: Date;
//   usergroups: AuthUsergroup;
