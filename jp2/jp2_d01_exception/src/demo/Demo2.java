/*
demo cau truc bay loi try-catch-finally
 */
package demo;

import java.io.*;

public class Demo2 {

    public static void main(String[] args) {
        Demo2 o = new Demo2();
        o.readFile();
    }

    String fname = "F:\\que-huong Do Trung Quan.txt";

    void readFile() {

        BufferedReader r=null;

        try {
            //1. open file 
            r = new BufferedReader(new FileReader(fname));
            //2.read all lines and print out 
            r.lines().forEach(System.out::println);
        } catch (FileNotFoundException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } finally {
            try {
                //3.close file
                if(r!=null){
                    r.close();
                }
            } catch (IOException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }

    }

}
