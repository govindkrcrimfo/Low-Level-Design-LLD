package designPattern.behavioralDesignPattern;
/*
 *  different strategy to solve the same problem
 *  we can switch/add new strategies.
 */

interface PaymentMehtod {
    void pay(int amount);
}

class CreditCardPayment implements PaymentMehtod {
    @Override
    public void pay(int amount) {
        System.out.println(amount+ " Paid through credit card ");
    }
}

class UPIPayment implements PaymentMehtod {
    @Override
    public void pay(int amount) {
        System.out.println(amount+ " Paid through UPI payment");
    }

}

class PaymentProcessor implements PaymentMehtod {
    private PaymentMehtod paymentMehtod;

    PaymentProcessor(PaymentMehtod paymentMehtod) {
        this.paymentMehtod = paymentMehtod;
    }

    @Override
    public void pay(int amount) {
        paymentMehtod.pay(amount);
    }

    // setter method to change the paymment method at runtime
    void setPayment(PaymentMehtod paymentMehtod){
        this.paymentMehtod=paymentMehtod;
    }

}

public class StrategyPattern {
    public static void main(String[] args) {
        CreditCardPayment c = new CreditCardPayment();
        UPIPayment upi = new UPIPayment();
        PaymentProcessor p = new PaymentProcessor(c);
        p.pay(100);
        p.setPayment(upi);  // changed the payment method to upi at runtime 
        p.pay(500);
    }
}
