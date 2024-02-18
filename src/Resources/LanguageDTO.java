package Resources;

public class LanguageDTO {
    private int languageId;
    private String language;


    public LanguageDTO(int languageId, String language) {
        this.languageId = languageId;
        this.language = language;
    }

    public int getLanguageId() {
        return this.languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
