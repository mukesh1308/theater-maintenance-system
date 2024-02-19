package Views;

import java.sql.SQLException;
import java.util.InputMismatchException;

import Controllers.ScheduleController;
import Util.Input;

public class Viewer extends Input {
    public static void start(){
        while(true){
            try{
                System.out.println("1.Today Schedule");
                System.out.println("2.Any Date");
                System.out.println("3.go back");
                System.out.println();
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
                System.out.println();
                if (choice == 1) {
                    Display.displaySchedule(ScheduleController.getSchedule());
                } 
                else if (choice == 2) {
                    System.out.print("Enter date (yyyy-mm-dd): ");
                    String date =sc.nextLine();
                    Display.displaySchedule(ScheduleController.getSchedule(date));    
                }
                else if(choice==3){
                    break;
                }
            }
            catch(SQLException err){
                System.out.println("Database Error");
            }
            catch(InputMismatchException err){
                System.out.println("Invalid Input");
            }
            catch(Exception err){
                System.out.println(err.getMessage());
            }
        }
    }
}
