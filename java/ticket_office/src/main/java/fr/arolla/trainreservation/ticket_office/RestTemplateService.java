package fr.arolla.trainreservation.ticket_office;

import org.springframework.web.client.RestTemplate;

public class RestTemplateService {

  private static RestTemplate restTemplate;

  public static RestTemplate getInstance() {
    if (restTemplate == null) {
      restTemplate = new RestTemplate();
    }

    return restTemplate;
  }
}
