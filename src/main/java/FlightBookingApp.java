import DbConnection.DbConnector;
import DbConnection.DbConnectorImpl;
import dao.BookingDao;
import dao.FlightDao;
import dao.entity.BookingEntity;
import dao.entity.FlightEntity;
import dao.impl.BookingDaoImpl;
import dao.impl.FlightDaoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class FlightBookingApp {

    public static void main(String[] args) {
       DbConnector postgreConnector = new DbConnectorImpl(
               "jdbc:postgresql://localhost:5432/Flight-Booking",
               "admin",
               "admin123");

        BookingDaoImpl bookingDao = new BookingDaoImpl(postgreConnector);
//        List<BookingEntity> allBookings = bookingDao.getAllBookings();
//        System.out.println("hello1");
//        allBookings.forEach(System.out::println);
//
//        for (BookingEntity allBooking : bookingDao.getAllBookings()) {
//            System.out.println(allBooking.toString());
//            System.out.println("hello");
//        }

//        bookingDao.getBookingById(1).forEach(System.out::println);

        FlightDao flightDao = new FlightDaoImpl(postgreConnector);
//        List<FlightEntity> allFlights = flightDao.getAllFlights();
//        allFlights.forEach(flight -> System.out.println(flight));

        System.out.println(flightDao.getFlightById(4));
    }
}
