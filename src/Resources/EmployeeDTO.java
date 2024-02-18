package Resources;


public class EmployeeDTO {
    private int employeeId;
    private String email;
    private String password;
    private String employeeName;
    private String employeeDesignation;
    private String employeeGender;
    
    
    public EmployeeDTO(int employeeId, String email, String password, String employeeName, String employeeDesignation, String employeeGender) {
        this.employeeId = employeeId;
        this.email = email;
        this.password = password;
        this.employeeName = employeeName;
        this.employeeDesignation = employeeDesignation;
        this.employeeGender = employeeGender;
    }

    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeDesignation() {
        return this.employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public String getEmployeeGender() {
        return this.employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }
}
