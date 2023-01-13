/*
chuong trinh in ra:
    - 10 cau thong bao 'Hello' trong thread thu 1
    - 10 so ngau nhien, trong thread so 2
 */
package demo;

import java.util.Random;

public class Demo3 {

    public static void main(String[] args) {
        System.out.println("thread name: " + Thread.currentThread().getName());
        
        //tao doi tuong thread in thong bao
        Thread t1 = new Thread(new RunHello());
        t1.setName("thread-hello");
        
        //tao doi tuong thread in so ngau nhien
        Thread t2 = new Thread(new RunRandom());
        t2.setName("thread-random");
        
        //cho t1 va t2 hoat dong
        t1.start();
        t2.start();
        
        System.out.println(" >> active threads: " + Thread.activeCount() );
    }

}

//dinh nghia thread in thong bao
class RunHello implements Runnable {

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        
        for (int i = 0; i < 10; i++) {
            try {
                System.out.printf("\t %s: Hello \n", name);
                Thread.sleep(1000); // cho ngung 1s
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }
    }

}

//dinh nghia thread in so ngau nhien
class RunRandom implements Runnable{

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.printf("\t\t %s: %3d\n",name, r.nextInt(0, 100) );
            try {
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        } 
    }
    
}
