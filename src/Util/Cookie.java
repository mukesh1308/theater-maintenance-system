package Util;

import Resources.EmployeeDTO;

public class Cookie {
    private static EmployeeDTO employee;

    public static EmployeeDTO getEmployee() {
        return employee;
    }

    public static void setEmployee(EmployeeDTO emp) {
        employee = emp;
    }
}
