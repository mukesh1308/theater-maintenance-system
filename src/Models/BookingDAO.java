package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.RevenueReportDTO;

public class BookingDAO extends Connect{
    private static BookingDAO instance;
    private PreparedStatement selectReport;
    private PreparedStatement selectCountBySchedule;
    private BookingDAO() throws SQLException{
        selectReport=conn.prepareStatement("SELECT E.emp_id,emp_name,Count(B.booking_cost),IFNULL(SUM(B.booking_cost),0) FROM employee E LEFT JOIN (SELECT * FROM booking WHERE date_time=?) B USING(emp_id) WHERE E.emp_designation='booking clerk' GROUP BY E.emp_id");
        selectCountBySchedule=conn.prepareStatement("SELECT COUNT(*) FROM booking WHERE schedule_id=?");
    }

    public static BookingDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new BookingDAO();
        }
        return instance;
    }

    public ArrayList<RevenueReportDTO> getReport(String date) throws SQLException{
        selectReport.setString(1,date);
        ArrayList<RevenueReportDTO> arr=new ArrayList<>();
        ResultSet res=selectReport.executeQuery();
        while(res.next()){
            arr.add(new RevenueReportDTO(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(4)));
        }
        return arr;
    }

    public int getCountBySchedule(int id) throws SQLException{
        selectCountBySchedule.setInt(1, id);
        ResultSet res=selectCountBySchedule.executeQuery();
        if(res.next()){
            return res.getInt(1);
        }
        return 0;
    }
}
