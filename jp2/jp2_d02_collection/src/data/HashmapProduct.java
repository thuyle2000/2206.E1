/*
quan ly danh sach san pham trong Hashmap, bao gom cac chuc nang:
    - them sp moi
    - xem ds san pham
    - xoa sp theo ms 
    - tim sp theo ten
    - sap xep ds sp theo don gia/co/ten
 */
package data;

import java.util.*;

public class HashmapProduct {
  
    HashMap<String, Product> ds = new HashMap<>();
    
    //ham them 1 sp moi
    public void insert(){
        Product p = new Product();
        p.input();
        
        if(ds.containsKey(p.id)){
            System.out.println(">> LOI: ma so SP da ton tai !");
        }
        else{
           //luu sp vo hashsmap
           ds.put(p.id, p);
           System.out.println(" >> Them sp thanh cong");
        }
        
    }
    
    //ham in danh sach san pham
    public void display(){
        if(ds.isEmpty()){
            System.out.println(">> HT chua co du lieu !");
            return;
        }
        
        System.out.println("\n === Danh sach san pham ===");
        ds.values().stream().forEach(System.out::println);
    }
    
    //ham xoa san pham theo ma so
    public void delete(String id){
        if(ds.isEmpty()){
            System.out.println(">> HT chua co du lieu !");
            return;
        }
       
        
        if(ds.containsKey(id)){
            ds.remove(id);
            System.out.println(" >> Da xoa sp thanh cong.");
        }
        else{
            System.out.printf(" >> Ko tim thay sp co id =[%s] \n", id);
          
        }
    }
    
    
    //ham tim san pham theo ten
    public void display(String tenSP){
        if(ds.isEmpty()){
            System.out.println(">> HT chua co du lieu !");
            return;
        }
        
        var count = ds.values().stream().filter(x->x.name.toLowerCase().contains(tenSP)).count();
        if(count==0){
            System.out.printf(">> Ko tim thay san pham co ten [%s] \n", tenSP);
        }
        else{
            ds.values().stream().filter(x->x.name.toLowerCase().contains(tenSP)).forEach(System.out::println);
        }
        
    }
    
    
    //ham tim sp theo don gia
    public void display(int donGia){
        if(ds.isEmpty()){
            System.out.println(">> HT chua co du lieu !");
            return;
        }
        
        int cnt=0;
        for (Product item : ds.values()) {
            if(item.price>=donGia){
                System.out.println(item);
                cnt++;
            }
        }
        
        if(cnt==0){
            System.out.println(" >> Ko tim thay sp !");
        }
        
    }
}
