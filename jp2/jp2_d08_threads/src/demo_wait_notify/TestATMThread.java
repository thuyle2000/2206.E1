/*
demo wait-notify
 */
package demo_wait_notify;

public class TestATMThread {

    public static void main(String[] args) {
        ATM atm = new ATM();
        
        Thread daddy = new Thread(new Papa(atm));
        Thread boy = new Thread(new Son(atm));
        
        System.out.println("DEMO Wait-Notify MultiThread");
        
        daddy.start();
        boy.start();
        
    }
    
}
