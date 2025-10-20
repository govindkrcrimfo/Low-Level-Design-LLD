package solidPrinciple.singleResponsiblity;

/*
 * Single reponsiblity principle (S)
 * Good code Example
 * seperate class for seperate functionality 
 */
class Painter {
    void doPainting() {
        System.out.println("Do painting ");
    }
}

class Cook {
    void doCooking() {
        System.out.println("Do Cooking ");
    }
}

public class GoodCode {
    public static void main(String[] args) {
        System.out.println("Good Code example for : Single Responsiblity principle");
    }
}
