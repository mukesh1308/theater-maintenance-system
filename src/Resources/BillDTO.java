package Resources;

public class BillDTO {
    private String seat;
    private int seatCost;
    private int screenCost;
    private String screenType;
    private int screenSize;
    private int movieCost;
    private int movieDuration;
    private int movieId;
    private int seatId;
    private int scheduleId;

    public BillDTO(){

    }

    public int getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getSeat() {
        return this.seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getSeatCost() {
        return this.seatCost;
    }

    public void setSeatCost(int seatCost) {
        this.seatCost = seatCost;
    }

    public int getScreenCost() {
        return this.screenCost;
    }

    public void setScreenCost(int screenCost) {
        this.screenCost = screenCost;
    }

    public String getScreenType() {
        return this.screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public int getMovieCost() {
        return this.movieCost;
    }

    public void setMovieCost(int movieCost) {
        this.movieCost = movieCost;
    }

    public int getMovieDuration() {
        return this.movieDuration;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public int getMovieId() {
        return this.movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getSeatId() {
        return this.seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

}
