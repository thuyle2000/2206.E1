/*
chuong trinh quan ly ds san pham trong treeset
 */
package app;

import data.*;
import java.util.*;
public class TestTreeset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = "";
        TreeSetProduct ap = new TreeSetProduct();
        
        while(true){
            System.out.println("\n  ==  MENU (treeset) ==");
            System.out.println("1. them san pham");
            System.out.println("2. in danh sach san pham");
            System.out.println("3. xoa san pham theo ma so");
            System.out.println("4. tim san pham theo ten");
            System.out.println("5. sap xep ds sp theo don gia/co/ten");
            System.out.println("6. ket thuc chuong trinh");
            System.out.println("====================================");
            System.out.print(" >> nhap ma chuc nang [1-6]: ");
            op = sc.nextLine().trim();
            
            switch (op) {
                case "1" -> ap.insert();
                case "2" -> ap.display();
                case "3" -> 
                {
                    System.out.print(" nhap ma so: ");
                    ap.delete(sc.nextLine().trim());
                }
                case "4"->
                {
                    System.out.print(" nhap ten sp: ");
                    ap.display(sc.nextLine().trim().toLowerCase());
                }                    
                case "6" -> { return; }
                default -> System.out.println("nhap sai ma chuc nang");
            }
        }
        
    }
    
}
