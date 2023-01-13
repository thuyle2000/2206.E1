/*  Thread nap tien vo ATM  */
package demo;

import java.util.Random;

public class Papa implements Runnable {

    public ATM atm;

    public Papa() {
    }

    public Papa(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void run() {
        System.out.println("*** Papa starts working ***");
        Random r = new Random();
        int amount = 0;
        for (int i = 0; i < 12; i++) {
            amount = r.nextInt(100, 200);
            atm.deposit(amount);

            try {
                Thread.sleep(700);
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }

        System.out.println("*** Papa stopped working ***");
    }

}
