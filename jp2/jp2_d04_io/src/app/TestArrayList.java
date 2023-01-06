/*
chuong trinh quan ly ds san pham trong array list
 */
package app;

import data.*;
import java.util.*;

public class TestArrayList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = "";
        ArrayListProduct ap = new ArrayListProduct();


        while (true) {
            System.out.println("\n == MENU ==");
            System.out.println("1. them san pham");
            System.out.println("2. in danh sach san pham");
            System.out.println("3. xoa san pham theo ma so");
            System.out.println("4. tim san pham theo ten");
            System.out.println("5. sap xep ds sp theo don gia/co/ten");
            System.out.println("6. luu file");
            System.out.println("7. ket thuc chuong trinh");
            System.out.println("====================================");
            System.out.print(" >> nhap ma chuc nang [1-7]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1" ->
                    ap.insert();
                case "2" ->
                    ap.display();
                case "3" -> {
                    System.out.print(" nhap ma so: ");
                    ap.delete(sc.nextLine().trim());
                }
                case "4" -> {
                    System.out.print(" nhap ten sp: ");
                    ap.display(sc.nextLine().trim().toLowerCase());
                }
                case "6" -> ap.saveFileText();
                
                case "7" ->{
                    return;
                }
                default ->
                    System.out.println("nhap sai ma chuc nang");
            }
        }

    }

}
