package Resources;

public class MovieDTO {
    private int  movieId;
    private String movieName;
    private int movieGenre;
    private int movieLanguage;
    private int movieDuration;
    private String movieReleaseDate;

    public MovieDTO(){}
    public MovieDTO(int movieId, String movieName, int movieGenre, int movieLanguage, int movieDuration, String movieReleaseDate) {
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

    public int getMovieGenre() {
        return this.movieGenre;
    }

    public void setMovieGenre(int movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieLanguage() {
        return this.movieLanguage;
    }

    public void setMovieLanguage(int movieLanguage) {
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
