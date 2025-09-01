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

/**
 *
 * @author Shubham Rj
 */
public class EmployeeDAO {
    
    public static boolean addNewEmp(EmployeesPojo emp){
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("Insert into employees values(?,?,?,?)");
        ps.setInt(1,emp.getEmpNo());
        ps.setString(2,emp.getEmpName());
        ps.setDouble(3,emp.getEmpSal());
        ps.setInt(4,emp.getDeptno());
        
        int ans = ps.executeUpdate();
        return ans==1;
        
    }
}
