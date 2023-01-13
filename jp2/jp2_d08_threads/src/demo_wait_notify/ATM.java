/*
ATM Account
 */
package demo;

public class ATM {

    public int balance;

    public synchronized void deposit(int amt) {
        System.out.printf(" >> Deposit: %d \n", amt);
        balance += amt;
        System.out.printf(" >> Balance after deposit: %d \n", balance);
        notify();
    }

    public synchronized void withdraw(int amt) {
        while (true) {
            System.out.printf("\t >> Withdraw: %d \n", amt);
            if (amt < balance) {
                balance -= amt;
                System.out.printf("\t >> Balance after withraw: %d \n", balance);
                break;
            }
            System.out.println("\t >> Wait for money comming ...");
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(">> loi: " + ex.getMessage());
            }
        }
    }
}
