package designPattern.structuralDesignPattern;
/*
 * Facade pattern provides a simple interface to a complex set of classes, libraries, or frameworks.
 * Ex->
 * In this Example, placing an order involves multiple operations such as payment processing, inventory update, and user notification.
   To avoid exposing this complexity to the client, a Facade is used to provide a single placeOrder() method.
 */

// Subsystem
class  PaymentService{
    public void pay(){
        System.out.println("Payment done !!");
    }
}
class InventoryService{
    public void updateStock(){
        System.out.println("Stock updated !!");
    }
}
class Nofitcationservice{
    public void notifyUser(){
        System.out.println("User notified !!");
    }
}

//Facadee interface
interface OrderStock{
    void  placeOder();
}

//Facade implementation
class orderStockImpl implements  OrderStock{
    private PaymentService paymentService;
    private Nofitcationservice nofitcationservice;
    private InventoryService inventoryService;
    orderStockImpl(){
        this.paymentService=new PaymentService();
        this.inventoryService=new InventoryService();
        this.nofitcationservice=new Nofitcationservice();
    }
    @Override
    public  void  placeOder(){
        paymentService.pay();
        inventoryService.updateStock();
        nofitcationservice.notifyUser();
    }
}
public class Facade {
    public static void main(String[] govind) {
        OrderStock orderStock=new orderStockImpl();
        orderStock.placeOder();
    }
}

