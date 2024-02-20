package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.SeatDTO;

public class SeatDAO extends Connect{
    private static SeatDAO instance;
    private SeatDAO() throws SQLException{

    } 

    public static SeatDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new SeatDAO();
        }
        return instance;
    }

    public static ArrayList<SeatDTO> getSeat() throws SQLException{
        ArrayList<SeatDTO> arr=new ArrayList<>();
        ResultSet res=statement.executeQuery("SELECT * FROM seat_cost");
        while(res.next()){
            arr.add(new SeatDTO(res.getInt(1), res.getString(2), res.getInt(3)));
        }
        return arr;
    }
}
