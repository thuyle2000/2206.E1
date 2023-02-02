/*

 */
package app;

import java.util.ArrayList;
import java.util.Scanner;
import model.Employee;
import model.EmployeeDAO;

/**
 *
 * @author THUYLM
 */
public class TestEmployee {

    public static void main(String[] args) {
        TestEmployee t = new TestEmployee();
        t.menu();
    }

    private void menu() {
        String op = "";
        Scanner sc = new Scanner(System.in);

        //xay dung menu
        while (true) {
            System.out.println("\n  === MENU === ");
            System.out.println("1. xem ds nhan vien");
            System.out.println("2. them nhan vien moi");
            System.out.println("3. xem ds nhan vien co muc luong tren 300");
            System.out.println("4. xoa nhan vien theo ma so");
            System.out.println("5. ket thuc chuong trinh");
            System.out.println("=========================");
            System.out.print(" nhap ma so chuc nang [1-5]: ");
            op = sc.nextLine().trim();

            switch (op) {
                case "1" -> {
                    display();
                }
                case "2" -> {
                    System.out.println("them nhan vien moi");
                    insert();
                }
                case "3" -> {
                    System.out.println("xem ds nhan vien co muc luong tren 300");
                    display300();
                }
                case "4" -> {
                    System.out.println("xoa nhan vien theo ma so");
                    System.out.print(" - nhap ma so NV: ");
                    delete(Integer.parseInt(sc.nextLine().trim()));
                }
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
        ArrayList<Employee> ds = EmployeeDAO.get();
        if (ds == null) {
            System.out.println("\n >> He thong chua co du lieu ");
            return;
        }

        System.out.println("\n Danh sach cac nhan vien");
        ds.stream().forEach(System.out::println);
    }

    private void insert() {
        Employee b = new Employee();
        System.out.println("\n >> nhap thong tin nhan vien moi: ");
        b.input();

        if (EmployeeDAO.insert(b) > 0) {
            System.out.println(" >> Them nhan vien moi thanh cong !");
        } else {
            System.out.println(" >> Them nhan vien moi that bai !");
        }
    }

    private void delete(int ms) {
        if (EmployeeDAO.delete(ms) > 0) {
            System.out.println(" >> Da xoa nhan vien thanh cong !");
        } else {
            System.out.println(" >> Loi: Xoa nhan vien that bai !");
        }
    }

    private void display300() {
        ArrayList<Employee> ds = EmployeeDAO.get();
        if (ds == null) {
            System.out.println("\n >> He thong chua co du lieu ");
            return;
        }

        var cnt = ds.stream().filter(x->x.salary>=300).count();
        if (cnt == 0){
            System.out.println(" >> ko tim thay !!!");
            return;
        }
        
        System.out.println("\n Danh sach cac nhan vien co muc luong tren 300");
        ds.stream().filter(x->x.salary>=300).forEach(System.out::println);
    }

}
