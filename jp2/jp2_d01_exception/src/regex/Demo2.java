/*   Demo bieu thuc qui tac  */
package regex;

import java.util.regex.*;
import java.util.*;
public class Demo2 {

    public static void main(String[] args) {
        Demo2 p = new Demo2();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("nhap ten: ");
        String s = sc.nextLine().trim();
        p.testName(s);
    }
    
    //kiem tra Ten chi gom cac ky tu chu a-z va khoang trang, it nhat 3 kt
    private void testName(String s){
        //1. tao mau qui tac
        Pattern p = Pattern.compile("[a-z A-Z]{3,}");
        
        //2. khoi tao bo kiem tra mau [p] voi chuoi [s]
        Matcher m = p.matcher(s);
        
        //3. kiem tra chuoi [s] co format trung voi mau [p] ?
        if(m.matches()){
            System.out.printf(">> Ten hop le.\n", s);
        }
        else{
            System.out.printf(">> Ten [%s] khong hop le !\n", s);
        } 
    }
}
