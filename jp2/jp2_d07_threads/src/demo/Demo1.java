/*
chuong trinh in ra:
- 10 cau thong bao 'Hello'
- 10 so ngau nhien
 */
package demo;

import java.util.Random;


public class Demo1 {

    public static void main(String[] args) {        
        System.out.println("Thread: " + Thread.currentThread().getName());
        System.out.println("Active threads: " + Thread.activeCount());
        
        for (int i = 0; i < 10; i++) {
            System.out.println("\t Hello");
        }
        
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d \n", r.nextInt(0, 100));
        }
    }
    
}
