/*
 demo cau truc bay loi exception 
 */
package demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Demo4 {

    public static void main(String[] args) {
        Demo4 o = new Demo4();
        try {
            int n = o.input_number();
            System.out.printf(" >> so duoc nhap: %d \n", n);
        } catch (InputMismatchException | MyException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private int input_number() throws MyException {
        Scanner sc = new Scanner(System.in);
        System.out.print("vui long nhap 1 so nguyen duong: ");
        int n = sc.nextInt();
        if (n < 0) {
            throw new MyException("so nhap ko hop le !");
        }
        return n;
    }

}
