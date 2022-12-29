/*
demo cau truc bay loi try-with-resources
*/
package demo;

import java.io.*;

public class Demo3 {

    public static void main(String[] args) {
        Demo3 o = new Demo3();
        o.readFile();
    }

    String fname = "F:\\que-huong Do Trung Quan.txt";

    void readFile() {

        //1.open file
        try ( BufferedReader r = new BufferedReader(new FileReader(fname)) ){
            //2.read all lines and print out 
            r.lines().forEach(System.out::println);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } 
    }

}
