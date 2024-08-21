package dao.entity;

import java.sql.Timestamp;

public class BookingEntity {
    private int id;
    private int flightId;
    private java.sql.Timestamp BookingDateTime;
    private PassengerEntity passengerEntity;
    private FlightEntity flightEntity;

    public BookingEntity(int id,int flightId, Timestamp dateTime,PassengerEntity passengerEntity,FlightEntity flightEntity) {
        this.id = id;
        this.flightId = flightId;
        this.BookingDateTime = dateTime;
        this.passengerEntity = passengerEntity;
        this.flightEntity = flightEntity;
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

    public PassengerEntity getPassengerEntity() {
        return passengerEntity;
    }

    public void setPassengerEntity(PassengerEntity passengerEntity) {
        this.passengerEntity = passengerEntity;
    }

    public FlightEntity getFlightEntity() {
        return flightEntity;
    }

    public void setFlightEntity(FlightEntity flightEntity) {
        this.flightEntity = flightEntity;
    }

    @Override
    public String toString() {
        return "BookingEntity{id=%d, flightId=%d, BookingDateTime=%s, passengerEntity=%s, flightEntity=%s}".formatted(id, flightId, BookingDateTime, passengerEntity, flightEntity);
    }
}
