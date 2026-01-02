package designPattern.structuralDesignPattern;
/*
  we have legacy payment class , now client wants to use  new standard ( new interface)
*/

class  LegacyPayment{
    void makePayment(){
        System.out.println("Payment done using legacy class");
    }
}
interface  NewPayment{
    void  makePayment();

}
class  PaymentAdapter implements  NewPayment{
    private final LegacyPayment legacyPayment;

    public PaymentAdapter(LegacyPayment legacyPayment) {
        this.legacyPayment = legacyPayment;
    }

    @Override
    public void makePayment() {
        legacyPayment.makePayment();
    }
}


public class Adapter {
    public static void main(String args[]) {
        NewPayment newPayment=new PaymentAdapter(new LegacyPayment());
        newPayment.makePayment();
    }
}
