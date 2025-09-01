/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.EmployeesPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shubham Rj
 */
public class EmployeeDAO {
    
    public static boolean addNewEmp(EmployeesPojo emp) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into employees values(?,?,?,?)");
        ps.setInt(1,emp.getEmpNo());
        ps.setString(2,emp.getEmpName());
        ps.setDouble(3,emp.getEmpSal());
        ps.setInt(4,emp.getDeptno());
        
        int ans = ps.executeUpdate();
        return ans==1;
    }
    public static EmployeesPojo getEmployeebyempNo(int empNo) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Select * from employees where empno=?");
        ps.setInt(1,empNo);
        ResultSet rs = ps.executeQuery();
        EmployeesPojo emp = null;
        if(rs.next()){
            emp = new EmployeesPojo();
            emp.setEmpNo(rs.getInt(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpSal(rs.getDouble(3));
            emp.setDeptno(rs.getInt(4));
        }
        return emp;
    }
    public static List<EmployeesPojo> getAllEmp() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from employees");
        List<EmployeesPojo> empList = new ArrayList<>(); 
        while(rs.next()){
            EmployeesPojo emp = new EmployeesPojo();
            emp.setEmpNo(rs.getInt(1));
            emp.setEmpName(rs.getString(2));
            emp.setEmpSal(rs.getDouble(3));
            emp.setDeptno(rs.getInt(4));
            empList.add(emp);
        }
        return empList;
    }
    public static boolean updateEmp(EmployeesPojo emp) throws SQLException{
        
    }
    public static boolean deleteEmp(int  empNo)throws SQLException{
        
    }
    
}
