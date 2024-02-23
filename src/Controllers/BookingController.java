package Controllers;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Models.BookingDAO;
import Models.MovieDAO;
import Models.ScheduleDAO;
import Models.ScreenDAO;
import Models.SeatDAO;
import Resources.BillDTO;
import Resources.MovieDTO;
import Resources.RevenueReportDTO;
import Resources.ScheduleDTO;
import Resources.ScreenDTO;
import Resources.SeatDTO;
import Util.Cookie;

public class BookingController {
    static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    public static ArrayList<RevenueReportDTO> getReport() throws Exception{
        BookingDAO bookingModal=BookingDAO.getInstance();
        return bookingModal.getReport(format.format(new Date()));
    }
    public static ArrayList<RevenueReportDTO> getReport(String date) throws Exception{
        BookingDAO bookingModal=BookingDAO.getInstance();
        return bookingModal.getReport(date);
    }
    public static ArrayList<SeatDTO> getBookReportByDate(String date) throws SQLException{
        BookingDAO bookingModal=BookingDAO.getInstance();
        return bookingModal.getBookingReport(date, Cookie.getEmployee().getEmployeeId());
    }
    public static ArrayList<SeatDTO> getBookReportByDate() throws SQLException{
        BookingDAO bookingModal=BookingDAO.getInstance();
        return bookingModal.getBookingReport(format.format(new Date()), Cookie.getEmployee().getEmployeeId());
    }
    public static ArrayList<SeatDTO> getBookReport() throws SQLException{
        BookingDAO bookingModal=BookingDAO.getInstance();
        return bookingModal.getBookingReport(Cookie.getEmployee().getEmployeeId());
    }

    public static ArrayList<SeatDTO> getSeatAvaliable(int id) throws Exception{
        SeatDAO seatModal=SeatDAO.getInstance();
        return seatModal.getAvaliableSeat(id);
    }

    public static BillDTO getBill(int seatId,int scheduleId) throws Exception{
        BillDTO bill=new BillDTO();
        ScheduleDAO scheduleModal=ScheduleDAO.getInstance();
        MovieDAO movieModal=MovieDAO.getInstance();
        SeatDAO seatModal=SeatDAO.getInstance();
        ScreenDAO screenModal=ScreenDAO.getInstance();

        ScheduleDTO schedule=scheduleModal.getById(scheduleId);
        if(schedule==null){
            throw new Exception("Invalid scheduleId");
        }
        MovieDTO movie=movieModal.getMovieById(schedule.getMovieId());
        ScreenDTO screen=screenModal.getById(schedule.getScreenId());
        SeatDTO seat=seatModal.getById(seatId);
        if(seat==null){
            throw new Exception("Invalid seatId");
        }

        bill.setSeatId(seatId);
        bill.setScheduleId(scheduleId);
        bill.setSeat(seat.getSeatType());
        bill.setSeatCost(seat.getSeatCost());
        bill.setMovieId(movie.getMovieId());
        bill.setMovieDuration(movie.getMovieDuration());
        bill.setScreenCost(screen.getScreenCost());
        bill.setScreenSize(screen.getScreenSize());
        bill.setScreenType(screen.getScreenType());

        if(movie.getMovieDuration()<=100){
            bill.setMovieCost(15);
        }
        else if(movie.getMovieDuration()<=150){
            bill.setMovieCost(20);
        }
        else{
            bill.setMovieCost(25);
        }
        return bill;
    }

    public static void addBooking(BillDTO bill) throws Exception{
        BookingDAO bookingModal=BookingDAO.getInstance();
        bookingModal.addBooking(bill, Cookie.getEmployee().getEmployeeId());
    }
}
