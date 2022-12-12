/*
 * chuong trinh quan ly cac san pham trong mang (array), bao gom:
    - them sp
    - in danh sach sp
    - tim kiem sp theo ten, ma so, don gia ...
    - xoa san pham theo ma so
 */
package app;
import data.Product;
import java.util.Scanner;

public class ProductArray {
    final int max = 4; // kich thuoc toi da cua mang
    Product[] ds = new Product[max]; //khai bao mang ds[] 
    int next= 0;        // chua vi tri cua pt cuoi trong mang ds[]
    
    //ham them 1 san pham moi vo ds[]
    void insert(){
        //kiem tra mang ds[] co con cho trong hay ko ?
        if(next==max){
            //thong bao loi
            System.out.println(">>> Loi: He thong full roi!");
            return;  //ket thuc ham
        }
        
        //tao 1 doi tuong san pham moi
        Product p = new Product();
        p.input();
        
        //luu san pham moi vo mang ds[]
        ds[next] = p;
        
        //cap nhat lai bien vi tri cuoi cung
        next++;
        
        System.out.println(" >> Them san pham moi thanh cong !");
    }
    
    //ham in danh sach san pham
    void display(){
        //kiem tra mang ds[] co chua du lieu gi chua
        if(next==0){
            System.out.println(" >> HT chua co du lieu !!!");
            return; //ket thuc ham
        }
        
        System.out.println("\n === Danh sach san pham ===");
        for (int i = 0; i < next; i++) {
            System.out.println(ds[i]);
        }
    }
    
    //ham tim san pham theo ten
    void display(String tensp){
        //kiem tra mang ds[] co chua du lieu gi chua
        if(next==0){
            System.out.println(" >> HT chua co du lieu !!!");
            return; //ket thuc ham
        }
        
        int cntName = 0;
        String ten = tensp.trim().toLowerCase();
        for (int i = 0; i < next; i++) {
            if(ds[i].name.toLowerCase().contains(ten)){
                System.out.println(ds[i]);
                cntName++;
            }
        }//ket thuc vong FOR
        
        if(cntName==0){
            System.out.printf(" >> Ko tim thay sp co ten [%s]\n", tensp);
        }
    }
    
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = "";
        ProductArray pa = new ProductArray();
        
        //menu chinh cua chuong trinh
        while(true){
            System.out.println("\n MENU ");
            System.out.println("1. Them san pham ");
            System.out.println("2. In danh sach san pham");
            System.out.println("3. Tim kiem san pham");
            System.out.println("4. Xoa san pham theo ma so");
            System.out.println("5. Ket thuc chuong trinh");
            System.out.println("=========================");
            System.out.print(" >> nhap ma chuc nang [1-5] : ");
            op = sc.nextLine().trim();
            
            switch (op) {
                case "1":
                    pa.insert();
                    break;
                case "2":
                    pa.display();
                    break;
                case "3":
                    System.out.print(" nhap ten sp muon tim: ");
                    pa.display(sc.nextLine().trim());
                    break;
                    
                case "5":
                    return;
                default:
                    System.out.println(" >> Chon sai chuc nang !!!");
            }
        }
    }
}
