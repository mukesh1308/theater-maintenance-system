package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Resources.EmployeeDTO;

public class EmployeeDAO extends Connect {
    private static EmployeeDAO instance;
    private PreparedStatement selectByEmail;
    private PreparedStatement insertIntoLogin;
    private PreparedStatement insertIntoEmployee;
    private PreparedStatement selectByDesignation;
    private EmployeeDAO() throws SQLException{
        selectByEmail=conn.prepareStatement("SELECT L.email,L.password,L.emp_id,E.emp_name,E.emp_designation,E.gender FROM login L JOIN employee E USING(emp_id) WHERE email=?");
        insertIntoLogin=conn.prepareStatement("INSERT INTO login(email,password,emp_id) VALUES (?,?,?)");
        insertIntoEmployee=conn.prepareStatement("INSERT INTO employee(emp_name,emp_designation,emp_gender) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS);
        selectByDesignation=conn.prepareStatement("SELECT L.emp_id,L.email,E.emp_name,E.emp_designation,E.gender FROM login L JOIN employee E USING(emp_id) WHERE E.emp_designation=?");
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

    public void addEmployee(EmployeeDTO employee) throws SQLException{
        insertIntoEmployee.setString(1, employee.getEmployeeName());
        insertIntoEmployee.setString(2, employee.getEmployeeDesignation());
        insertIntoEmployee.setString(3, employee.getEmployeeGender());
        insertIntoEmployee.executeUpdate();
        ResultSet res=insertIntoEmployee.getGeneratedKeys();
        if(res.next()){
            insertIntoLogin.setString(1, employee.getEmail());
            insertIntoLogin.setString(2, employee.getPassword());
            insertIntoLogin.setInt(3, res.getInt(1));
        }
        insertIntoLogin.executeUpdate();
        return;
    }

    public void removeEmployee(int id) throws SQLException{
        statement.executeUpdate("DELETE FROM employee WHERE emp_id="+id);
        statement.executeUpdate("DELETE FROM login WHERE emp_id="+id);
    }

    public ArrayList<EmployeeDTO> getEmployee(String designation) throws SQLException{
        ArrayList<EmployeeDTO> arr=new ArrayList<>();
        selectByDesignation.setString(1, designation);
        ResultSet res=selectByDesignation.executeQuery();
        while(res.next()){
            EmployeeDTO employee=new EmployeeDTO();
            employee.setEmployeeId(res.getInt(1));
            employee.setEmail(res.getString(2));
            employee.setEmployeeName(res.getString(3));
            employee.setEmployeeDesignation(res.getString(4));
            employee.setEmployeeGender(res.getString(5));
            arr.add(employee);
        }
        return arr;
    }
}
