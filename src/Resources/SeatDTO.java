package Resources;

public class SeatDTO {
    private int seatId;
    private String seatType;
    private int seatCost;


    public SeatDTO(int seatId, String seatType, int seatCost) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatCost = seatCost;
    }


    public int getSeatId() {
        return this.seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatType() {
        return this.seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getSeatCost() {
        return this.seatCost;
    }

    public void setSeatCost(int seatCost) {
        this.seatCost = seatCost;
    }

}
