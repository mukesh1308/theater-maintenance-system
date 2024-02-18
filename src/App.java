import java.sql.SQLException;
import java.util.InputMismatchException;

import Controllers.EmployeeController;
import Models.Connect;
import Util.Input;
import Views.BookingClerk;
import Views.Manager;
import Views.Viewer;

public class App extends Input {
    public static void main(String[] args) {
        try{
            Connect.getConnection();
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
            return;
        }

        // start of applicatioin
        while(true){
            try{
                System.out.println("1.view");
                System.out.println("2.login");
                System.out.println("3.exit");
                System.out.println();
                System.out.print("enter your choice: ");
                int choice=sc.nextInt();
                sc.nextLine();
                System.out.println();
                if(choice==1){
                    Viewer.start();
                    System.out.println();
                }
                else if(choice==2){
                    System.out.print("Enter your Email: ");
                    String email=Input.sc.nextLine();
                    System.out.print("Enter Password: ");
                    String password=Input.sc.nextLine();
                    System.out.println();
                    int check=EmployeeController.login(email, password);
                    if(check==1){
                        System.out.println("booking clerk");
                        System.out.println();
                        BookingClerk.start();
                    }
                    else if(check==2){
                        System.out.println("manager");
                        System.out.println();
                        Manager.start();
                    }
                    System.out.println();
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
