/*
chuong trinh quan ly danh sach bac si, bao gom cac chuc nang:
    1. them bac si
    2. in danh sach bac si
    3. tim bac si theo chuyen khoa
    4. tim bac si theo so nam kinh nghiem
    5. tim bac si theo ma so va ra in bang luong
    6. xoa bac si theo ma so
    7. ket thuc chuong trinh
 */
package app;

import java.util.Scanner;
import data.*;

public class DoctorControlPanel {

    public static void main(String[] args) {
        DoctorControlPanel dc = new DoctorControlPanel();
        Scanner sc = new Scanner(System.in);
        String op = "";
        while (true) {
            System.out.println("\n == MENU ==");
            System.out.println("1. them bac si");
            System.out.println("2. in danh sach bac si");
            System.out.println("3. tim bs theo chuyen khoa");
            System.out.println("4. tim bs theo so nam kinh nghiem");
            System.out.println("5. tim bs theo id va in ra bang luong");
            System.out.println("6. xoa bs theo id");
            System.out.println("7. ket thuc chuong trinh");
            System.out.println("=========================");
            System.out.print(" nhap ma so chuc nang [1-7]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    dc.add();
                    break;
                case "2":
                    dc.display();
                    break;
                case "3":
                    System.out.print(" >> nhap chuyen khoa: ");
                    String ck = sc.nextLine().trim();
                    dc.display(ck);
                    break;

                case "4":
                    System.out.print(" >> nhap so nam kinh nghiem: ");
                    int kn = Integer.parseInt(sc.nextLine().trim());
                    dc.display(kn);
                    break;

                case "5":
                    System.out.print(" >> nhap id: ");
                    dc.displaySalary(sc.nextLine().trim());
                    break;
                    
                case "6":
                    System.out.print(" >> nhap id: ");
                    dc.remove(sc.nextLine().trim());
                    break;

                case "7":
                    return;
                default:
                    System.out.println(">> Loi: nhap sai ma chuc nang!");
            }

        }
    }

    int max = 10;
    int next = 0;
    Doctor[] ds = new Doctor[max];

    private void add() {
        if (next == max) {
            System.out.println(" >> Loi: HT het cho luu tru !!!");
            return;
        }
        Doctor d = new Doctor();
        d.input();

        ds[next++] = d;
    }

    private void display() {
        if (next == 0) {
            System.out.println(" >> HT chua co du lieu !!! \n");
            return;
        }
        System.out.println("\n Danh sach bac si");
        for (int i = 0; i < next; i++) {
            System.out.println(ds[i]);
        }
    }

    private void display(String ck) {
        if (next == 0) {
            System.out.println(" >> HT chua co du lieu !!! \n");
            return;
        }
        System.out.printf("\n Danh sach BS theo chuyen khoa [%s]\n", ck);
        // cac em viet tiep
    }

    private void display(int kn) {
        if (next == 0) {
            System.out.println(" >> HT chua co du lieu !!! \n");
            return;
        }
        System.out.printf("\n Danh sach BS tren [%d] nam kn \n", kn);
        //cac em viet tiep

    }

    private void displaySalary(String ms) {
        if (next == 0) {
            System.out.println(" >> HT chua co du lieu !!! \n");
            return;
        }
        for (int i = 0; i < next; i++) {
            if (ds[i].id.equals(ms)) {
                ds[i].output();
                return;
            }
        }

        System.out.println(" >>> Ko tim thay !!!");
    }

    private void remove(String trim) {
        if (next == 0) {
            System.out.println(" >> HT chua co du lieu !!! \n");
            return;
        }
        
        //cac em viet tiep
    }
}
