package Controllers;

import java.util.ArrayList;

import Models.GenreDAO;
import Models.LanguageDAO;
import Models.MovieDAO;
import Resources.GenreDTO;
import Resources.LanguageDTO;
import Resources.MovieDTO;
import Resources.MovieReportDTO;

public class MovieController {
    public static ArrayList<LanguageDTO> getLanguage() throws Exception{
        LanguageDAO language=LanguageDAO.getInstance();
        ArrayList<LanguageDTO> arr=language.getLanguage();
        return arr;
    }
    public static ArrayList<GenreDTO> getGenre() throws Exception{
        GenreDAO genre=GenreDAO.getInstance();
        ArrayList<GenreDTO> arr=genre.getGenre();
        return arr;
    }
    public static void addMaovie(String name,String date,int duration,int genre,int language) throws Exception{
        MovieDTO movie=new MovieDTO();
        movie.setMovieName(name);
        movie.setMovieReleaseDate(date);
        movie.setMovieDuration(duration);
        movie.setMovieGenre(genre);
        movie.setMovieLanguage(language);
        MovieDAO movieModal=MovieDAO.getInstance();
        movieModal.addMovie(movie);
    }
    public static MovieReportDTO movieReportById(int id) throws Exception{
        MovieDAO movieModal=MovieDAO.getInstance();
        MovieReportDTO report=movieModal.movieReportById(id);
        if(report==null){
            throw new Exception("Invalid Movie id");
        }
        return report;
    }
    public static ArrayList<MovieReportDTO> MovieReportByTop(int top) throws Exception{
        MovieDAO movieModal=MovieDAO.getInstance();
        ArrayList<MovieReportDTO> arr=movieModal.movieReportByTop(top);
        return arr;
    }
}
