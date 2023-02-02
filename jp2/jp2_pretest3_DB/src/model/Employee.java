/*
mo ta cau truc nhan vien
 */
package model;

import java.util.Scanner;
import java.util.regex.*;
    
public class Employee {
    public int id;
    public String name;
    public boolean gender;
    public int salary;

    public Employee() {
        id = 1;
    }

    public Employee(int id, String name, boolean gender, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }
    
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhap thong tin nhan vien");
        
        //nhap ten NV
        while(true){
            System.out.print(" - nhap ho ten: ");
            name = sc.nextLine().trim();
            if(name.isEmpty()){
                System.out.println(" >> loi: ten ko dc de trong !");
                continue;
            }
            break;
        }
        
        //nhap gioi tinh (male/female)
        String sGender ="";
        while(true){
            System.out.print(" - nhap gioi tinh (male|female): ");
            sGender = sc.nextLine().trim();
            if(Pattern.matches("(?i)male|female", sGender)){
                gender = sGender.equalsIgnoreCase("male");
                break;
            }
            System.out.println(" >> loi: gioi tinh ko hop le !");
        }
        
        //nhap muc luong
        while(true){
            try {
                System.out.print(" - nhap muc luong  [0-10000]: ");
                salary = Integer.parseInt(sc.nextLine().trim());
                if(salary>=0 && salary<=10000){
                    break;
                }
                System.out.println(" >> loi: muc luong ko hop le !");
                
            } catch (Exception e) {
                System.out.println(" >> loi: " + e.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%3d. %-20s %-6s %5d", id, name, gender?"male":"female", salary );
    }
    
    
    //test doi tuong Employee
    public static void main(String[] args) {
        Employee e = new Employee();
        e.input();
        System.out.println(e);
    }
    
    
}
