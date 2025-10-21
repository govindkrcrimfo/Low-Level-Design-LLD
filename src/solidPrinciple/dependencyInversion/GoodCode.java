package solidPrinciple.dependencyInversion;

/*
 *  Dependency Inversion Principle (D) of SOLID principle
 *  -> High level module should not depend on Low level module both should depends on abstraction
 *  -> makes your code decoupled (loosely coupled )
 * Good code example 
 *  -> here in Remote constructor if we pass SonyTv then sonytv turn on method will be called ,
 *     if we pass RedmiTv then RemdiTv  turn on method will be called
 *   So here code is decoupled(loosely coupling)
 */
interface RemoteControll {
    void turnOn();
}

class SonyTv implements RemoteControll {

    @Override
    public void turnOn() {
        System.out.println("Sony tv turn on logic");
    }
}

class RedmiTv implements RemoteControll {

    @Override
    public void turnOn() {
        System.out.println("Redmi tv turn on logic");
    }
}

// level module
class Remote {
    RemoteControll device;

    Remote(RemoteControll device) {
        this.device = device;
    }

    void pressOn() {
        device.turnOn();
    }
}

public class GoodCode {
    public static void main(String[] args) {
        Remote r = new Remote(new SonyTv());
        r.pressOn();

        Remote r1 = new Remote(new RedmiTv());
        r1.pressOn();

        /*
         * Based on the object we are passin , the turn on method is called
         * so its is loosely coupled
         */
    }

}
