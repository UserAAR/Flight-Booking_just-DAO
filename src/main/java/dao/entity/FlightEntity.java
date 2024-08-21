package dao.entity;

public class FlightEntity {

    private int id;
    private String origin;
    private String destination;
    private String departureTime;
    private int freeSeats;

    public FlightEntity(int id,String origin, String destination, String departureTime, int freeSeats) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.freeSeats = freeSeats;
    }

    public int getId() {
        return id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    @Override
    public String toString() {
        return "FlightEntity{id=%d, origin='%s', destination='%s', departureTime='%s', freeSeats='%s'}".formatted(id, origin, destination, departureTime, freeSeats);
    }
}
