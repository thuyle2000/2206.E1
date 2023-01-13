/*
demo hoat dong cua isAlive() va join()
 */
package demo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo1 {

    public static void main(String[] args) {
        Runnable r1 = () -> {
             for (int i = 0; i < 10; i++) {
                System.out.printf("%2d. Hello \n", i+1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    System.out.println("Loi: " + ex.getMessage());
                }
            }
        };
        
         Runnable r2 = () -> {
             for (int i = 0; i < 15; i++) {
                System.out.printf("\t %2d. Goodbye \n", i+1);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException ex) {
                    System.out.println("Loi: " + ex.getMessage());
                }
            }
        };    
         
         
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        
        //kiem tra trang thai alive cua t1 va t2
        System.out.println("\t\t t1.isAlive : " + t1.isAlive());
        System.out.println("\t\t t2.isAlive : " + t2.isAlive());
        
        //start t1, t2
        t1.start();
        t2.start();
        
        //kiem tra trang thai alive cua t1 va t2
        System.out.println("\t\t t1.isAlive : " + t1.isAlive());
        System.out.println("\t\t t2.isAlive : " + t2.isAlive());
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
        
        System.out.println(" *** FINISHED !!! ***");
        
    }
    
}
