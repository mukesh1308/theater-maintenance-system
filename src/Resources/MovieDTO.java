package Resources;

public class MovieDTO {
    private int  movieId;
    private String movieName;
    private String movieGenre;
    private String movieLanguage;
    private int movieDuration;
    private String movieReleaseDate;


    public MovieDTO(int movieId, String movieName, String movieGenre, String movieLanguage, int movieDuration, String movieReleaseDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieLanguage = movieLanguage;
        this.movieDuration = movieDuration;
        this.movieReleaseDate = movieReleaseDate;
    }


    public int getMovieId() {
        return this.movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return this.movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieGenre() {
        return this.movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieLanguage() {
        return this.movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public int getMovieDuration() {
        return this.movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public String getMovieReleaseDate() {
        return this.movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

}
