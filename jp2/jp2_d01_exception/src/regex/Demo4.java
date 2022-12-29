/*   Demo bieu thuc qui tac  */
package regex;

import java.util.regex.*;
import java.util.*;
public class Demo4 {

    public static void main(String[] args) {
        Demo4 p = new Demo4();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("nhap email: ");
        String s = sc.nextLine().trim();
        p.testEmail(s);
    }
    
    //kiem tra dia chi email
    private void testEmail(String s){
        //1. tao chuoi chua luat tim kiem
        String p = "(?i)^[a-z0-9]+[\\w-.]+[a-z0-9]+@[\\w]+(\\.[a-z]{2,3})+$";
     
        //2. kiem tra chuoi [s] co format trung voi mau [p] ?
        if(Pattern.matches(p, s)){
            System.out.printf(">> email hop le.\n", s);
        }
        else{
            System.out.printf(">> email [%s] khong hop le !\n", s);
        } 
    }
}
