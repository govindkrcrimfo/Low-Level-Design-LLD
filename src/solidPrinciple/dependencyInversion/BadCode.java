package solidPrinciple.dependencyInversion;
/*
 *  Dependency Inversion Principle (D) of SOLID principle
 *  -> High level module should not depend on Low level module both should depends on abstraction
 *  -> makes your code decoupled (loosely coupled )
 * Bad code example 
 *  -> to cal turnOn we need the object of SonyTv only , this is tight coupling
 */

// high level module
class RemoteController1 {
    private SonyTv1 SonyTv;

    RemoteController1(SonyTv1 sonyTv) {
        this.SonyTv = sonyTv;
    }

    void powerOn() {
        SonyTv.turnOn();
    }
}

// Low level module
class SonyTv1 {
    void turnOn() {
        System.out.println("Turn on logic for sony tv");
    }
}

public class BadCode {
    public static void main(String[] args) {
        RemoteController1 r = new RemoteController1(new SonyTv1());
        r.powerOn();
    }

}
