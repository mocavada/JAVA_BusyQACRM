import { User } from './auth-user';

export class Lead extends User {
    clientStatus: string;
    leadSource: string;
    comments: string;
    currentlyEmployed: string;
    currentlyITEmployed: string;
    desiredJob: string;

    mailingStreet: string;
    mailingCity: string;
    mailingState: string;
    mailingZip: string;
    mailingCountry: string;

    isRegistrationFeePaid: boolean;
    isPlanAgreementSigned: boolean;
    isDiscountGiven: boolean;
}
