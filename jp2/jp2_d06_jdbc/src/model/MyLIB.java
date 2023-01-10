/*
 tao 1 ket noi den CSDL [sem2_demo] cua SQL SERVER
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MyLIB {
    
    //ham tao ket noi den CSDL [sem2_demo]
    public static Connection getConnect(){
        Connection cn = null;
        
        try {
            //1. load va dang ky driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        
            //2. tao ket noi den CSDL [sem2_demo]
            String password="123";
            String user="sa";
            String url="jdbc:sqlserver://127.0.0.1:1433;database=sem2_demo";
            cn = DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyLIB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cn;
    }
    
    
    public static void main(String[] args) {
        if (getConnect() != null){
            System.out.println("Ket noi thanh cong");
        }
        else{
            System.out.println(">> LOI: Ket noi that bai !!!");
        }

    }
}