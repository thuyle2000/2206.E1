/*
Class Member used to store all details of a member: memberID, name, age, address.
- Define instance variables to present member details with appropriate data type.
- Create constructor to initialize this instance variables.
- Create method void input() to enter data for a member object.
    MemberID must have format ‘Mxxx-xxxx’ , with the last four digits is the current year.
    Age is a numeric from 16 to 61.
    Name is compulsory (contain only letters of alphabeta, space and not null)
- Override method toString() to return a string that present member details.

 */
package pretest_I0_4;

import java.util.*;
import java.util.regex.*;
import java.time.*;

public class Member implements java.io.Serializable{
    public String memberID, name, address;
    public int age;

    public Member() {
        memberID = "M000-2023";
        name = "vo danh";
        address = "ko biet";
        age = 16;
    }
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        
        //vong lap kiem tra nhap ma so
        while(true){
            System.out.print(">> nhap ma so [Mxxx]: ");
            memberID = sc.nextLine().trim();
            if(Pattern.matches("M\\d{3}", memberID)){
                memberID = memberID + "-" +Year.now().getValue();
                break;
            }
            
            System.out.println("  >> Loi: ma so ko hop le ! ");
        }
        
        //vong lap kiem tra ten
        while(true){
            System.out.print(">> nhap ten: ");
            name = sc.nextLine().trim();
            if(Pattern.matches("(?i)[a-z ]+", name)){
                break;
            }
            System.out.println("  >> Loi: ten ko hop le ! ");
        }
        
        //nhap dia chi
        System.out.print(">> nhap dia chi: ");
        address = sc.nextLine().trim();
        
        //vong lap kiem tra nhap tuoi
        while(true){
            try {
                System.out.print(">> nhap tuoi [16-61]: ");
                age = Integer.parseInt(sc.nextLine().trim());
                if(age>=16 && age<=61){
                    break;
                }
                System.out.println("  >> Loi: tuoi ko hop le ! ");
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
            }
        }
        
    }

    @Override
    public String toString() {
        return String.format("%s, %-20s, %3d, %s", memberID, name, age, address);
    }
    
    
    
    //test class Member
    public static void main(String[] args) {
        Member m = new Member();
        m.input();
        System.out.println(m);
    }
    
}
