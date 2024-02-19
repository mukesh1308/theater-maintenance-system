package Models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Resources.MovieDTO;
import Resources.MovieReportDTO;

public class MovieDAO extends Connect {
    private static MovieDAO instance;
    private PreparedStatement insertMovie;
    private PreparedStatement selectById;
    private PreparedStatement selectByTop;
    private MovieDAO() throws SQLException{
        insertMovie=conn.prepareStatement("INSERT INTO movie(movie_name,genre_id,language_id,movie_duration,release_date) VALUES (?,?,?,?,?)");
        selectById=conn.prepareStatement("SELECT M.movie_id,M.movie_name,IFNULL(SUM(B.booking_cost),0) FROM booking B RIGHT JOIN movie_schedule S USING(schedule_id) Right JOIN movie M USING(movie_id) WHERE M.movie_id=? GROUP BY M.movie_id");
        selectByTop=conn.prepareStatement("SELECT M.movie_id,M.movie_name,IFNULL(SUM(B.booking_cost),0) FROM booking B Right JOIN movie_schedule S USING(schedule_id) RIGHT JOIN movie M USING(movie_id) GROUP BY M.movie_id ORDER BY SUM(B.booking_cost) DESC LIMIT ?");
    }

    public static MovieDAO getInstance() throws SQLException{
        if(instance==null){
            instance=new MovieDAO();
        }
        return instance;
    }
    public void addMovie(MovieDTO movie) throws SQLException{
        insertMovie.setString(1, movie.getMovieName());
        insertMovie.setInt(2, movie.getMovieGenre());
        insertMovie.setInt(3, movie.getMovieLanguage());
        insertMovie.setInt(4, movie.getMovieDuration());
        insertMovie.setString(5, movie.getMovieReleaseDate());
        insertMovie.executeUpdate();
    }
    public MovieDTO getMovieById(int id) throws SQLException{
        ResultSet res=statement.executeQuery("SELECT movie_id,movie_name,genre_id,language_id,movie_duration,release_date FROM movie WHERE movie_id="+id);
        if(res.next()){
            return new MovieDTO(res.getInt(1), res.getString(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6));
        }
        return null;
    }
    public MovieReportDTO movieReportById(int id) throws SQLException{
        selectById.setInt(1, id);
        ResultSet res=selectById.executeQuery();
        if(res.next()){
            return new MovieReportDTO(res.getInt(1), res.getString(2), res.getInt(3));
        }
        return null;
    } 
    public ArrayList<MovieReportDTO> movieReportByTop(int top) throws SQLException{
        selectByTop.setInt(1, top);
        ResultSet res=selectByTop.executeQuery();
        ArrayList<MovieReportDTO> arr=new ArrayList<>();
        while(res.next()){
            arr.add(new MovieReportDTO(res.getInt(1), res.getString(2), res.getInt(3)));
        }
        return arr;
    } 

}