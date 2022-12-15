/*
Mo ta cau truc du lieu nhan vien, mo rong tu lop Person, 
bo sung them:
- fields : chuc vu va luong co ban
- override input() va output()
 */
package data;

import java.util.Scanner;

public class Employee extends Person {

    public String position;
    public int salary;

    @Override
    public void input() {
        super.input();

        Scanner sc = new Scanner(System.in);
        System.out.print(" nhap chuc vu: ");
        position = sc.nextLine().trim();
        System.out.print(" nhap luong co ban: ");
        salary = Integer.parseInt(sc.nextLine().trim());
    }

    @Override
    public void output() {
        super.output();

        System.out.println(" chuc vu: " + position);
        System.out.println(" luong CB: " + salary);
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format("%-5s, %-20s, %-30s, %-4s, %4d, %-15s, %8d",id,name,email,gender?"nam":"nu", yob, position , salary);
    }

    
    public static void main(String[] args) {
        Employee e = new Employee();
        e.input();
        e.output();
    }

}
