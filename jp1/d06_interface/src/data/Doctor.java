/*
Cau truc du lieu Bac si, mo rong cautruc Person, va bo sung them:
- field: chuyen khoa, so nam kinh nghiem, luong cb, so ngay lam viec
- override ham input()
 */
package data;

import java.util.Scanner;

public class Doctor extends Person implements IPayable {

    public String specialist;
    public int ex_years;

    public int baseSalary;
    public int workedDays;

    public Doctor() {
        super();
        specialist = "khoa nhi";
        ex_years = 5;
        baseSalary = 2000;
        workedDays = 24;
    }

    public Doctor(String specialist, int ex_years, String id, String name, boolean gender, int yob, int base, int days) {
        super(id, name, gender, yob);
        this.specialist = specialist;
        this.ex_years = ex_years;
        this.baseSalary = base;
        this.workedDays = days;
    }

    @Override
    public void input() {
        super.input(); // goi ham input() cua lop cha Person

        Scanner sc = new Scanner(System.in);
        System.out.print("- nhap chuyen khoa: ");
        specialist = sc.nextLine().trim();

        System.out.print("- nhap so nam kinh nghiem: ");
        ex_years = Integer.parseInt(sc.nextLine().trim());

        System.out.print("- nhap luong co ban: ");
        baseSalary = Integer.parseInt(sc.nextLine().trim());

        System.out.print("- nhap so ngay lam viec / thang: ");
        workedDays = Integer.parseInt(sc.nextLine().trim());

    }

    @Override
    public String toString() {
        return super.toString() + String.format(", %s, %d", specialist, ex_years);
    }

    public void output() {
        System.out.println(" Bang luong ");
        System.out.println(" - id: " + id);
        System.out.println(" - ho ten: " + name);
        System.out.println(" - gioi tinh: " + (gender ? "nam" : "nu"));
        System.out.println(" - chuyen khoa: " + specialist);
        System.out.println(" - luong cb: " + specialist);
        System.out.println(" - so nam kinh nghiem: " + ex_years);
        System.out.println(" - so ngay lam viec: " + workedDays);
        System.out.println(" ===========================");
        System.out.printf("  - luong thang: %.2f \n", getSalary());
        System.out.printf("  - phu cap: %.2f \n", getAllowance());
        System.out.printf(" -> thu nhap : %.2f \n", getSalary() + getAllowance());
    }

    @Override
    public float getSalary() {
        float f = 0;
        if (workedDays <= 22) {
            f = (baseSalary / 22) * workedDays;
        } else {
            f = baseSalary + (workedDays - 22) * OT * (baseSalary / 22);
        }

        return f;
    }

    @Override
    public float getAllowance() {
        return (ex_years >= 5) ? 1000 : 500;
    }

    public static void main(String[] args) {
        Doctor d = new Doctor();
        d.input();
        
        d.output();
    }
}
