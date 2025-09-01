/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.pojo;

/**
 *
 * @author Shubham Rj
 */
public class EmployeesPojo {

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getEmpSal() {
        return EmpSal;
    }

    public void setEmpSal(double EmpSal) {
        this.EmpSal = EmpSal;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public EmployeesPojo() {
    }

    public EmployeesPojo(int empNo, String empName, double EmpSal, int deptno) {
        this.empNo = empNo;
        this.empName = empName;
        this.EmpSal = EmpSal;
        this.deptno = deptno;
    }
    private int empNo;
    private String empName;
    private double EmpSal;
    private int deptno;
}
