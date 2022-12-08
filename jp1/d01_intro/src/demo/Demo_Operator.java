/*
chuong trinh java demo ve cac phep toan
 */
package demo;

import java.util.Scanner;

public class Demo_Operator {

    public static void main(String[] args) {
        System.out.println("Chuong trinh minh hoa cac phep toan");

        Scanner sc = new Scanner(System.in);
        System.out.print("nhap so nguyen thu 1: ");
        int a = sc.nextInt();
        System.out.print("nhap so nguyen thu 2: ");
        int b = sc.nextInt();

        System.out.println("* cac phep toan so hoc *");
        System.out.printf("\t %d + %d = %d \n", a, b, a + b);
        System.out.printf("\t %d - %d = %d \n", a, b, a - b);
        System.out.printf("\t %d * %d = %d \n", a, b, a * b);
        System.out.printf("\t %d / %d = %d \n", a, b, a / b);
        System.out.printf("\t %d %% %d = %d \n", a, b, a % b);

    }
}
