/*   Demo bieu thuc qui tac  */
package regex;

import java.util.regex.*;
import java.util.*;
public class Demo3 {

    public static void main(String[] args) {
        Demo3 p = new Demo3();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("nhap ma thanh pho [sg/hn/hu/dn]: ");
        String s = sc.nextLine().trim();
        p.testCity(s);
    }
    
    //kiem tra ten TP lon : SG, HU, HN, DN
    private void testCity(String s){
        //1. tao chuoi chua luat tim kiem
        String p = "(?i)sg|hn|hu|dn";
     
        //3. kiem tra chuoi [s] co format trung voi mau [p] ?
        if(Pattern.matches(p, s)){
            System.out.printf(">> Ten TP hop le.\n", s);
        }
        else{
            System.out.printf(">> Ten TP [%s] khong hop le !\n", s);
        } 
    }
}
