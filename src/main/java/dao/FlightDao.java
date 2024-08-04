package dao;

import dao.entity.FlightEntity;

import java.util.List;

public interface FlightDao {
    List<FlightEntity> getAllFlights();
    FlightEntity getFlightById(int id);
}
