/*
cau truc lop hoc, bao gom 
cac thuoc tinh: ma lop, chuong trinh hoc, hoc phi
phuong thuc: input()
 */
package model;

import java.util.Scanner;
import java.util.regex.*;

public class Batch {
    public String batchno, description;
    public int fee;

    public Batch() {
    }

    public Batch(String batchno, String description, int fee) {
        this.batchno = batchno;
        this.description = description;
        this.fee = fee;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.print("nhap ma lop (4 so bat ky): ");
            batchno = sc.nextLine().trim();
            
            if(Pattern.matches("\\d{4}", batchno)){
                break;
            }
            System.out.println(" >> loi: ma lop ko hop le !");
        }
        
         while(true){
            System.out.print("nhap chuong trinh hoc( <=20 ky tu): ");
            description = sc.nextLine().trim();
            
            if(description.length()<=20){
                break;
            }
            System.out.println(" >> loi: chuong trinh hoc ko hop le !");
        }       
        
        while(true){
            try {
                System.out.print("nhap hoc phi (>0) :");
                fee = Integer.parseInt(sc.nextLine().trim());
                if(fee>0){
                    break;
                }
                System.out.println(" >> loi: hoc phi ko hop le !");
            } catch (Exception e) {
                System.out.println(" >> loi: "+ e.getMessage());
            }
        } 
    }

    @Override
    public String toString() {
        return String.format(" %-5s %-22s %7d", batchno, description, fee );
    }
    
    
}
