package Resources;

public class ScreenDTO {
    private String screenType;
    private int screenSize;
    private int screenCost;


    public ScreenDTO(String screenType, int screenSize, int screenCost) {
        this.screenType = screenType;
        this.screenSize = screenSize;
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

    public int getScreenCost() {
        return this.screenCost;
    }

    public void setScreenCost(int screenCost) {
        this.screenCost = screenCost;
    }

}
