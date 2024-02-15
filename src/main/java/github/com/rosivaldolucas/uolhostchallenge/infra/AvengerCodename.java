package github.com.rosivaldolucas.uolhostchallenge.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import github.com.rosivaldolucas.uolhostchallenge.domain.entity.Codename;
import github.com.rosivaldolucas.uolhostchallenge.domain.enums.Group;
import github.com.rosivaldolucas.uolhostchallenge.domain.service.FindDataCodename;
import github.com.rosivaldolucas.uolhostchallenge.infra.clientresttemplate.ClientRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class AvengerCodename implements FindDataCodename {

  private final String URL_AVENGERS = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";

  private final ClientRestTemplate clientRestTemplate;

  public AvengerCodename(final ClientRestTemplate clientRestTemplate) {
    this.clientRestTemplate = clientRestTemplate;
  }

  @Override
  public List<Codename> findAll() {
    final ResponseEntity<String> response = this.clientRestTemplate.getMethod(this.URL_AVENGERS);

    final AvengersOutput avengersOutput = this.convertJsonToType(response.getBody());

    assert avengersOutput != null;
    return avengersOutput.getVingadores().stream().map(avenger -> Codename.createWith(avenger.getCodinome(), Group.AVENGERS)).toList();
  }

  private AvengersOutput convertJsonToType(final String json) {
    final ObjectMapper objectMapper = new ObjectMapper();

    try {
      return objectMapper.readValue(json, AvengersOutput.class);
    } catch (final Exception e) {
      return null;
    }
  }

}
