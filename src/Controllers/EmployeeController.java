package Controllers;


import java.util.ArrayList;

import Models.EmployeeDAO;
import Resources.EmployeeDTO;
import Util.Cookie;
import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Result;

public class EmployeeController {
    public static int login(String email,String password) throws Exception{
        EmployeeDAO empModal=EmployeeDAO.getInstance();
        EmployeeDTO employee=empModal.getByEmail(email);

        if(employee==null){
            throw new Exception("Invalid User");
        }
        BCrypt.Result vefy=BCrypt.verifyer().verify(password.toCharArray(), employee.getPassword());
        if(!vefy.verified){
            throw new Exception("Invalid Password");
        }
        employee.setPassword(null);
        Cookie.setEmployee(employee);
        if(employee.getEmployeeDesignation().equals("booking clerk")){
            return 1;
        }
        return 2;
    }

    
    public static void addBookingClerk(String email,String password,String name,String gender) throws Exception{
        EmployeeDTO employee=new EmployeeDTO();
        EmployeeDAO empModal=EmployeeDAO.getInstance();
        EmployeeDTO emp=empModal.getByEmail(email);
        if(emp!=null){
            throw new Exception("Email alrady exists");
        }
        employee.setEmail(email);
        String hash=BCrypt.withDefaults().hashToString(10, password.toCharArray());
        employee.setPassword(hash);
        employee.setEmployeeName(name);
        employee.setEmployeeGender(gender);
        employee.setEmployeeDesignation("booking clerk");
        empModal.addEmployee(employee);
    }

    public static void addManager(String email,String password,String name,String gender) throws Exception{
        EmployeeDTO employee=new EmployeeDTO();
        EmployeeDAO empModal=EmployeeDAO.getInstance();
        EmployeeDTO emp=empModal.getByEmail(email);
        if(emp!=null){
            throw new Exception("Email alrady exists");
        }
        employee.setEmail(email);

        // hashing password
        String hash=BCrypt.withDefaults().hashToString(10, password.toCharArray());
        
        employee.setPassword(hash);
        employee.setEmployeeName(name);
        employee.setEmployeeGender(gender);
        employee.setEmployeeDesignation("manager");
        empModal.addEmployee(employee);
    }

    public static ArrayList<EmployeeDTO> getBookingClerk() throws Exception{
        EmployeeDAO empModal=EmployeeDAO.getInstance();
        return empModal.getEmployee("booking clerk");
    }

    public static void removeEmployee(int id) throws Exception{
        EmployeeDAO empModal=EmployeeDAO.getInstance();
        empModal.removeEmployee(id);
    }

    public static void updatePassword(String password,String newPassword,String conformPassword) throws Exception{
        if(!newPassword.equals(conformPassword)){
            throw new Exception("new password and conform password must be Same");
        }
        EmployeeDAO employeeModal=EmployeeDAO.getInstance();
        EmployeeDTO employee=employeeModal.getByEmail(Cookie.getEmployee().getEmail());
        Result vrfy=BCrypt.verifyer().verify(password.toCharArray(), employee.getPassword());
        if(!vrfy.verified){
            throw new Exception("Invalid Password");
        }
        String hash=BCrypt.withDefaults().hashToString(10, newPassword.toCharArray());
        employeeModal.updatePassword(employee.getEmail(),hash);
    }
}
