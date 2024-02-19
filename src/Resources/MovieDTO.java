package Resources;

public class MovieDTO {
    private int  movieId;
    private String movieName;
    private int movieGenreId;
    private int movieLanguageId;
    private int movieDuration;
    private String movieReleaseDate;
    private String movieLanguage;
    private String movieGenre;

    public MovieDTO(){}
    public MovieDTO(int movieId, String movieName, int movieGenreId, int movieLanguageId, int movieDuration, String movieReleaseDate) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieGenreId = movieGenreId;
        this.movieLanguageId = movieLanguageId;
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

    public int getMovieGenreId() {
        return this.movieGenreId;
    }

    public void setMovieGenreId(int movieGenreId) {
        this.movieGenreId = movieGenreId;
    }

    public String getMovieLanguage() {
        return this.movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getMovieGenre() {
        return this.movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieLanguageId() {
        return this.movieLanguageId;
    }

    public void setMovieLanguageId(int movieLanguageId) {
        this.movieLanguageId = movieLanguageId;
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
