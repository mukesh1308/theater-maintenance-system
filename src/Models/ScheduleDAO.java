package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.ScheduleDTO;

public class ScheduleDAO extends Connect{
    private static ScheduleDAO instance;
    private PreparedStatement selectByDateTime;
    private PreparedStatement selectByDate;
    private PreparedStatement insert;
    private ScheduleDAO() throws SQLException{
        selectByDateTime=conn.prepareStatement("SELECT schedule_id,date,show_time,movie_id,screen_id FROM movie_schedule WHERE date=? AND show_time=? AND screen_id=?");
        insert=conn.prepareStatement("INSERT INTO movie_schedule(date,show_time,movie_id,screen_id) VALUES (?,?,?,?)");
        selectByDate=conn.prepareStatement("SELECT S.schedule_id,S.date,S.show_time,M.movie_name,L.language,Sc.screen_no,St.screen_type FROM movie_schedule S JOIN movie M USING(movie_id) JOIN languages L USING(language_id) JOIN screen Sc USING(screen_id) JOIN screen_types St USING(screen_type_id) WHERE S.Date=? ORDER BY S.show_time");
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
    public ArrayList<ScheduleDTO> getSchedule(String date) throws SQLException{
        ArrayList<ScheduleDTO> arr=new ArrayList<>();
        selectByDate.setString(1, date);
        ResultSet res=selectByDate.executeQuery();
        while(res.next()){
            ScheduleDTO schedule=new ScheduleDTO();
            schedule.setId(res.getInt(1));
            schedule.setDate(res.getString(2));
            schedule.setShow(res.getString(3));
            schedule.setMovieName(res.getString(4));
            schedule.setMovieLanguage(res.getString(5));
            schedule.setScreenId(res.getInt(6));;
            schedule.setScreenType(res.getString(7));
            arr.add(schedule);
        }
        return arr;
    }
}
