/*
quan ly danh sach san pham trong ArrayList, bao gom cac chuc nang:
    - them sp moi
    - xem ds san pham
    - xoa sp theo ms 
    - tim sp theo ten
    - sap xep ds sp theo don gia/co/ten
    - ghi ds san pham vo tap tin van ban: [sanpham.txt],
      moi san pham ghi tren 1 dong.
 */
package data;

import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayListProduct {
    ArrayList<Product> ds = new ArrayList<>();

    public ArrayListProduct() {
        //doc file sanpham.txt, neu co, de khoi tao du lieu cho bien [ds]
        readFileText();
    }
    
        
    //ham them 1 sp moi
    public void insert(){
        Product p = new Product();
        p.input();
        
        //luu vo cuoi arraylist [ds]
        ds.add(p);
    }
    
    //ham in danh sach san pham
    public void display(){
        if(ds.isEmpty()){
            System.out.println(">> HT chua co du lieu !");
            return;
        }
        
        System.out.println("\n === Danh sach san pham ===");
        ds.stream().forEach(System.out::println);
    }
    
    //ham xoa san pham theo ma so
    public void delete(String id){
        if(ds.isEmpty()){
            System.out.println(">> HT chua co du lieu !");
            return;
        }
        
        var p = ds.stream().filter(x->x.id.equals(id)).findFirst();
        
        if(p.isEmpty()){
            System.out.printf(" >> Ko tim thay sp co id =[%s] \n", id);
        }
        else{
            ds.remove(p.get());
            System.out.println(" >> Da xoa sp thanh cong.");
        }
    }
    
    
    //ham tim san pham theo ten
    public void display(String tenSP){
        if(ds.isEmpty()){
            System.out.println(">> HT chua co du lieu !");
            return;
        }
        
        var count = ds.stream().filter(x->x.name.toLowerCase().contains(tenSP)).count();
        if(count==0){
            System.out.printf(">> Ko tim thay san pham co ten [%s] \n", tenSP);
        }
        else{
            ds.stream().filter(x->x.name.toLowerCase().contains(tenSP)).forEach(System.out::println);
        }
        
    }
    
    
    //ham tim sp theo don gia
    public void display(int donGia){
        if(ds.isEmpty()){
            System.out.println(">> HT chua co du lieu !");
            return;
        }
        
        int cnt=0;
        for (Product item : ds) {
            if(item.price>=donGia){
                System.out.println(item);
                cnt++;
            }
        }
        
        if(cnt==0){
            System.out.println(" >> Ko tim thay sp !");
        }
        
    }
    
    
    //ham ghi ds san pham vo tap tin [sanpham.txt]
    String fname = "sanpham.txt";
    public void saveFileText(){
        if(ds.isEmpty()){
            return;
        }
        
        try {
            //1. open file de luu ds
            PrintWriter pw = new PrintWriter(fname);
            
            //2. duyet ds va luu vo file
            ds.stream().forEach(x->pw.println(x));
            
            //3. dong file
            pw.close();
            
            //4. thong bao thanh cong
            System.out.println(" >> da luu file thanh cong !");
            
            //5. mo file [sanpham.txt] trong notepad de xem
            Runtime r = Runtime.getRuntime();
            r.exec("notepad   "+ fname);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Loi: " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(ArrayListProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    //ham doc file [sanpham.txt] -> arraylist [ds]
    public void readFileText(){
        File f = new File(fname);
        if(f.exists()==false){
            return;
        }
        
        ds = new ArrayList<>();
        try {
            //1. open file [sanpham.txt] de doc
            BufferedReader br = new BufferedReader(new FileReader(f));
            
            //2. doc tung dong van ban trong tap tin cho den het du lieu
            String line="";
            String[] a = null;
            Product p = null;
            
            while(br.ready()){
                line = br.readLine();   //doc 1 dong
                a = line.split(",");    //tach chuoi tren dong vua doc, dua vao ky tu phan cach [,]
                if(a.length==4){
                    p = new Product(a[0].trim(), a[1].trim(), a[2].trim(), Integer.parseInt(a[3].trim()));
                    ds.add(p);
                }
            }
            
            //4. dong file
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArrayListProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArrayListProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
