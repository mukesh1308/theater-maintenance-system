package Views;

import java.sql.SQLException;
import java.util.InputMismatchException;

import Controllers.BookingController;
import Controllers.EmployeeController;
import Controllers.ScheduleController;
import Resources.BillDTO;
import Util.Cookie;
import Util.Input;

public class BookingClerk extends Input {
    public static void start(){
        while(true){
            try{
                System.out.println("1.booking");
                System.out.println("2.report");
                System.out.println("3.update password");
                System.out.println("4.logout");
                System.out.println();
                System.out.print("Enter your choice: ");
                int choice=sc.nextInt();
                sc.nextLine();
                System.out.println();
                if(choice==1){
                    System.out.println("1.today");
                    System.out.println("2.any date");
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int c2=Input.sc.nextInt();
                    Input.sc.nextLine();
                    System.out.println();
                    if(c2==1){
                        Display.displaySchedule(ScheduleController.getSchedule());
                    }
                    else{
                        System.out.print("Enter Date (yyyy-mm-dd): ");
                        String date=Input.sc.nextLine();
                        Display.displaySchedule(ScheduleController.getSchedule(date));
                    }
                    System.out.print("Enter schedule id: ");
                    int schedule=Input.sc.nextInt();
                    if(schedule==-1){
                        continue;
                    }
                    sc.nextLine();
                    Display.displayAvaliableSeat(BookingController.getSeatAvaliable(schedule));
                    System.out.print("Enter seat id: ");
                    int seat=sc.nextInt();
                    Input.sc.nextLine();
                    if(seat==-1){
                        continue;
                    }
                    BillDTO bill=BookingController.getBill(seat, schedule);
                    Display.displayBill(bill);
                    System.out.print("confirm bill(1/0): ");
                    int c1=sc.nextInt();
                    if(c1==0){
                        continue;
                    }
                    BookingController.addBooking(bill);
                    System.out.println("Booking added");
                }
                else if(choice==2){
                    System.out.println("1.today");
                    System.out.println("2.any date");
                    System.out.println("3.total");
                    System.out.println();
                    System.out.print("Enter your choice: ");
                    int c2=sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    if(c2==1){
                        Display.displayBookingReport(BookingController.getBookReportByDate());
                    }
                    else if(c2==2){
                        System.out.print("Enter date (yyyy-mm-dd): ");
                        String date=Input.sc.nextLine();
                        Display.displayBookingReport(BookingController.getBookReportByDate(date));
                    }
                    else if(c2==3){
                        Display.displayBookingReport(BookingController.getBookReport());
                    }
                }
                else if(choice==3){
                    System.out.print("Enter password: ");
                    String password=sc.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword=sc.nextLine();
                    System.out.print("Enter conform password: ");
                    String conformPassword=sc.nextLine();
                    EmployeeController.updatePassword(password, newPassword, conformPassword);
                    System.out.println("Password updated");
                }
                else if(choice==4){
                    Cookie.setEmployee(null);
                    break;
                }
            }
            catch(SQLException err){
                System.out.println("Database Error");
                System.out.println(err);
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
