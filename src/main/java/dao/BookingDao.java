package dao;

import dao.entity.BookingEntity;

import java.util.List;

public interface BookingDao {
    List<BookingEntity> getAllBookings();
    BookingEntity getBookingById(int id);
    boolean cancelBooking(int id);
    BookingEntity createBooking(BookingEntity bookingEntity);
}
