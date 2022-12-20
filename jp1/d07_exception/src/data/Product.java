/*
cau truc san pham, bao gom:
- field: id, ten, don vi tinh, don gia
- methods: input(), output(), toString()
 */
package data;

import java.util.Scanner;

public class Product {

    public String id, name, unit;
    public float price;

    public Product() {
        id = "P01";
        name = "coca cola";
        unit = "lon";
        price = 1.45F;
    }

    public Product(String id, String name, String unit, float price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    //ham nhap du lieu cho 1 san pham
    public void input() {
        Scanner sc = new Scanner(System.in);

        //khoi lenh dieu khien viec nhap ma so san pham 
        while (true) {
            System.out.print(" - nhap id [2-5 ky tu]: ");
            id = sc.nextLine().trim().toUpperCase();
            if (id.length() < 2 || id.length() > 5) {
                System.out.println(" >> Loi: ID ko hop le !");
                continue;
            }
            break;
        }

        //khoi lenh dieu khien viec nhap ten san pham 
        while (true) {
            System.out.print(" - nhap ten sp [>2 ky tu]: ");
            name = sc.nextLine().trim();
            if (name.length() < 2) {
                System.out.println(" >> Loi: Ten SP ko hop le !");
                continue;
            }
            break;
        }

        //khoi lenh dieu khien viec nhap don vi tinh san pham 
        String s = "lon,chai,hop,kg,lit";
        while (true) {
            System.out.print(" - nhap don vi tinh [lon/chai/hop/kg/lit]: ");
            unit = sc.nextLine().trim();
            if (!s.contains(unit.toLowerCase())) {
                System.out.println(" >> Loi: DVT ko hop le !");
                continue;
            }
            break;
        }

        //khoi lenh dieu khien viec nhap don gia
        while (true) {
            try {
                System.out.print(" - nhap don gia [>=0]:  ");
                price = Float.parseFloat(sc.nextLine().trim());
                if (price < 0) {
                    throw new NumberFormatException("Don gia ko hop le !");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(" >> Loi: "+ e);
            }
        }

    }

    //ham (phuong thuc) xuat thong tin chi tiet cua san pham
    public void output() {
        System.out.println("\n Thong tin san pham");
        System.out.printf(" - id: %s \n", id);
        System.out.printf(" - ten: %s \n", name);
        System.out.printf(" - dvt: %s \n", unit);
        System.out.printf(" - gia: %.2f \n", price);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %.2f", id, name, unit, price);
    }

    //test thu doi tuong san pham
    public static void main(String[] args) {
        Product p = new Product();

        p.input();
        p.output();
        System.out.println(p);
    }

}
