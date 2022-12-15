/*
Chuong trinh quan ly cac doi tuong hinh hoc, bao gom cac chuc nang:
    1. them hinh tron
    2. them hinh chu nhat
    3. in toan bo cac doi tuong hinh hoc
    4. in cac hinh co dien tich theo yeu cau
    5. in danh sach cac hinh vuong
    6. ket thuc chuong trinh
 */
package app;

import data.*;
import java.util.*;

public class ShapeCatalog {

    public static void main(String[] args) {
        ShapeCatalog p = new ShapeCatalog();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (true) {
            System.out.println("\n === MENU ===");
            System.out.println(" 1. Them hinh chu nhat");
            System.out.println(" 2. Them hinh tron");
            System.out.println(" 3. In danh sach cac hinh hoc");
            System.out.println(" 4. In cac hinh co dien tich theo yeu cau");
            System.out.println(" 5. In cac hinh vuong");
            System.out.println(" 6. ket thuc chuong trinh");
            System.out.println(" =========================");
            System.out.print("  vui long nhap ma chuc nang [1-6]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    p.addRect();
                    break;
                    
                case "2":
                    p.addCir();
                    break;
                    
                case "3":
                    p.display();
                    break;
                    
                case "4":
                    System.out.print(" >> nhap dien tich: ");
                    float dt = Float.parseFloat(sc.nextLine().trim());
                    p.display(dt);
                    break;
                    
                case "6":
                    return;
                default:
                    System.out.println(" >> Nhap sai ma chuc nang");
                    break;
            }
        }

    }

    int max = 10;
    int next = 0;
    Shape[] ds = new Shape[max];

    //ham them 1 hinh chu nhat vo mang ds[]
    private void addRect() {
        if (next == max) {
            System.out.println(">> Loi: HT het cho luu tru !!!");
            return;
        }

        Rectangle r = new Rectangle();
        r.input();
        ds[next++] = r;

    }

    private void addCir() {
        if (next == max) {
            System.out.println(">> Loi: HT het cho luu tru !!!");
            return;
        }

        ds[next] = new Circle();
        ds[next].input();
        next++;
    }

    private void display() {
        if(next==0){
            System.out.println(">> Loi: HT chua co du lieu !");
            return;
        }
        
        System.out.println("\n Danh sach cac doi tuong hinh hoc");
        for (int i = 0; i < next; i++) {
            System.out.println(ds[i]);
        }
        
    }

    private void display(float dt) {
        if(next==0){
            System.out.println(">> Loi: HT chua co du lieu !");
            return;
        }
        
        int cnt=0;
        System.out.println("\n Danh sach cac hinh co dien tich >= "+ dt);
        for (int i = 0; i < next; i++) {
            if(ds[i].area()>=dt){
                System.out.println(ds[i]);
                cnt++;
            }
        }// KET THUC FOR
        
        if(cnt==0){
            System.out.println(">> Ko tim thay !!!");
        }
    }

}
