package Views;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;

import Controllers.EmployeeController;
import Resources.EmployeeDTO;
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

                }
                else if(choice==4){

                }
                else if(choice==5){

                }
                else if(choice==6){

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
                    System.out.println("Booking clerk");
                }
                else if(choice==8){
                    System.out.printf("%-15s%-40s%-40s%-15s%-20s\n","Employee id","Employee name","Email","Gender","designation");
                    System.out.println("-".repeat(130));
                    ArrayList<EmployeeDTO> arr=EmployeeController.getBookingClerk();
                    for(EmployeeDTO emp:arr){
                        System.out.printf("%-15d%-40s%-40s%-15s%-20s\n",emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmail(),emp.getEmployeeGender(),emp.getEmployeeDesignation());
                    }
                    System.out.println();
                    System.out.print("Enter employee id: ");
                    int id=sc.nextInt();
                    sc.nextLine();
                    System.out.println();
                    EmployeeController.removeEmployee(id);
                    System.out.println("employee removed");
                    System.out.println();
                }
                else if(choice==9){
                    System.out.printf("%-15s%-40s%-40s%-15s\n","Employee id","Employee name","Email","Gender");
                    System.out.println("-".repeat(110));
                    ArrayList<EmployeeDTO> arr=EmployeeController.getBookingClerk();
                    for(EmployeeDTO emp:arr){
                        System.out.printf("%-15d%-40s%-40s%-15s\n",emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmail(),emp.getEmployeeGender());
                    }
                    System.out.println();
                }
                else if(choice==10){
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
            System.out.println();
        }
    }
}
