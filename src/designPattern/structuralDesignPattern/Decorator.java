package designPattern.structuralDesignPattern;

/*
First, we create a base payment object.
Then we wrap it with a tax decorator to add tax.
After that, we wrap it again with a service charge decorator.
Finally, we wrap it with a discount decorator.
Each decorator adds its own logic without modifying the original payment class.
 */

interface  Payment{
    double getAmount();
}
class  BasePayment implements  Payment{
    public double getAmount(){
        return 1000;   // fix base payment
    }
}
class  PaymentDecorator implements Payment{
    private  Payment payment;
     PaymentDecorator(Payment payment){
        this.payment=payment;
    }
    public  double getAmount(){
       return payment.getAmount();
    }


}
class  TaxDecorator extends   PaymentDecorator{
     TaxDecorator(Payment payment ){
        super(payment);
    }
    public double getAmount(){
         return  super.getAmount()+100; // tax charge 100
    }
}
class  ServiceChargeDecorator extends  PaymentDecorator{
    ServiceChargeDecorator(Payment payment){
        super(payment);
    }
    public double getAmount(){
        return super.getAmount()+50;  // service charge 50
    }
}
class DiscountDecorator extends  PaymentDecorator{
    DiscountDecorator (Payment payment){
        super(payment);
    }

    @Override
    public double getAmount() {
        return super.getAmount()-200 ;  // discount 200
    }
}
public class Decorator {
    public static void main(String args[]) {
        // Step 1: Create base payment (actual amount)
        Payment basePayment = new BasePayment();
        System.out.println("Base Amount: " + basePayment.getAmount());

        // Step 2: Add tax to base payment
        Payment taxPayment = new TaxDecorator(basePayment);
        System.out.println("After Tax: " + taxPayment.getAmount());

        // Step 3: Add service charge on top of tax
        Payment servicePayment = new ServiceChargeDecorator(taxPayment);
        System.out.println("After Service Charge: " + servicePayment.getAmount());

        // Step 4: Apply discount on final amount
        Payment finalPayment = new DiscountDecorator(servicePayment);
        System.out.println("Final Amount after Discount: " + finalPayment.getAmount());
    }
}
