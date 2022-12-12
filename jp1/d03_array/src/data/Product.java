/*
class mo ta cau truc san pham.
Moi san pham bao gom: 
- thuoc tinh: id, ten, don gia
- phuong thuc: nhap va xuat thong tin san pham
 */
package data;

import java.util.Scanner;

public class Product {
    public String id, name;
    public int price;
    
    //ham dung ko tham so 
    public Product() {
        id="P01";
        name="coca";
        price=100;
    }
    
    //ham dung co tham so
    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    //ham nhap du lieu cho san pham
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("- nhap id: ");
        id = sc.nextLine().trim();
        
        System.out.print("- nhap ten SP: ");
        name = sc.nextLine().trim();
        
        System.out.print("- nhap don gia: ");
        price = Integer.parseInt(sc.nextLine().trim());  
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", id, name, price);
    }
    
    //doan chuong trinh test doi tuong Product lap trinh on ko
    public static void main(String[] args) {
        Product p = new Product();
        p.input();
        System.out.println(p);
    }

}
