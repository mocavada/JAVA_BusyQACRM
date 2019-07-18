export class MailWelcomepackage {
  email: string;
  subject: string;
  message: string;
  imageUrl: string;

  constructor(email: string,
              subject: string,
              message: string
              ) {
    this.email = email;
    this.subject = subject;
    this.message = message;
    this.imageUrl =
    'https://sites.google.com/a/awesomewebsite.ca/members-profile/_/rsrc/1560396313530/home/busyqa_welcomepackage1.jpg';
  }
}
