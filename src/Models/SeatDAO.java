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

    public ArrayList<SeatDTO> getAvaliableSeat(int id) throws SQLException{
        ArrayList<SeatDTO> arr=new ArrayList<>();
        ResultSet res=statement.executeQuery("SELECT * FROM seat_cost");
        while(res.next()){
            arr.add(new SeatDTO(res.getInt(1), res.getString(2), res.getInt(3)));
        }
        res=statement.executeQuery("SELECT basic_seat,economic_seat,luxurious_seat FROM screen WHERE screen_id IN (SELECT screen_id FROM movie_schedule WHERE schedule_id="+id+")");
        if(res.next()){
            arr.get(0).setAvaliable(res.getInt(1));
            arr.get(1).setAvaliable(res.getInt(2));
            arr.get(2).setAvaliable(res.getInt(3));
        }
        res=statement.executeQuery("SELECT seat_id,COUNT(*) FROM booking WHERE schedule_id="+id+" GROUP BY seat_id ORDER BY seat_id");
        while(res.next()){
            arr.get(res.getInt(1)-1).setAvaliable(arr.get(res.getInt(1)-1).getAvaliable()-res.getInt(2));
        }
        return arr;
    }

    public SeatDTO getById(int id) throws SQLException{
        ResultSet res=statement.executeQuery("SELECT * FROM seat_cost WHERE seat_id="+id);
        if(res.next()){
            return new SeatDTO(res.getInt(1), res.getString(2), res.getInt(3));
        }
        return null;
    }
}
