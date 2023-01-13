/*
Demo Deamon Thread
 */
package demo;

public class Demo4 {

    public static void main(String[] args) {

        Thread t1 = new Thread(new RunMessage());
        Thread t2 = new Thread(new RunMessage("Goodbye", 15,2));
        Thread t3 = new Thread(new RunMessage("cleaning ...", 30,3));
        
        t1.setName("greeing");
        t2.setName("farewell");
        t3.setName("house-keeping");
        
        t3.setDaemon(true);
        
        t1.start();
        t2.start();
        t3.start();
        
    }

}

// dinh nghia thread in thong bao 
class RunMessage implements Runnable {

    private String s;
    private int n;
    private int tab;

    public RunMessage() {
        s = "hello";
        n = 10;
        tab = 1;
    }

    
    public RunMessage(String s, int n, int tab) {
        this.s = s;
        this.n = n;
        this.tab = tab;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < tab; j++) {
                System.out.print("\t");
            }
            
            System.out.printf("%s: %d.%s \n", name, i+1, s);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }
    }

}
