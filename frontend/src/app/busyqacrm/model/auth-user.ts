import { Usergroup } from './auth-usergroup';

export class User {
  createdTime: Date;
  modifiedTime: Date;
  email: string;
  firstName: string;
  lastName: string;

  phoneNumber: string;
  emergencyPhone: string;
  dtype: string;
  userState: string;
  usergroups: Usergroup;
}
