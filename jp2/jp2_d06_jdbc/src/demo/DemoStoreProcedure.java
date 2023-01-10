/*  chuong trinh demo cach lap trinh store procedure JDBC */
package demo;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
public class DemoStoreProcedure {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print(" Ban muon in ds sinh vien [nam] hay [nu]? : ");
        boolean gender = sc.nextLine().trim().equalsIgnoreCase("nam");
        
        //1. load driver va create connection
        Connection cn = MyLIB.getConnect();
        
        if (cn == null) return;

        try {
            //2. tao doi tuong callableStatement de thuc hien store procedure
            String sql = "{call uspCount(?,?)}";
            CallableStatement cs = cn.prepareCall(sql);
            
            //3. set gia tri cho tham so input (true-> nam sinh)
            cs.setBoolean(1, gender);
            
            //4. khai bao tham so output
            cs.registerOutParameter(2, java.sql.Types.INTEGER);
            
            //5. thi hanh store
            ResultSet rs= cs.executeQuery();
            System.out.println("Danh sach sinh vien " + (gender? "nam":"nu"));
            while(rs.next()){
                System.out.print(rs.getString(1));
                System.out.print(", " + rs.getString(2));
                System.out.print(", " + rs.getString(3));
                System.out.print(", " + rs.getInt(5));
                System.out.println(", " + rs.getString(6));
            }
            
            //6. lay gia tri cua tham so output
            int cnt = cs.getInt(2);
            
            System.out.printf(">> Tong so sinh vien %s: %d \n",(gender?"nam":"nu"), cnt);
            
            //7. dong connection
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DemoStoreProcedure.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
