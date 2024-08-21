package dao.impl;

import DbConnection.DbConnector;
import dao.FlightDao;
import dao.entity.FlightEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDaoImpl implements FlightDao {
    DbConnector dbConnector;

    public FlightDaoImpl(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<FlightEntity> getAllFlights() {
        List<FlightEntity> flights = new ArrayList<>();
        final String selectQuery = "SELECT * FROM flights";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(selectQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FlightEntity flight = new FlightEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("origin"),
                        resultSet.getString("destination"),
                        resultSet.getString("departure_time"),
                        resultSet.getInt("free_seats")
                );
                flights.add(flight);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (connection != null) dbConnector.closeConnection();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flights;
    }

    @Override
    public FlightEntity getFlightById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        FlightEntity flight = null;
        final String getSelect = "Select * from flights where id = ?;";

        try {
            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(getSelect);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 flight = new FlightEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("origin"),
                        resultSet.getString("destination"),
                        resultSet.getString("departure_time"),
                        resultSet.getInt("free_seats")
                );

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return flight;
    }
}
