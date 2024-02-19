package Views;

import java.util.ArrayList;

import Controllers.EmployeeController;
import Controllers.MovieController;
import Resources.EmployeeDTO;
import Resources.GenreDTO;
import Resources.LanguageDTO;
import Resources.MovieDTO;
import Resources.MovieReportDTO;
import Resources.ScheduleDTO;

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
            System.out.printf("%-20s%-20s%-20s%-40s%-20s%-20s%-20s\n",schedule.getScreenId(),schedule.getDate(),schedule.getShow(),schedule.getMovieName(),schedule.getMovieLanguage(),schedule.getScreenId(),schedule.getScreenType());
        }
        System.out.println();
    }
}
