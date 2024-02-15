package github.com.rosivaldolucas.uolhostchallenge.infra.clientresttemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientRestTemplate {

  private final RestTemplate restTemplate;

  public ClientRestTemplate(final RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public ResponseEntity<String> getMethod(final String url) {
    return this.restTemplate.getForEntity(url, String.class);
  }

}
