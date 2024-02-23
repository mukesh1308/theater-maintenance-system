package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.BillDTO;
import Resources.RevenueReportDTO;
import Resources.SeatDTO;

public class BookingDAO extends Connect{
    private static BookingDAO instance;
    private PreparedStatement selectReport;
    private PreparedStatement selectCountBySchedule;
    private PreparedStatement selectBookingReportByDate;
    private PreparedStatement selectBookingReport;
    private PreparedStatement insertBooking;
    private BookingDAO() throws SQLException{
        selectReport=conn.prepareStatement("SELECT E.emp_id,emp_name,Count(B.booking_cost),IFNULL(SUM(B.booking_cost),0) FROM employee E LEFT JOIN (SELECT * FROM booking WHERE DATE(date_time)=?) B USING(emp_id) WHERE E.emp_designation='booking clerk' GROUP BY E.emp_id");
        selectCountBySchedule=conn.prepareStatement("SELECT COUNT(*) FROM booking WHERE schedule_id=?");
        selectBookingReportByDate=conn.prepareStatement("SELECT S.seat_id,S.seat_type,COUNT(B.booking_cost),IFNULL(SUM(B.booking_cost),0) FROM seat_cost S LEFT JOIN (SELECT * FROM booking WHERE emp_id=? AND DATE(date_time)=?) B USING(seat_id) GROUP BY S.seat_id;");
        selectBookingReport=conn.prepareStatement("SELECT S.seat_id,S.seat_type,COUNT(B.booking_cost),IFNULL(SUM(B.booking_cost),0) FROM seat_cost S LEFT JOIN (SELECT * FROM booking WHERE emp_id=?) B USING(seat_id) GROUP BY S.seat_id;");
        insertBooking=conn.prepareStatement("INSERT INTO booking(schedule_id,booking_cost,emp_id,seat_id) VALUES(?,?,?,?)");
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

    public ArrayList<SeatDTO> getBookingReport(String date,int empId) throws SQLException{
        selectBookingReportByDate.setInt(1, empId);
        selectBookingReportByDate.setString(2, date);
        ResultSet res=selectBookingReportByDate.executeQuery();
        ArrayList<SeatDTO> arr=new ArrayList<>();
        while(res.next()){
            SeatDTO seat=new SeatDTO();
            seat.setSeatId(res.getInt(1));
            seat.setSeatType(res.getString(2));
            seat.setTicketSold(res.getInt(3));
            seat.setTotalMoney(res.getInt(4));
            arr.add(seat);
        }
        return arr;
    }

    public ArrayList<SeatDTO> getBookingReport(int empId) throws SQLException{
        selectBookingReport.setInt(1, empId);
        ResultSet res=selectBookingReport.executeQuery();
        ArrayList<SeatDTO> arr=new ArrayList<>();
        while(res.next()){
            SeatDTO seat=new SeatDTO();
            seat.setSeatId(res.getInt(1));
            seat.setSeatType(res.getString(2));
            seat.setTicketSold(res.getInt(3));
            seat.setTotalMoney(res.getInt(4));
            arr.add(seat);
        }
        return arr;
    }
    public void addBooking(BillDTO bill,int id) throws SQLException{
        insertBooking.setInt(1, bill.getScheduleId());
        insertBooking.setInt(2, bill.getMovieCost()+bill.getScreenCost()+bill.getSeatCost());
        insertBooking.setInt(3, id);
        insertBooking.setInt(4, bill.getSeatId());
        insertBooking.executeUpdate();
    }
}
