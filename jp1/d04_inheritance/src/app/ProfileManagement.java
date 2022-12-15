/*
chuong trinh quan ly ho so ca nhan cua cac sinh vien va nhan vien, bao gom chuc nang:
- them sinh vien
- them nhan vien
- in tat ca cac ho so ca nhan

 */
package app;

import data.*;
import java.util.*;

public class ProfileManagement {

    private int max = 10;
    private int next = 0;
    private Person[] ds = new Person[max];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = "";
        ProfileManagement pm = new ProfileManagement();

        while (true) {
            System.out.println(" === MENU ===");
            System.out.println("1. them sinh vien ");
            System.out.println("2. them nhan vien ");
            System.out.println("3. in ho so ca nhan ");
            System.out.println("4. in ho so nhan vien ");
            System.out.println("5. ket thuc");
            System.out.println("====================");
            System.out.print(" nhap ma so chuc nang [1-5]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1":
                    pm.addStudent();
                    break;
                case "2":
                    pm.addEmployee();
                    break;
                case "3":
                    pm.display();
                    break;
                case "4":
                    pm.displayEmployee();
                    break;
                case "5":
                    return;

                default:
                    System.out.println(" >> Sai ma chuc nang !!!");
                    ;
            }
        }
    }

    private void addStudent() {
        if (next == max) {
            System.out.println(">> HT het cho luu tru! tu choi them moi !");
            return;
        }
        Person p = new Student();
        p.input();

        ds[next++] = p;
    }

    private void addEmployee() {
        if (next == max) {
            System.out.println(">> HT het cho luu tru! tu choi them moi !");
            return;
        }
        Person p = new Employee();
        p.input();

        ds[next++] = p;
    }

    private void display() {
        if (next == 0) {
            System.out.println(">> HT chua co du lieu !!!");
            return;
        }

        for (int i = 0; i < next; i++) {
//            ds[i].output();
            System.out.println(ds[i]);
        }
    }

    private void displayEmployee() {
        if (next == 0) {
            System.out.println(">> HT chua co du lieu !!!");
            return;
        }
        int cntEmp = 0;
        for (int i = 0; i < next; i++) {
            if (ds[i] instanceof data.Employee) {
//                ds[i].output();
                System.out.println(ds[i]);
                cntEmp++;
            }
        }//ket thuc vong FOR

        if (cntEmp == 0) {
            System.out.println(">> Khong co ho so nhan vien trong he thong !!!");
        }
    }
}
