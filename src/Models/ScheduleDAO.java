package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resources.ScheduleDTO;

public class ScheduleDAO extends Connect{
    private static ScheduleDAO instance;
    private PreparedStatement selectByDateTime;
    private PreparedStatement insert;
    private ScheduleDAO() throws SQLException{
        selectByDateTime=conn.prepareStatement("SELECT schedule_id,date,show_time,movie_id,screen_id FROM movie_schedule WHERE date=? AND show_time=? AND screen_id=?");
        insert=conn.prepareStatement("INSERT INTO movie_schedule(date,show_time,movie_id,screen_id) VALUES (?,?,?,?)");
    }

    public static ScheduleDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new ScheduleDAO();
        }
        return instance;
    }

    public ScheduleDTO getByDateTime(String date,String time,int screen) throws SQLException{
        selectByDateTime.setString(1, date);
        selectByDateTime.setString(2, time);
        selectByDateTime.setInt(3,screen);
        ResultSet res=selectByDateTime.executeQuery();
        if(res.next()){
            return new ScheduleDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getInt(5));
        }
        return null;
    }

    public void addSchedule(ScheduleDTO schedule) throws SQLException{
        insert.setString(1, schedule.getDate());
        insert.setString(2, schedule.getShow());
        insert.setInt(3, schedule.getMovieId());
        insert.setInt(4, schedule.getScreenId());
        insert.executeUpdate();
    }
}
