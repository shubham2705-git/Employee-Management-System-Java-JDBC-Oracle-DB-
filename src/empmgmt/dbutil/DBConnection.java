/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Shubham Rj
 */
public class DBConnection {
    
    private static Connection conn;
    static{
        try{
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Shubham-Rj:1521/xe","advjavabatch2","mystudents");
            System.out.println("Connected Successfully");
        }catch(SQLException ex){
            System.out.println("Cannot Connect to the DB; "+ex.getMessage());
            System.exit(0);
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try{
            conn.close();
            System.out.println("Disconnected Successfully");
        }catch(SQLException ex){
            System.out.println("Cannot Disconnect to the DB; "+ex.getMessage());
        }
    }
}
