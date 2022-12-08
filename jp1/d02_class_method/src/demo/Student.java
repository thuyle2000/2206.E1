/*
class Student mo ta cau truc Sinh vien, bao gom:
- thuoc tinh: id, ho ten, gioi tinh, nam sinh va ten truong
- phuong thuc xu ly: nhap thong tin, xuat thong tin ca nhan
 */
package demo;

import java.util.Scanner;

public class Student {

    //khai bao cac thuoc tinh (fields)
    public String id, name;
    public boolean gender;
    public int yob;
    public static String schoolName = "FPT Aptech";

    //ham khoi tao (constructor) ko co tham so
    public Student() {
        id = "S00";
        name = "vo danh";
        gender = true;
        yob = 2004;
    }

    // ham khoi tao co tham so
    public Student(String id, String name, boolean gen, int year) {
        this.id = id;
        this.name = name;
        this.gender = gen;
        yob = year;
    }

    //phuong thuc nhap du lieu chi tiet cho 1 sinh vien
    public void input() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap thong tin sinh vien: ");
        System.out.print("- nhap id: ");
        id = sc.nextLine();

        System.out.print("- nhap ho ten: ");
        name = sc.nextLine();

        System.out.print("- nhap gioi tinh (true:nam | false:nu): ");
        gender = sc.nextBoolean();

        System.out.print("- nhap nam sinh: ");
        yob = sc.nextInt();
    }

    //override ham tra ve chuoi mo ta 1 doi tuong sv
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %d, %d",
            id, name, gender ? "nam" : "nu", yob, 2022 - yob);
    }

    //kiem thu ham input
    public static void main(String[] args) {

        //in ra ten truong 
        System.out.printf("\n Truong: %s\n", Student.schoolName);

        //tao 1 bien doi tuong sv, co kieu Student
        Student sv = new Student();     //ham dung ko tham so duoc thi hanh

        //xuat thong tin sinh vien sv, khi chua goi ham nhap lieu
        System.out.println(">> thong tin sinh vien: ");
        System.out.println(sv);

        //nhap thong tin sinh vien, thong qua bien sv
        sv.input();

        //xuat thong tin sinh vien sv sau khi nhap lieu
        System.out.println(">> thong tin sinh vien: ");
        System.out.println(sv);

        //tao bien doi tuong Student sv2
        Student sv2 = new Student("S03", "Minh Thien", true, 2004);
        //xuat thong tin sinh vien sv2 sau khi nhap lieu
        System.out.println(">> thong tin sinh vien: ");
        System.out.println(sv2);

    }
}
