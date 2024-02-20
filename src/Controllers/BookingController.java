package Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Models.BookingDAO;
import Resources.RevenueReportDTO;

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
}
