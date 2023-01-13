/*
chuong trinh in ra:
    - 10 cau thong bao 'Hello' trong thread thu 1
    - 10 so ngau nhien, trong thread so 2
 */
package demo;

import java.util.Random;

public class Demo2 {

    public static void main(String[] args) {
        System.out.println("thread name: " + Thread.currentThread().getName());
        //tao doi tuong thread in thong bao
        Thread t1 = new ThreadHello();
        t1.setName("thread-hello");
        
        //tao doi tuong thread in so ngau nhien
        Thread t2 = new ThreadRandom();
        t2.setName("thread-random");
        
        //cho t1 va t2 hoat dong
        t1.start();
        t2.start();
        
        System.out.println(" >> active threads: " + Thread.activeCount() );
        
    }
    
}

//dinh nghia thread thuc hien nhiem vu in ra 10 cau "Hello"
class ThreadHello extends Thread{
    //nhiem vu cua thread duoc lap trinh trong ham run()
    @Override
    public void run() {       
        System.out.println("- thread name: " + getName());
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("\t Hello");                
                Thread.sleep(1000); // cho ngung 1s
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }
    }
}

//dinh nghia thread in ra 10 so ngau nhien
class ThreadRandom extends Thread{

    @Override
    public void run() {
        System.out.println("\t\t- thread name: " + getName());
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.printf("\t\t %3d\n", r.nextInt(0, 100) );
            try {
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }       
    }
}