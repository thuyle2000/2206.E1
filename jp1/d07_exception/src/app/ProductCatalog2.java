/*
chuong trinh quan ly danh muc san pham, bao gom cac chuc nang:
1. them san pham moi
2. in ds san pham
3. tim san pham theo ten, 
4. tim san pham theo don gia
5. xoa san pham theo ma so
6. ket thuc
 */
package app;

import data.Product;
import java.util.Scanner;

public class ProductCatalog2 {

    public static void main(String[] args) {
        ProductCatalog2 pc = new ProductCatalog2();
        Scanner sc = new Scanner(System.in);
        String op = "";

        while (true) {
            System.out.println("\n === MENU ===");
            System.out.println(" 1. them san pham");
            System.out.println(" 2. in danh sach sp");
            System.out.println(" 3. tim san pham theo ten");
            System.out.println(" 4. tim san pham theo don gia");
            System.out.println(" 5. xoa san pham theo ma so ");
            System.out.println(" 6. ket thuc chuong trinh");
            System.out.println("==========================");
            System.out.print(" >> nhap ma chuc nang [1-6]: ");

            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    pc.insert();
                    break;
                case "2":
                    pc.display();
                    break;

                case "6":
                    return;
                default:
                    System.out.println(">> Loi: nhap sai chuc nang !");
                    break;
            }

        }
    }

    int max = 10;
    int next = 0;
    data.Product[] ds = new Product[max];

    private void insert() {
        if (next == max) {
            System.out.println(">> LOI: HT het cho luu tru !");
            return;
        }

        Product p = new Product();
        input(p);
        ds[next++] = p;
    }

    //ham nhap du lieu cho 1 san pham [p]
    public void input(Product p) {
        Scanner sc = new Scanner(System.in);

        //khoi lenh dieu khien viec nhap ma so san pham 
        while (true) {
            System.out.print(" - nhap id [2-5 ky tu]: ");
            p.id = sc.nextLine().trim().toUpperCase();
            if (p.id.length() < 2 || p.id.length() > 5) {
                System.out.println(" >> Loi: ID ko hop le !");
                continue;
            }
            
            if(containID(p.id)){
                System.out.println(" >> Loi: ID da ton tai !");
                continue;
            }
            break;
        }

        //khoi lenh dieu khien viec nhap ten san pham 
        while (true) {
            System.out.print(" - nhap ten sp [>2 ky tu]: ");
            p.name = sc.nextLine().trim();
            if (p.name.length() < 2) {
                System.out.println(" >> Loi: Ten SP ko hop le !");
                continue;
            }
            break;
        }

        //khoi lenh dieu khien viec nhap don vi tinh san pham 
        String s = "lon,chai,hop,kg,lit";
        while (true) {
            System.out.print(" - nhap don vi tinh [lon/chai/hop/kg/lit]: ");
            p.unit = sc.nextLine().trim();
            if (!s.contains(p.unit.toLowerCase())) {
                System.out.println(" >> Loi: DVT ko hop le !");
                continue;
            }
            break;
        }

        //khoi lenh dieu khien viec nhap don gia
        while (true) {
            try {
                System.out.print(" - nhap don gia [>=0]:  ");
                p.price = Float.parseFloat(sc.nextLine().trim());
                if (p.price < 0) {
                    throw new NumberFormatException("Don gia ko hop le !");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(" >> Loi: " + e);
            }
        }

    }

    //ham kiem tra chuoi [ms] co ton tai trong cot id cua ds san pham ko ?
    private boolean containID(String ms) {
        for (int i = 0; i < next; i++) {
            if (ds[i].id.equalsIgnoreCase(ms)) {
                return true;
            }
        }
        return false;
    }

    private void display() {
        if (next == 0) {
            System.out.println(">> LOI: HT chua co du lieu !");
            return;
        }

        System.out.println("\n Danh sach san pham");
        for (int i = 0; i < next; i++) {
            System.out.println(ds[i]);
        }
    }

}
