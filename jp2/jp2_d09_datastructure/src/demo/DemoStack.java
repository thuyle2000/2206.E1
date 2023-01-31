/*
minh hoa cau truc Stack
 */
package demo;

import java.util.*;
public class DemoStack {

    public static void main(String[] args) {
        Stack<String> st = new Stack<>();
        
        String[] names = {"Dong", "Tay", "Nam", "Bac"};
        
        for (String item : names) {
            st.push(item);
        }
        
        System.out.print("\n Danh sach [names]: ");
        for (String n : names) {
            System.out.printf("%s, ", n );
        }

        System.out.print("\n Danh sach [st]: ");
        for (String n : st) {
            System.out.printf("%s, ", n );
        }        
        
        System.out.print("\n Lay du lieu trong danh sach [st]: ");
        int size = st.size();
        for (int i = 0; i < size; i++) {
            String s = st.pop();
            System.out.printf("%s, ", s);
        }
        
        System.out.println("\n Kich thuoc [st]: " + st.size());
    }
    
}
