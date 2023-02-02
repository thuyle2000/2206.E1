/*
Thuc hien chuc nang CRUD them, xem, sua, xoa 1 lop hoc trong database [sem2_demo]
 */
package model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BatchDAO {

    //1. ham tra ve ds cac lop hoc
    public static ArrayList<Batch> get() {

        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if (cn == null) {
            System.out.println(">> Loi sai ket noi CSDL");
            return null;
        }

        ArrayList<Batch> ds = new ArrayList<>();
        try {
            //2. tao doi tuong Statement chua lenh truy van SQl
            Statement st = cn.createStatement();

            //3. thuc hien lenh SELECT 
            String sql = "select * from tbBatch";
            ResultSet rs = st.executeQuery(sql);

            //4. duyet cac dong trong rs
            while (rs.next()) {
                //doc tung cot tren dong, tao ra 1 doi tuong lop hoc tuong ung
                Batch b = new Batch(rs.getString("batchno"), rs.getString("description"), rs.getInt("fee"));
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

    //1. ham tra ve lop hoc co ma so id
    public static Batch get(String id) {

        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if (cn == null) {
            System.out.println(">> Loi sai ket noi CSDL");
            return null;
        }

        Batch b = null;
        try {
            //2. tao doi tuong Statement chua lenh truy van SQl
            Statement st = cn.createStatement();

            //3. thuc hien lenh SELECT 
            String sql = "select * from tbBatch where batchno like '" + id + "'";
            ResultSet rs = st.executeQuery(sql);

            //4. duyet cac dong trong rs
            if (rs.next()) {
                //doc tung cot tren dong, tao ra 1 doi tuong lop hoc tuong ung
                b = new Batch();
                b.batchno = rs.getString("batchno");
                b.description = rs.getString(2);
                b.fee = rs.getInt(3);
            }

            //5. dong cac tai nguyen
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(BatchDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return b;
    }

    //2. ham them 1 lop hoc moi vo Database
    public static int insert(Batch b) {
        int r = 0;

        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if (cn == null) {
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

    //3. ham cap nhat viec thay doi thong tin cua 1 lop hoc da co
    public static int update(String id, Batch b) {
        int r = 0;

        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if (cn == null) {
            System.out.println(">> Loi sai ket noi CSDL");
            return r;
        }

        try {
            //2. tao doi tuong prepareStatement de chua lenh update sql
            String sql = "UPDATE tbBatch set [description] = ?, [fee] = ? where [batchno] like ? ";
            PreparedStatement st = cn.prepareStatement(sql);

            //3. set gia tri cho cac tham so ? bang cac thuoc tinh tuong ung cua lop hoc [b]
            st.setString(1, b.description);
            st.setInt(2, b.fee);
            st.setString(3, id);

            //4. thuc hien lenh UPDATE
            r = st.executeUpdate();

            //5. dong cac tai nguyen
            st.close();
            cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(BatchDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }

    //4. ham xoa 1 lop hoc theo ma so
    public static int delete(String id) {
        int r = 0;

        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if (cn == null) {
            System.out.println(">> Loi sai ket noi CSDL");
            return r;
        }

        PreparedStatement st = null;
        try {
            //2. tao doi tuong prepareStatement de chua lenh DELETE sql
            String sql = "DELETE FROM [tbBatch] where [batchno] like ? ";
            st = cn.prepareStatement(sql);

            //3. set gia tri cho cac tham so ? bang cac thuoc tinh tuong ung cua lop hoc [b]
            st.setString(1, id);

            //4. thuc hien lenh DELETE
            r = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(BatchDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //5. dong cac tai nguyen       
            try {
                st.close();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BatchDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
}
