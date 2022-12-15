/*
Lop hinh chu nhat la lop con cua lop Shape. 
- khai bao them cac bien chua chieu rong va cao
- Override cac phuong thuc truu tuong cua lop cha
 */
package data;

import java.util.Scanner;

public class Rectangle extends Shape {

    public float width, height;

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double peripheral() {
        return (width + height) * 2;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap chieu cao HCN: ");
        height = Float.parseFloat(sc.nextLine().trim());
        System.out.print("nhap chieu rong HCN: ");
        width = Float.parseFloat(sc.nextLine().trim());
    }

    @Override
    public String toString() {
        String s = (height==width)?"Hinh vuong - ":"Hinh chu nhat - ";
        return s+super.toString(); 
    }
    
    
}
