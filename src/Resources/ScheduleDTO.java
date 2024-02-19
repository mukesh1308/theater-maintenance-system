package Resources;

public class ScheduleDTO {
    private int id;
    private String date;
    private String show;
    private int movieId;
    private int screenId;
    private String movieName;
    private String screenType;
    private String movieLanguage;
    
    public ScheduleDTO(){}
    public ScheduleDTO(int id, String date, String show, int movieId, int screenId) {
        this.id = id;
        this.date = date;
        this.show = show;
        this.movieId = movieId;
        this.screenId = screenId;
    }
    

    public String getMovieLanguage() {
        return this.movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public int getId() {
        return this.id;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getScreenType() {
        return this.screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getShow() {
        return this.show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public int getMovieId() {
        return this.movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getScreenId() {
        return this.screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

}
