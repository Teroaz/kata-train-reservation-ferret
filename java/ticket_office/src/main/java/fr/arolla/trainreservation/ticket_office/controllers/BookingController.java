package fr.arolla.trainreservation.ticket_office.controllers;

import fr.arolla.trainreservation.ticket_office.dtos.BookingRequest;
import fr.arolla.trainreservation.ticket_office.dtos.BookingResponse;
import fr.arolla.trainreservation.ticket_office.services.BookingService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

  private final BookingService service;

  public BookingController() {
    this(new BookingService());
  }

  public BookingController(BookingService bookingService) {
    service = bookingService;
  }

  @RequestMapping("/reserve")
  BookingResponse reserve(@RequestBody BookingRequest bookingRequest) {
    var seatCount = bookingRequest.count();
    var trainId = bookingRequest.train_id();

    return service.bookSeat(trainId, seatCount);
  }

}
