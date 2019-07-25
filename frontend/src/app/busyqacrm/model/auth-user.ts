import { Usergroup } from './auth-usergroup';

export class User {
  createdTime: Date;
  modifiedTime: Date;
  id: number;
  email: string;
  firstName: string;
  lastName: string;

  phoneNumber: string;
  emergencyPhone: string;
  dtype: string;
  userState: string;
  usergroups: Usergroup;
}
