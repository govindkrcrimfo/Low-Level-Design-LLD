package designPattern.structuralDesignPattern;
/*
 * A Proxy is an object that stands in front of another object and controls access to it.
 * Ex->
 * In this example, a Proxy is used to control access to bank account details by checking the user’s role before calling the real service.
   This ensures security and prevents unauthorized users from accessing sensitive information.
 */
interface  BankAccount{
    void viewAccountDetails();
}
// Real Ojbect/class
class  BankAccountService implements  BankAccount{
    @Override
    public void viewAccountDetails(){
        System.out.println("Account Details printed !!");
    }
}
// Proxy class ( adding security )
class BankAccountProxy implements  BankAccount{
    private  BankAccountService bankAccountService;
    private  String userRole;
    BankAccountProxy(String userRole){
        this.bankAccountService=new BankAccountService();
        this.userRole=userRole;
    }
    @Override
    public void viewAccountDetails() {
        if(userRole.equals("ADMIN")){
            bankAccountService.viewAccountDetails();
        }
        else{
            System.out.println("Access Denied , UnAuthorised User !!");
        }
    }
}

public class Proxy {
    public static  void main(String [] govind){
        BankAccount bankAccount=new BankAccountProxy("ADMIN");
        bankAccount.viewAccountDetails();

        BankAccount bankAccount1=new BankAccountProxy("USER");
        bankAccount1.viewAccountDetails();
    }
}
