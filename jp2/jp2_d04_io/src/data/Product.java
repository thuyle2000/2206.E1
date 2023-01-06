/*
mo ta cau truc san pham, bao gom:
- thuoc tinh: 
    id: Pxx[xx]
    name: not null
    price: 0-1000
    co: VN/TL/ML/US
- phuong thuc: input(), toString()
 */
package data;

import java.util.*;
import java.util.regex.*;


//class Product implements [java.io.Serializable] de co the thuc hien chuc nang doc/ghi kieu doi tuong
public class Product implements java.io.Serializable{

    public String id, name, co;
    public int price;

    public Product() {
    }

    public Product(String id, String name, String co, int price) {
        this.id = id;
        this.name = name;
        this.co = co;
        this.price = price;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.print(" nhap id (Pxx[xx]): ");
            id = sc.nextLine().trim();
            if(Pattern.matches("P\\d{2,4}", id)){
                break;
            }
            System.out.println(">> ID ko hop le !");
        }
        
        while(true){
            System.out.print(" nhap ten SP: ");
            name = sc.nextLine().trim();
            if(name.isEmpty()){
                System.out.println(">> Ten ko duoc de trong !");
                continue;
            }
            break;
        }
        
        while(true){
            System.out.print(" nhap CO [vn/tl/ml/us]: ");
            co = sc.nextLine().trim();
            if(Pattern.matches("(?)vn|tl|ml|us", co)){
                break;
            }
            System.out.println(">> co ko hop le !!!");
        }
        
        while(true){
            try {
                System.out.print(" nhap don gia [0-1000]: ");
                price = Integer.parseInt(sc.nextLine().trim());
                if(price>=0 && price<=1000){
                    break;
                }
                System.out.println(">> don gia ko hop le !");
            } catch (Exception e) {
                System.out.println(">> Loi: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d", id, name, co, price);
    }

    @Override
    public boolean equals(Object obj) {
        Product p = (Product) obj;
        return this.id.equals(p.id);
    }

    @Override
    public int hashCode() {
        return 6000;
    }
    
    
 
}
