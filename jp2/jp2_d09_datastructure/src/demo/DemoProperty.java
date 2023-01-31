/*
minh hoa cau truc du lieu Properties
 */
package demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DemoProperty {

    public static void main(String[] args) {
//        test1();
        test2();
    }
    
    private static String fname = "data.properties";  
    private static void test1(){
        Properties p = new Properties();
        String[] names = {"Xuan", "Ha", "Thu", "Dong"};
        
        //fill du lieu vo properties p
        for (int i = 0; i < names.length; i++) {
            p.put( (i+1)+"" , names[i]);
        }
        
        //doc du lieu cua properties p
        System.out.println("Danh sach p: ");
        for (Object o : p.keySet()) {
            System.out.printf("%s - %s \n", o, p.get(o));
        }
        
        try (PrintWriter pw = new PrintWriter(fname)){
            //luu du lieu cua properties vo tap tin
            p.store(pw, "du lieu mau");
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DemoProperty.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DemoProperty.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    
    private static void test2(){
        File f = new File(fname);
        if(f.exists()){
            //doc du lieu tu tap tin vo cau truc properties p
            Properties p = new Properties();

            try ( FileReader fr = new FileReader(f)){
                p.load(fr);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DemoProperty.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DemoProperty.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //xuat du lieu trong properties [p] len man hinh
            for (Object key : p.keySet()) {
                System.out.printf("%s - %s \n", key, p.get(key));
            }

        }
    }
}
