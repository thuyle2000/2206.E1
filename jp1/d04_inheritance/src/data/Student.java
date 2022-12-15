/*
Mo ta cau truc du lieu sinh vien, mo rong tu lop Person, 
bo sung them:
- fields : lop hoc va diem thi
- override input() va output()
 */
package data;

import java.util.Scanner;

public class Student extends Person {

    public String batchno;
    public int mark;

    @Override
    public void input() {
        super.input(); // goi ham input() cua lop cha Person

        Scanner sc = new Scanner(System.in);
        System.out.print(" nhap ma lop hoc: ");
        batchno = sc.nextLine().trim();
        System.out.print(" nhap diem ket qua: ");
        mark = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void output() {
        super.output(); // goi ham output() cua lop cha Person
        System.out.println(" ma lop: " + batchno);
        System.out.println(" diem ket qua: " + mark);
    }

    @Override
    public String toString() {
        return String.format("%-5s, %-20s, %-30s, %-4s, %4d, %-15s, %8d", id, name, email, gender ? "nam" : "nu", yob, batchno, mark);
    }

    public static void main(String[] args) {
        Student sv = new Student();
        sv.input();
//        sv.output();
        System.out.println(sv);
    }
}
