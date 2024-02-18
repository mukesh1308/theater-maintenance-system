package Resources;

public class GenreDTO {
    private int genderId;
    private String genre;

    public GenreDTO(int genderId, String genre) {
        this.genderId = genderId;
        this.genre = genre;
    }

    public int getGenderId() {
        return this.genderId;
    }

    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
