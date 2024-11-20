package fr.arolla.trainreservation.ticket_office;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.arolla.trainreservation.ticket_office.dtos.BookingRequest;
import fr.arolla.trainreservation.ticket_office.dtos.BookingResponse;
import fr.arolla.trainreservation.ticket_office.services.BookingService;
import fr.arolla.trainreservation.ticket_office.controllers.BookingController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ControllerTest {

  @Test
  void reserve_two_seats_from_empty_train() {
    final String trainId = "express_2000";


  }

  @Test
  void check_all_seats_for_seventy() {
    final String trainId = "express_2000";

  }
}
