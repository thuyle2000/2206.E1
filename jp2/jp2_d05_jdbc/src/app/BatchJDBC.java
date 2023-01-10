/*
chuong trinh quan ly danh sach cac lop hoc trong CSDL [sem2-demo]
 */
package app;

import model.*;
import java.util.*;

public class BatchJDBC {

    public static void main(String[] args) {
        BatchJDBC p = new BatchJDBC();
        p.menu();
    }

    private void menu() {
        String op = "";
        Scanner sc = new Scanner(System.in);

        //xay dung menu
        while (true) {
            System.out.println("\n  === MENU === ");
            System.out.println("1. xem ds cac lop hoc");
            System.out.println("2. them lop hoc moi");
            System.out.println("3. doi hoc phi cua 1 lop hoc");
            System.out.println("4. xoa lop hoc theo ma so");
            System.out.println("5. ket thuc chuong trinh");
            System.out.println("=========================");
            System.out.print(" nhap ma so chuc nang [1-5]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1" -> {
                    display();
                }
                case "2" ->
                    insert();
                case "3" ->
                    updateFee();
                case "4" ->
                    delete();
                case "5" -> {
                    return;
                }
                default -> {
                    System.out.println(" nhap sai ma chuc nang !!!");;
                }
            }
        }
    }

    private void display() {
        ArrayList<Batch> ds = BatchDAO.get();
        if (ds == null) {
            System.out.println("\n >> He thong chua co du lieu ");
            return;
        }

        System.out.println("\n Danh sach cac lop hoc");
        ds.stream().forEach(System.out::println);
    }

    private void insert() {
        Batch b = new Batch();
        System.out.println("\n >> nhap thong tin lop hoc moi: ");
        b.input();

        if (BatchDAO.insert(b) > 0) {
            System.out.println(" >> Them lop hoc moi thanh cong !");
        } else {
            System.out.println(" >> Them lop hoc moi that bai !");
        }
    }

    private void updateFee() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n >> nhap ma lop hoc : ");
        String id = sc.nextLine().trim();

        Batch b = BatchDAO.get(id);
        //kiem tra lop hoc voi ma so [id] co ton tai trong DB
        if (b == null) {
            System.out.printf(" >> Loi: lop hoc co ma so [%s] ko ton tai trong he thong !\n", id);
        } else {
            System.out.print(" >> nhap hoc phi moi: ");
            b.fee = Integer.parseInt(sc.nextLine().trim());
            if (BatchDAO.update(id, b) > 0) {
                System.out.println(" >> Thay doi hoc phi moi thanh cong !");
            } else {
                System.out.println(" >> Loi: thay doi hoc phi that bai !");
            }
        }
    }

    private void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n >> nhap ma lop hoc : ");
        String id = sc.nextLine().trim();
        
        if(BatchDAO.delete(id)>0){
            System.out.println(" >> Da xoa lop hoc thanh cong !");
        }
        else{
            System.out.println(" >> Loi: Xoa lop hoc that bai !");
        }
    }

}
