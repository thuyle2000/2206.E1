/*
demo copy file 
 */
package demo;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CopyFile {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Nhap ten tap tin muon copy: ");
        String name1 = sc.nextLine().trim();        
        Path source = Paths.get(name1);
        
        if(!Files.exists(source)){
            System.out.printf(">> Loi: tap tin [%s] ko ton tai !\n",name1 );
            return;
        }
        
        String name2 = "copy_"+source.getFileName();       
        Path dest = source.resolveSibling(name2);       
        
        try {
            Files.copy(source, dest);
            System.out.println(">> copy file thanh cong. ");
        } catch (IOException ex) {
            Logger.getLogger(CopyFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
