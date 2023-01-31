/*
Class MemberCatalog is used to manage the member list.
- Define a generic collection Hashtable<K,V> named mList that can store detailed
    information of all members. K (Key) is mapped to a String (memberID) and V (Value) is
    mapped to an object of Member class.
- Create a constructor to initialize mList field.
- Define method put(Member m) to add a new member into MemberList.
- Define method get() to display list of members in an appropriate format,
    including the total number of members.
- Define method get(int age) to display list of members have age required.
- Define method save() to write list of member into a text file named “member.txt”.
    Information of each member shoud be write in a new line.
 */
package pretest_I0_4;

import java.util.*;
import java.io.*;
public class MemberCatalog {
    public Hashtable<String, Member> mList = new Hashtable<>();
    
    //Define method put(Member m) to add a new member into MemberList
    public void put(Member m){
        if(mList.containsKey(m.memberID)){
            //ma thanh vien da ton tai trong ds du lieu
            System.out.println(">> LOI: ma so da ton tai, tu choi them du lieu !");
            return;
        }
        
        mList.put(m.memberID, m);
        System.out.println(">> them thanh vien moi thanh cong !");
    }
    
    
    //- Define method get() to display list of members in an appropriate format,
    //  including the total number of members.
    public void get(){
        if(mList.isEmpty()){
            System.out.println(">> HT chua co du lieu !!!");
            return;
        }
        System.out.println("\n Danh sach thanh vien");
        mList.values().stream().forEach(System.out::println);
        System.out.println("==========");
        System.out.printf(" >> Tong so thanh vien : %d \n\n", mList.size());
        
    }
    
    //- Define method get(int age) to display list of members have age required.
    public void get(int age){
        if(mList.isEmpty()){
            System.out.println(">> HT chua co du lieu !!!");
            return;
        }
        
        var dem = mList.values().stream().filter(x->x.age>=age).count();
        if (dem==0){
            System.out.println(">> Ko tim thay !!!");
            return;
        }
        
        System.out.printf("\n\n Danh sach thanh vien tren [%d] tuoi \n", age);
        mList.values().stream().filter(x->x.age>=age).forEach(System.out::println);
        
    }
    
    //- Define method save() to write list of member into a text file named “member.txt”.
    // Information of each member shoud be write in a new line.
    String fname = "member.txt";
    public void save(){
        try (PrintWriter pw = new PrintWriter(fname)){
            mList.values().stream().forEach(pw::println);
            System.out.println(">> Luu file thanh cong !");
        } catch (Exception e) {
            System.out.println(">> Loi: "+ e.getMessage());
        }
    }
}
