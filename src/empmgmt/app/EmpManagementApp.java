/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.app;

import empmgmt.dao.EmployeeDAO;
import empmgmt.pojo.EmployeesPojo;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Shubham Rj
 */
public class EmpManagementApp {
    static Scanner kb;
    public static void main(String[] args) {
         kb = new Scanner(System.in);
        int choice; 
        do{
            System.out.println("Select an Operation:");
            System.out.println("1. Add new emp\n2.Search employee\n3. Show all emp\n4.Update emp\n5.Delete emp\n6.Quit");
            choice = kb.nextInt();
            switch(choice){
                case 1:
                    addNewEmp();
                    break;
                case 2:
                    searchEmp();
                    break;
                case 3:
                    showAllEmp();
                    break;
                case 4:
                    updateEmp();
                    break;
                case 5:
                    deleteEmp();
                    break;
                case 6:
                    System.out.println("Thank you for using the app");
                    break;
                default:
                    System.out.println("Wrong choice ! Try again");
                }
            }while(choice!=6);
        }
    public static void addNewEmp(){
        try{
            System.out.println("Enter empno");
            int eno = kb.nextInt();
            
            System.out.println("Enter employee name");
            kb.nextLine();
            String ename = kb.nextLine();
            
            System.out.println("Enter Salary:");
            double sal = kb.nextDouble();
            
            System.out.println("Enter depno");
            int dno = kb.nextInt();
            
            EmployeesPojo emp = new EmployeesPojo(eno,ename,sal,dno);
            boolean result = EmployeeDAO.addNewEmp(emp);
            System.out.println(result==true? "Record Inserted" : "Record not inserted");
            
        }catch(SQLException ex){
            System.out.println("Exception:Cannot add the rec:"+ex.getMessage());
        }
    }

    public static void searchEmp() {
        try{
            System.out.println("Enter empno for searching");
            int eno = kb.nextInt();
            EmployeesPojo emp = EmployeeDAO.getEmployeebyempNo(eno);
            if(emp==null){
                System.out.println("No record of employee:"+eno+" found in the DB");
            }else{
                System.out.println("Empno:"+emp.getEmpNo());
                System.out.println("Salary:"+emp.getEmpName());
                System.out.println("Salary:"+emp.getEmpSal());
                System.out.println("Salary:"+emp.getDeptno());
            }
    }catch(SQLException ex){
        System.out.println("Exception:Cannot search the rec:"+ex.getMessage());
    }
  }

    public static void showAllEmp() {
        try{
            List<EmployeesPojo> empList = EmployeeDAO.getAllEmp();
            if(empList.size()==0){
                System.out.println("Sorry! No rec in the DB");
            }
            else{
                for(EmployeesPojo emp:empList){
                System.out.println("Empno:"+emp.getEmpNo());
                System.out.println("Ename:"+emp.getEmpName());
                System.out.println("Salary:"+emp.getEmpSal());
                System.out.println("Deptno:"+emp.getDeptno());
                System.out.println("==================================");
            }
            }
        }catch(SQLException ex){
            System.out.println("Exception:Cannot add the rec:"+ex.getMessage());
        }
    }

    public static void updateEmp() {
        try{
            System.out.println("Enter empno whose rec is to be updated");
            int eno = kb.nextInt();
            
            System.out.println("Enter new employee name");
            kb.nextLine();
            String ename = kb.nextLine();
            
            System.out.println("Enter new Salary:");
            double sal = kb.nextDouble();
            
            System.out.println("Enter new depno");
            int dno = kb.nextInt();
            
            EmployeesPojo emp = new EmployeesPojo(eno,ename,sal,dno);
            boolean result = EmployeeDAO.updateEmp(emp);
            System.out.println(result==true? "Record Updated" : "Record not found");
            
        }catch(SQLException ex){
            System.out.println("Exception:Cannot update the rec:"+ex.getMessage());
        }
    }

    public static void deleteEmp() {
        try{
            System.out.println("Enter empno whose rec is to be deleted");
            int eno = kb.nextInt();
            boolean result = EmployeeDAO.deleteEmp(eno);
            System.out.println(result==true? "Record deleted" : "Record not found");
            
        }catch(SQLException ex){
            System.out.println("Exception:Cannot delete the rec:"+ex.getMessage());
        }
    }
}
