import { Lead } from './client-lead';
import { LateFee } from './finance-latefee';

import { Payment } from './finance-payment';

export class Student extends Lead {
    amountPaid: number;
    balance: number;
    weeklyPayment: number;
    isPaymentLate: boolean;

    payments: Payment;
    lateFee: LateFee;

}
