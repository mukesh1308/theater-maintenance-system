package Controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Models.MovieDAO;
import Models.ScheduleDAO;
import Resources.MovieDTO;
import Resources.ScheduleDTO;

public class ScheduleController {
    private static SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    public static void addSchedule(String date,String show,int movie,int screen) throws Exception{
        Date d1=new Date();
        Date d2=format.parse(date);
        if(d2.before(d1)){
            throw new Exception("Connot Schedule In Past Date");
        }
        ScheduleDAO scheduleModal=ScheduleDAO.getInstance();
        ScheduleDTO sched=scheduleModal.getByDateTime(date, show, screen);
        if(sched!=null){
            throw new Exception("Schedul id "+sched.getId()+" is alrady filled");
        }
        MovieDAO movieModal=MovieDAO.getInstance();
        MovieDTO movi=movieModal.getMovieById(movie);
        if(movi==null){
            throw new Exception("Invalid Movie Id");
        }
        ScheduleDTO schedule=new ScheduleDTO();
        schedule.setDate(date);
        schedule.setMovieId(movie);
        schedule.setShow(show);
        schedule.setScreenId(screen);
        scheduleModal.addSchedule(schedule);
    }

    public static ArrayList<ScheduleDTO> getSchedule() throws Exception{
        ScheduleDAO scheduleModal=ScheduleDAO.getInstance();
        return scheduleModal.getSchedule(format.format(new Date()));
    }

    public static ArrayList<ScheduleDTO> getSchedule(String date) throws Exception{
        ScheduleDAO scheduleModal=ScheduleDAO.getInstance();
        return scheduleModal.getSchedule(date);
    }
}
