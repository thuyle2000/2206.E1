/*  Lop hinh tron la lop con cua lop Shape. 
    - khai bao them bien chua ban kinh
    - Override cac phuong thuc truu tuong cua lop cha
 */
package data;

import java.util.Scanner;
public class Circle extends Shape{
    public float radius;
    
    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double peripheral() {
        return 2*Math.PI*radius;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" nhap ban kinh hinh tron: ");
        radius = Float.parseFloat(sc.nextLine().trim());
    }   

    @Override
    public String toString() {
        return "Hinh tron - "+ super.toString(); 
    }
    
    
}
