package Controllers;

import java.sql.SQLException;

import Models.EmployeeDAO;
import Resources.EmployeeDTO;
import at.favre.lib.crypto.bcrypt.BCrypt;

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
        if(employee.getEmployeeDesignation().equals("booking clerk")){
            return 1;
        }
        return 2;
    }

}
