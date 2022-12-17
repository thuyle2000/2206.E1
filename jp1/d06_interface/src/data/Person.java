/*
cau truc Person bao gom:
- fields: id, name, gender, yob
- methods: input(), toString() 
 */
package data;

import java.time.Year;
import java.util.Scanner;

public class Person {

    public String id, name;
    public boolean gender;
    public int yob;

    public Person() {
        id = "P00";
        name = "vo danh";
        gender = true;
        yob = 1998;
    }

    public Person(String id, String name, boolean gender, int yob) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.yob = yob;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("- nhap ID: ");
            id = sc.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println(" >> Loi: Id ko duoc de trong !");
                continue;
            }
            break;
        }

        while (true) {
            System.out.print("- nhap ho ten: ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println(" >> Loi: Ten ko duoc de trong !");
                continue;
            }
            break;
        }

        
        while (true) {
            System.out.print("- nhap gioi tinh (nam|nu): ");
            var temp = sc.nextLine().trim().toLowerCase();
            if (temp.equals("nam")|| temp.equals("nu")) {
                gender = temp.equals("nam");
                break;
            }
            System.out.println(" >> Loi: gioi tinh ko hop le !");
        }
        
        
        while (true) {
            System.out.print("- nhap nam sinh [1945-2010]: ");
            yob = Integer.parseInt(sc.nextLine().trim());
            if (yob>=1945 && yob<=2010) {               
                break;
            }
            System.out.println(" >> Loi: nam sinh ko hop le !");
        }
    }

    @Override
    public String toString() {
        int currentYear = Year.now().getValue();
        return String.format("%s, %s, %s, %d, %d", id, name, gender?"nam":"nu", yob, currentYear-yob);
    }
    
    public static void main(String[] args) {
        Person p = new Person();
        p.input();
        System.out.println(p);
    }

}
