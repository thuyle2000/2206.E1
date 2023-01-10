/*
Thuc hien chuc nang them, xem, xoa, sua 1 lop hoc trong database [sem2_demo]
 */
package model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BatchDAO {
    
    //1. ham tra ve ds cac lop hoc
    public static ArrayList<Batch> get(){     
        
        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if(cn == null){
            System.out.println(">> Loi sai ket noi CSDL");
            return null;
        }
        
        ArrayList<Batch> ds = new ArrayList<>();
        try {
            //2. tao doi tuong Statement chua lenh truy van SQl
            Statement st = cn.createStatement();
            
            //3. thuc hien lenh SELECT 
            String sql = "select * from tbBatch";
            ResultSet rs =  st.executeQuery(sql);
            
            //4. duyet cac dong trong rs
            while(rs.next()){
                //doc tung cot tren dong, tao ra 1 doi tuong lop hoc tuong ung
                Batch b = new Batch(rs.getString("batchno"), rs.getString("description"), rs.getInt("fee"));
                
//                Batch ba = new Batch();
//                ba.batchno = rs.getString("batchno");
//                ba.description = rs.getString(2);
//                ba.fee = rs.getInt(3);
                
                ds.add(b);
            }
            
            //5. dong cac tai nguyen
            rs.close();
            st.close();
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(BatchDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return ds;
    }
    
    
    //2. ham them 1 lop hoc moi vo Database
    public static int insert(Batch b){
        int r = 0;
        
        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if(cn == null){
            System.out.println(">> Loi sai ket noi CSDL");
            return r;
        } 
 
        try {
            //2. tao doi tuong prepareStatement de chua lenh insert sql
            String sql = "INSERT INTO tbBatch VALUES (?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);
            
            //3. set gia tri cho cac tham so ? bang cac thuoc tinh tuong ung cua lop hoc [b]
            st.setString(1, b.batchno);
            st.setString(2, b.description);
            st.setInt(3, b.fee);
            
            //4. thuc hien lenh INSERT
            r = st.executeUpdate();
            
            //5. dong cac tai nguyen
            st.close();
            cn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(BatchDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
}
