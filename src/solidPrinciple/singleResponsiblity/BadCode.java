package solidPrinciple.singleResponsiblity;

/*
 * Single reponsiblity principle (S)
 * Bad code Example
 */
class Painter {
    void doPainting() {
        System.out.println("Do paiting !!");
    }

    /*
     * do cooking method , voilates single resoponsiblity princliple
     * Painter class should contain method related to painting
     */
    void doCooking() {
        System.out.println("Do cooking ");
    }
}

public class BadCode {
    public static void main(String[] args) {
        System.out.println("Bad code for : Single Responsiblity principle ");
    }

}
