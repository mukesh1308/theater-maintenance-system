package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resources.EmployeeDTO;

public class EmployeeDAO extends Connect {
    private static EmployeeDAO instance;
    private PreparedStatement selectByEmail;
    private EmployeeDAO() throws SQLException{
        selectByEmail=conn.prepareStatement("SELECT L.email,L.password,L.emp_id,E.emp_name,E.emp_designation,E.gender FROM login L JOIN employee E WHERE email=?");
    }

    public static EmployeeDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new EmployeeDAO();
        }
        return instance;
    }

    public EmployeeDTO getByEmail(String email) throws SQLException{
        selectByEmail.setString(1, email);
        ResultSet res=selectByEmail.executeQuery();
        if(res.next()){
            return new EmployeeDTO(res.getInt(3), res.getString(1), res.getString(2), res.getString(4), res.getString(5), res.getString(6));
        }
        return null;
    }
}
