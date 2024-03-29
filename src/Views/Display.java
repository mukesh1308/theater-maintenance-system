package Views;

import java.util.ArrayList;

import Controllers.EmployeeController;
import Controllers.MovieController;
import Resources.BillDTO;
import Resources.EmployeeDTO;
import Resources.GenreDTO;
import Resources.LanguageDTO;
import Resources.MovieDTO;
import Resources.MovieReportDTO;
import Resources.RevenueReportDTO;
import Resources.ScheduleDTO;
import Resources.SeatDTO;

public class Display {
    public static void displayEmployee() throws Exception{
        System.out.printf("%-15s%-40s%-40s%-15s%-20s\n","Employee id","Employee name","Email","Gender","designation");
        System.out.println("-".repeat(130));
        ArrayList<EmployeeDTO> arr=EmployeeController.getBookingClerk();
        for(EmployeeDTO emp:arr){
            System.out.printf("%-15d%-40s%-40s%-15s%-20s\n",emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmail(),emp.getEmployeeGender(),emp.getEmployeeDesignation());
        }
        System.out.println();
    }
    public static void displayLanguage() throws Exception{
        System.out.printf("%-20s%-30s\n","language id","language");
        System.out.println("-".repeat(50));
        ArrayList<LanguageDTO> arr=MovieController.getLanguage();
        for(LanguageDTO lang:arr){
            System.out.printf("%-20d%-30s\n",lang.getLanguageId(),lang.getLanguage());
        }
        System.out.println();
    }
    public static void displayGenre() throws Exception{
        System.out.printf("%-20s%-30s\n","genre id","genre");
        System.out.println("-".repeat(50));
        ArrayList<GenreDTO> arr=MovieController.getGenre();
        for(GenreDTO genre:arr){
            System.out.printf("%-20d%-30s\n",genre.getGenderId(),genre.getGenre());
        }
        System.out.println();
    }
    public static void displayMovieReport(ArrayList<MovieReportDTO> arr) throws Exception{
        System.out.printf("%-20s%-40s%-20s\n", "movie id","movie name","revenue");
        System.out.println("-".repeat(80));
        for(MovieReportDTO movie:arr){
            System.out.printf("%-20s%-40s%-20s\n", movie.getMovieId(),movie.getMovieName(),movie.getTotal());
        }
        System.out.println();
    }
    public static void displayMovie(ArrayList<MovieDTO> arr) throws Exception{
        System.out.printf("%-20s%-40s%-20s%-20s%-20s%-20s\n","movie id","movie name","language","gener","release_date","duration");
        System.out.println("-".repeat(140));
        for(MovieDTO movie:arr){
            System.out.printf("%-20d%-40s%-20s%-20s%-20s%-20d\n",movie.getMovieId(),movie.getMovieName(),movie.getMovieLanguage(),movie.getMovieGenre(),movie.getMovieReleaseDate(),movie.getMovieDuration());
        }
        System.out.println();
    }
    public static void displaySchedule(ArrayList<ScheduleDTO> arr){
        System.out.printf("%-20s%-20s%-20s%-40s%-20s%-20s%-20s\n","Schedule id","Date","Time","movie name","language","screen","screen type");
        System.out.println("-".repeat(160));
        for(ScheduleDTO schedule:arr){
            System.out.printf("%-20s%-20s%-20s%-40s%-20s%-20s%-20s\n",schedule.getId(),schedule.getDate(),schedule.getShow(),schedule.getMovieName(),schedule.getMovieLanguage(),schedule.getScreenId(),schedule.getScreenType());
        }
        System.out.println();
    }
    public static void displayRevenue(ArrayList<RevenueReportDTO> arr){
        System.out.printf("%-20s%-30s%-20s%-20s\n","employee_id","employee name","ticket sold","total money");
        System.out.println("-".repeat(90));
        int sum=0;
        for(RevenueReportDTO revenue:arr){
            System.out.printf("%-20d%-30s%-20d%-20d\n",revenue.getEmployeeId(),revenue.getEmployeeName(),revenue.getTicketSold(),revenue.getTotalMoney());
            sum+=revenue.getTotalMoney();
        }
        System.out.println("-".repeat(90));
        System.out.printf("%-70s%-20d\n","total",sum);
        System.out.println();
    }
    public static void displayBookingReport(ArrayList<SeatDTO> arr){
        System.out.printf("%-15s%-20s%-20s%-20s\n","seat id","seat type","ticket sold","total money");
        System.out.println("-".repeat(75));
        for(SeatDTO seat:arr){
            System.out.printf("%-15d%-20s%-20d%-20d\n",seat.getSeatId(),seat.getSeatType(),seat.getTicketSold(),seat.getTotalMoney());
        }
        System.out.println();
    }

    public static void displayAvaliableSeat(ArrayList<SeatDTO> arr){
        System.out.printf("%-20s%-30s%-20s%-20s\n","seat id","seat type","seat cost","available");
        System.out.println("-".repeat(90));
        for(SeatDTO seat:arr){
            System.out.printf("%-20s%-30s%-20s%-20s\n",seat.getSeatId(),seat.getSeatType(),seat.getSeatCost(),seat.getAvaliable());
        }
        System.out.println();
    }

    public static void displayBill(BillDTO bill){
        System.out.println("-".repeat(60));
        System.out.printf("%-40s:%-20d\n","seat("+bill.getSeat()+")",bill.getSeatCost());
        System.out.printf("%-40s:%-20d\n","screen("+bill.getScreenType()+" "+bill.getScreenSize()+"feet)",bill.getScreenCost());
        System.out.printf("%-40s:%-20d\n","movie("+bill.getMovieDuration()+"min)",bill.getMovieCost());
        System.out.println("-".repeat(60));
        int total=bill.getMovieCost()+bill.getScreenCost()+bill.getSeatCost();
        System.out.printf("%-40s:%-20d\n","total",total);
        System.out.println();
    }
}
