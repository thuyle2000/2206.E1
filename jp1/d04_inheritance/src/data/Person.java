/*
cau truc du lieu mo ta ho so ca nhan, bao gom:
- fields : id, name, yob, gender, email
- methods: input(), output()
 */
package data;

import java.util.Scanner;

public class Person {
   public String id, name, email;
   public int yob;
   public boolean gender;
   
   public void input(){
       Scanner sc = new Scanner(System.in);
       System.out.print("nhap id: ");
       id = sc.nextLine().trim();
       System.out.print("nhap ho ten: ");
       name = sc.nextLine().trim();
       System.out.print("nhap email: ");
       email = sc.nextLine().trim();
       System.out.print("nhap nam sinh: ");
       yob = Integer.parseInt(sc.nextLine().trim());
       System.out.print("nhap gioi tinh (true: nam/false: nu): ");
       gender = sc.nextBoolean();
   }
   
   public void output(){
       System.out.println("Thong tin ca nhan: ");
       System.out.println("id: " + id);
       System.out.println("ten: " + name);
       System.out.println("email: "+ email);
       System.out.println("nam sinh: "+ yob);
       System.out.println("gioi tinh: " + (gender?"nam":"nu"));
   }
}
