/*
Class Test is a main class.
In the main class, an instance of the class MemberCatalog is created.
The application initially displays a menu with the following options.
    1. Register a new member
    2. Publish the entire list of members
    3. Display members by age required.
    4. Save list of member
    5. Exit

The fourth option saves the entire list of Member into a text file.
 */
package pretest_I0_4;

import java.util.*;
public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.menu();
    }
    
    private void menu(){
        MemberCatalog mc = new MemberCatalog();
        Scanner sc = new Scanner(System.in);
        String op = "1";
        
        while(true){
            System.out.println("\n MENU");
            System.out.println("1. them thanh vien moi");
            System.out.println("2. in danh sach");
            System.out.println("3. in danh sach theo do tuoi");
            System.out.println("4. luu file");
            System.out.println("5. thoat chuong trinh");
            System.out.println("======================");
            System.out.print(">> nhap ma so chuc nang [1-5]: ");
            op = sc.nextLine().trim();
            switch (op) {
                case "1":
                    Member m = new Member();
                    m.input();
                    mc.put(m);
                    break;
                    
                case "2":
                    mc.get();
                    break;
                    
                case "3":
                    System.out.print("\n >> nhap do tuoi: ");
                    int tuoi = Integer.parseInt(sc.nextLine().trim());
                    mc.get(tuoi);
                    break;
                    
                case "4":
                    mc.save();
                    break;
                    
                case "5":
                    return;
                default:
                    System.out.println(" >> Nhap sai ma chuc nang");;
            }
        }
        
    }
    
}
