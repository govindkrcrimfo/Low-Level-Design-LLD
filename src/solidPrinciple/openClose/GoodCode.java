package solidPrinciple.openClose;

/*
 * Open / Close  principle (O)
 * -> class should open for Extension ,but closed for modification
 * Good code example 
 *  -> if we want to add whatsapp notifcation ,
 *     we can implements Notification interface and
 *     have write the logic for whatsapp nofitcation in whatsapp calss,
 *     So we are not modifying the existing class but we are extending it.
 */
interface Notification1 {
    void sendNotification(String msg);
}

class Email implements Notification1 {

    @Override
    public void sendNotification(String msg) {
        System.out.println("Email send , " + msg);
    }
}

class SMS implements Notification1 {

    @Override
    public void sendNotification(String msg) {
        System.out.println("SMS send , " + msg);
    }

}

public class GoodCode {
    public static void main(String[] args) {
        Notification1 n = new Email();
        n.sendNotification("Email sent !!");
        Notification1 n1 = new SMS();
        n1.sendNotification("SMS sent !!");

    }
}
