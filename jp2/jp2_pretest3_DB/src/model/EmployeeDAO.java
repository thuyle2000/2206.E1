/*
Thuc hien chuc nang CRUD them, xem, sua, xoa 1 nhan vien trong database [sem2_demo]
 */
package model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeDAO {
    //1. ham tra ve ds cac lop hoc

    public static ArrayList<Employee> get() {

        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if (cn == null) {
            System.out.println(">> Loi sai ket noi CSDL");
            return null;
        }

        ArrayList<Employee> ds = new ArrayList<>();
        try {
            //2. tao doi tuong Statement chua lenh truy van SQl
            Statement st = cn.createStatement();

            //3. thuc hien lenh SELECT 
            String sql = "select * from tbEmployee";
            ResultSet rs = st.executeQuery(sql);

            //4. duyet cac dong trong rs
            while (rs.next()) {
                //doc tung cot tren dong, tao ra 1 doi tuong lop hoc tuong ung
                Employee b = new Employee(rs.getInt("id"), rs.getString("name"), rs.getBoolean("gender"), rs.getInt("salary"));
                ds.add(b);
            }

            //5. dong cac tai nguyen
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ds;
    }

    //2. ham them 1 lop hoc moi vo Database
    public static int insert(Employee b) {
        int r = 0;

        //1. tao ket noi den CSDL
        Connection cn = MyLIB.getConnect();
        if (cn == null) {
            System.out.println(">> Loi sai ket noi CSDL");
            return r;
        }

        try {
            //2. tao doi tuong prepareStatement de chua lenh insert sql
            String sql = "INSERT INTO tbEmployee VALUES (?,?,?)";
            PreparedStatement st = cn.prepareStatement(sql);

            //3. set gia tri cho cac tham so ? bang cac thuoc tinh tuong ung cua nhan vien [b]
            st.setString(1, b.name);
            st.setBoolean(2, b.gender);
            st.setInt(3, b.salary);

            //4. thuc hien lenh INSERT
            r = st.executeUpdate();

            //5. dong cac tai nguyen
            st.close();
            cn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return r;
    }

    //4. ham xoa 1 nhan vien theo ma so
    public static int delete(int id) {
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
            String sql = "DELETE FROM [tbEmployee] where [id] like ? ";
            st = cn.prepareStatement(sql);

            //3. set gia tri cho cac tham so ? bang cac thuoc tinh tuong ung cua nhan vien [b]
            st.setInt(1, id);

            //4. thuc hien lenh DELETE
            r = st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //5. dong cac tai nguyen       
            try {
                st.close();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return r;
    }
}
