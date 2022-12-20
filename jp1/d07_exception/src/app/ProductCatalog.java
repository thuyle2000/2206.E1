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

public class ProductCatalog {

    public static void main(String[] args) {
        ProductCatalog pc = new ProductCatalog();
        Scanner sc = new Scanner(System.in);
        String op="";
     
        while(true){
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
        if(next==max){
            System.out.println(">> LOI: HT het cho luu tru !");
            return;
        }
        
        Product p = new Product();
        p.input();
        ds[next++] = p;
    }

    private void display() {
        if(next==0){
            System.out.println(">> LOI: HT chua co du lieu !");
            return;
        }
        
        System.out.println("\n Danh sach san pham");
        for (int i = 0; i < next; i++) {
            System.out.println(ds[i]);
        }
    }
    
}
