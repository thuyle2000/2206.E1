/*
Thread rut tien ATM
 */
package demo;

import java.util.Random;


public class Son implements Runnable{

    public ATM atm;

    public Son() {
    }

    public Son(ATM atm) {
        this.atm = atm;
    }
    
    
    @Override
    public void run() {
        System.out.println("*** Son starts studying ***");
        Random r = new Random();
        int amount =0;
        for (int i = 0; i < 10; i++) {
            amount = r.nextInt(100, 200);
            atm.withdraw(amount);
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }
        
        System.out.println("*** Son stopped studying, starts working ***");
    }
    
}
