/*   Demo bieu thuc qui tac  */
package regex;

import java.util.regex.*;
import java.util.*;
public class Demo1 {

    public static void main(String[] args) {
        Demo1 p = new Demo1();
        Scanner sc = new Scanner(System.in);
        
        System.out.print("nhap ma so (Cxxxx[xx]): ");
        String s = sc.nextLine().trim();
        p.testID(s);
    }
    
    //kiem tra ID phai co format "Cxxxx[xx]"
    private void testID(String s){
        //1. tao mau qui tac
//        Pattern p = Pattern.compile("C[0-9]{4,6}");
        Pattern p = Pattern.compile("C\\d{4,6}");
        
        //2. khoi tao bo kiem tra mau [p] voi chuoi [s]
        Matcher m = p.matcher(s);
        
        //3. kiem tra chuoi [s] co format trung voi mau [p] ?
        if(m.matches()){
            System.out.printf(">> Ma so [%s] hop le.\n", s);
        }
        else{
            System.out.printf(">> Ma so [%s] khong hop le !\n", s);
        } 
    }
}
