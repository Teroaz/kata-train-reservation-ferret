package fr.arolla.trainreservation.ticket_office.services;

import fr.arolla.trainreservation.ticket_office.Seat;
import fr.arolla.trainreservation.ticket_office.dtos.BookingResponse;
import fr.arolla.trainreservation.ticket_office.repositories.BookingRepository;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.stream.Stream;

public class BookingService {

  private final BookingRepository repository;

  public BookingService() {
    this(new BookingRepository());
  }
  public BookingService(BookingRepository bookingRepository) {
    repository = bookingRepository;
  }

  public @NotNull BookingResponse bookSeat(String trainId, int seatCount) {
    var bookingReference = repository.getBookingReference();

    var availableSeats = getAvailableTrainSeats(trainId);
    var toReserve = availableSeats.limit(seatCount);
    var ids = toReserve.map(seat -> seat.number() + seat.coach()).toList();
    repository.reserveBooking(trainId, ids, bookingReference);

    return new BookingResponse(trainId, bookingReference, ids);
  }

  private @NotNull Stream<Seat> getAvailableTrainSeats(String trainId) {
    ArrayList<Seat> seats = repository.getTrainSeat(trainId);
    return seats.stream().filter(seat -> seat.coach().equals("A") && seat.bookingReference() == null);
  }

}
