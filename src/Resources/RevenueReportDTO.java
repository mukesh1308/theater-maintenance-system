package Resources;

public class RevenueReportDTO {
    private int employeeId;
    private String employeeName;
    private int ticketSold;
    private int totalMoney;


    public RevenueReportDTO(int employeeId,String employeeName, int ticketSold, int totalMoney) {
        this.employeeName = employeeName;
        this.ticketSold = ticketSold;
        this.totalMoney = totalMoney;
        this.employeeId=employeeId;
    }


    public int getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getTicketSold() {
        return this.ticketSold;
    }

    public void setTicketSold(int ticketSold) {
        this.ticketSold = ticketSold;
    }

    public int getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

}
