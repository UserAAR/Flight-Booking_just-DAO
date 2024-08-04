package dao.entity;

import java.sql.Timestamp;

public class BookingEntity {
    private int id;
    private int flightId;
    private java.sql.Timestamp BookingDateTime;
    private PassengerEntity passengerEntity;

    public BookingEntity(int flightId, Timestamp dateTime) {
        this.flightId = flightId;
        this.BookingDateTime = dateTime;
    }

    public int getId() {
        return id;
    }


    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Timestamp getBookingDateTime() {
        return BookingDateTime;
    }

    public void setBookingDateTime(Timestamp bookingDateTime) {
        this.BookingDateTime = bookingDateTime;
    }

    @Override
    public String toString() {
        return "BookingEntity{id=%d, flightId=%d, dateTime=%s}".formatted(id, flightId, BookingDateTime);
    }
}
