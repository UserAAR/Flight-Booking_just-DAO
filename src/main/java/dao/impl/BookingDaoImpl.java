package dao.impl;

import DbConnection.DbConnector;
import dao.BookingDao;
import dao.entity.BookingEntity;
import dao.entity.FlightEntity;
import dao.entity.PassengerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao {
    DbConnector dbConnector;

    public BookingDaoImpl(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        List<BookingEntity> bookingEntities = new ArrayList<>();
        final String sqlSelect = "SELECT b.id AS booking_id,b.flight_id,b.booking_date_time,p.id AS passenger_id,p.full_name,f.id AS flight_id,f.origin,f.destination,f.departure_time,f.free_seats FROM bookings b JOIN bookings_passsengers bp ON b.id = bp.booking_id JOIN passengers p ON bp.passenger_id = p.id JOIN flights f ON b.flight_id = f.id;";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(sqlSelect);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BookingEntity bookingEntity = new BookingEntity(
                        resultSet.getInt("booking_id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getTimestamp("booking_date_time"),

                        new PassengerEntity(
                                resultSet.getInt("passenger_id"),
                                resultSet.getString("full_name")),

                        new FlightEntity(
                                resultSet.getInt("flight_id"),
                                resultSet.getString("origin"),
                                resultSet.getString("destination"),
                                resultSet.getString("departure_time"),
                                resultSet.getInt("free_seats"))
                );
                bookingEntities.add(bookingEntity);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.print(e.getMessage());
            }
        }

        return bookingEntities;
    }


    @Override
    public List<BookingEntity> getBookingById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<BookingEntity> bookingEntities = new ArrayList<>();
        final String getSql = "SELECT b.id AS booking_id,b.flight_id,b.booking_date_time,p.id AS passenger_id,p.full_name,f.id AS flight_id,f.origin,f.destination,f.departure_time,f.free_seats FROM bookings b JOIN bookings_passsengers bp ON b.id = bp.booking_id JOIN passengers p ON bp.passenger_id = p.id JOIN flights f ON b.flight_id = f.id where b.id = ?;";

        try {
            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(getSql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BookingEntity bookingEntity = new BookingEntity(
                        resultSet.getInt("booking_id"),
                        resultSet.getInt("flight_id"),
                        resultSet.getTimestamp("booking_date_time"),

                        new PassengerEntity(
                                resultSet.getInt("passenger_id"),
                                resultSet.getString("full_name")),

                        new FlightEntity(
                                resultSet.getInt("flight_id"),
                                resultSet.getString("origin"),
                                resultSet.getString("destination"),
                                resultSet.getString("departure_time"),
                                resultSet.getInt("free_seats"))
                );
                bookingEntities.add(bookingEntity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookingEntities;
    }

    @Override
    public boolean cancelBooking(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        final String deleteSql = "DELETE FROM bookings WHERE id = ?;";
        boolean isDeleted = false;

        try{
            connection = dbConnector.getConnection();
            preparedStatement = connection.prepareStatement(deleteSql);

            preparedStatement.setInt(1, id);
            int affectedRaws = preparedStatement.executeUpdate();
            isDeleted = (affectedRaws>0);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isDeleted;
    }

    @Override
    public BookingEntity createBooking(BookingEntity bookingEntity) {
        return null;
    }
}
