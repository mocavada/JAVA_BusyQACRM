import { Usergroup } from './auth-usergroup';

export class User {
  id: number;
  username: string;
  password: string;
  email: string;

  firstName: string;
  lastName: string;
  phoneNumber: string;
  emergencyPhone: string;

  dtype: string;
  createdTime: Date;
  modifiedTime: Date;

  usergroups: Usergroup;
}
