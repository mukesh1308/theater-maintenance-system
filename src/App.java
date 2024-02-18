import java.sql.SQLException;

import Models.Connect;
import Util.Input;

public class App extends Input {
    public static void main(String[] args) {
        try{
            Connect.getConnection();
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
            return;
        }
        
    }
}
