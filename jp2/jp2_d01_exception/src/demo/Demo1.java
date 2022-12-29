/*
 demo cau truc bay loi exception 
 */
package demo;

import java.util.Scanner;

public class Demo1 {

    public static void main(String[] args) {
        Demo1 o = new Demo1();
        try {
            int n = o.input_number();
            System.out.printf(" >> so duoc nhap: %d \n", n);
        } catch (NumberFormatException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private int input_number() throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        System.out.print("vui long nhap 1 so nguyen duong: ");
        int n = sc.nextInt();
        if (n < 0) {
            throw new NumberFormatException("so nhap ko hop le !");
        }
        return n;
    }

}
