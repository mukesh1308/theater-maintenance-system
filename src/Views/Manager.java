package Views;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import Controllers.EmployeeController;
import Controllers.MovieController;
import Controllers.ScheduleController;
import Resources.MovieReportDTO;
import Util.Input;

public class Manager extends Input{
    public static String shows[]={"8:00","12:00","16:00","20:00"};
    public static void start(){
        while(true){
            try{
                System.out.println("1.Today's revenue");
                System.out.println("2.View movie schedule");
                System.out.println("3.Add movie schedule");
                System.out.println("4.remove movie schedule");
                System.out.println("5.Add new movie");
                System.out.println("6.movie report");
                System.out.println("7.Add Booking clerk");
                System.out.println("8.remove Booking clerk");
                System.out.println("9.display booking clerk");
                System.out.println("10.logout");
                System.out.println();
                System.out.print("Enter your choice: ");
                int choice=sc.nextInt();
                Input.sc.nextLine();
                System.out.println();
                if(choice==1){
    
                }
                else if(choice==2){

                }
                else if(choice==3){
                    System.out.print("Enter schedule date (yyyy-MM-dd): ");
                    String date=sc.nextLine();
                    System.out.println();
                    for(int i=0;i<shows.length;i++){
                        System.out.println(i+" -> "+shows[i]);
                    }
                    System.out.print("Enter show: ");
                    int time=sc.nextInt();
                    System.out.print("Enter movie id: ");
                    int movie=sc.nextInt();
                    System.out.print("Enter screen id: ");
                    int screen=sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    ScheduleController.addSchedule(date, shows[time], movie, screen);
                    System.out.println("Schedule added");
                }
                else if(choice==4){

                }
                else if(choice==5){
                    System.out.print("Enter movie name: ");
                    String name=sc.nextLine();
                    System.out.print("Enter release date (yyyy-mm-dd):");
                    String date=sc.nextLine();
                    System.out.print("Enter movie duration (min): ");
                    int duration=sc.nextInt();
                    System.out.println("\n");
                    Display.displayGenre();
                    System.out.print("Enter genre id: ");
                    int genre=sc.nextInt();
                    System.out.println("\n");
                    Display.displayLanguage();
                    System.out.print("Enter language id: ");
                    int language=sc.nextInt();
                    Input.sc.nextLine();
                    MovieController.addMaovie(name, date, duration, genre, language);
                    System.out.println("Movie Added");
                }
                else if(choice==6){
                    System.out.println("1.Top revenue");
                    System.out.println("2.find movie");
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int c6=sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    if(c6==1){
                        System.out.print("Enter top: ");
                        int top=sc.nextInt();
                        sc.nextLine();
                        Display.displayMovieReport(MovieController.MovieReportByTop(top));
                    }
                    else if(c6==2){
                        System.out.print("Enter movie id: ");;
                        int id=sc.nextInt();
                        sc.nextLine();
                        ArrayList<MovieReportDTO> arr=new ArrayList<>();
                        arr.add(MovieController.movieReportById(id));
                        Display.displayMovieReport(arr);
                    }
                }
                else if(choice==7){
                    System.out.print("Enter employee name: ");
                    String name=sc.nextLine();
                    System.out.print("Enter gender (M/F): ");
                    String gender=sc.nextLine().toUpperCase();
                    System.out.print("Enter email: ");
                    String email=sc.nextLine();
                    System.out.print("Enter password: ");
                    String password=sc.nextLine();
                    System.out.println();
                    
                    // adding a booking clerk
                    EmployeeController.addBookingClerk(email, password, name, gender);
                    System.out.println("Added Booking clerk");
                }
                else if(choice==8){

                    // display booking clerk
                    Display.displayEmployee();

                    System.out.print("Enter employee id: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    EmployeeController.removeEmployee(id);
                    System.out.println("employee removed");
                    System.out.println();
                }
                else if(choice==9){
                    //display booking clerk
                    Display.displayEmployee();
                }
                else if(choice==10){
                    break;
                }
            }
            catch(SQLException err){
                System.out.println("Database Error");
                System.out.println(err);
            }
            catch(ParseException err){
                System.out.println("Invalid Date");
            }
            catch(InputMismatchException err){
                System.out.println("Invalid Input");
            }
            catch(Exception err){
                System.out.println(err.getMessage());
            }
            System.out.println();
        }
    }
}
