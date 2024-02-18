package Resources;

public class MovieReportDTO {
    private int movieId;
    private String movieName;
    private int total;

    public MovieReportDTO(int movieId, String movieName, int total) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.total = total;
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

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
