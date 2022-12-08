/*
chuong trinh demo ve lap trinh phuong thuc 
 */
package demo;

import java.util.Scanner;

public class DemoMethod {

    public static void main(String[] args) {
        DemoMethod p = new DemoMethod();

        System.out.println(" *** factorial() *** ");
        p.factorial();

        System.out.println(" *** factorial(5) *** ");
        System.out.printf(" 5! = %.0f \n", p.factorial(5));

        int n = 5;
        System.out.println(" *** n=5, factorial(n) *** ");
        System.out.printf(" %d! = %.0f \n", n, p.factorial(n));

        System.out.println(" *** n=5, factorial(n+1) *** ");
        System.out.printf(" %d! = %.0f \n", n + 1, p.factorial(n + 1));

        //tinh tong cua 3 so 19, 7, 40
        p.addNumbers(19, 7, 40);

        //tinh tong cua 5 so 9, 23, 40, 5, 3
        p.addNumbers(9, 23, 40, 5, 3);

    }

    //ham (phuong thuc) tinh giai thua cua so nguyen N
    void factorial() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" - nhap 1 so nguyen duong bat ky <=20 : ");
        int n = sc.nextInt();

        double r = 1;
        for (int i = 2; i <= n; i++) {
            r *= i;
        }
        System.out.printf(" %d! = %.0f \n", n, r);
    }

    //ham (phuong thuc) tinh giai thua cua so nguyen N
    double factorial(int n) {
        double r = 1;
        for (int i = 2; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    //ham tinh tong cua cac so nguyen 
    void addNumbers(int... a) {
        int sum = 0;
        for (int n : a) {
            System.out.printf(" %d + ", n);
            sum += n;
        }
        System.out.printf(" = %d \n", sum);
    }
}
