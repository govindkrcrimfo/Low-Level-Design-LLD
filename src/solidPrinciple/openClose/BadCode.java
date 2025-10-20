package solidPrinciple.openClose;

/*
 * Open / Close  principle (O)
 * -> class should open for Extension ,but closed for modification
 * Bad code Example
 *  -> if we want to send notification for whatsapp,
 *     then we need to modify the existing Notification class method ,
 *     thats voilates OPEN/CLOSE principle
 */
class Notification {
    void sendNotification(String msg, String notificationType) {
        if (notificationType == "Email") {
            System.out.println("Send Email, " + msg);
        } else if (notificationType == "SMS") {
            System.out.println("Send SMS, " + msg);
        }
    }
}

public class BadCode {
    public static void main(String[] args) {
        Notification n = new Notification();
        n.sendNotification("Email sent ", "Email");
        n.sendNotification("SMS sent ", "SMS");

    }

}
