package Resources;

public class SeatDTO {
    private int seatId;
    private String seatType;
    private int seatCost;
    private int ticketSold;
    private int totalMoney;
    private int avaliable;

    public SeatDTO(){}
    public SeatDTO(int seatId, String seatType, int seatCost) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.seatCost = seatCost;
    }


    public int getAvaliable() {
        return this.avaliable;
    }

    public void setAvaliable(int avaliable) {
        this.avaliable = avaliable;
    }

    public int getTicketSold() {
        return this.ticketSold;
    }

    public void setTicketSold(int ticketSold) {
        this.ticketSold = ticketSold;
    }

    public int getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
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
