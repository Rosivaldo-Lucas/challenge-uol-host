package github.com.rosivaldolucas.uolhostchallenge.infra;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import github.com.rosivaldolucas.uolhostchallenge.domain.entity.Codename;
import github.com.rosivaldolucas.uolhostchallenge.domain.enums.Group;
import github.com.rosivaldolucas.uolhostchallenge.domain.service.FindDataCodename;
import github.com.rosivaldolucas.uolhostchallenge.infra.clientresttemplate.ClientRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class LeagueOfJusticeCodename implements FindDataCodename {

  private final String URL_LEAGUE_OF_JUSTICE = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";

  private final ClientRestTemplate clientRestTemplate;

  public LeagueOfJusticeCodename(final ClientRestTemplate clientRestTemplate) {
    this.clientRestTemplate = clientRestTemplate;
  }

  @Override
  public List<Codename> findAll() {
    final ResponseEntity<String> response = this.clientRestTemplate.getMethod(this.URL_LEAGUE_OF_JUSTICE);

    final LeagueOfJusticeOutput leagueOfJusticeOutput = this.convertXmlToType(response.getBody());

    assert leagueOfJusticeOutput != null;
    return leagueOfJusticeOutput.getCodinomes().stream().map(league -> Codename.createWith(league, Group.LIGA_DA_JUSTICA)).toList();
  }

  private LeagueOfJusticeOutput convertXmlToType(final String xml) {
    final XmlMapper xmlMapper = new XmlMapper();

    try {
      return xmlMapper.readValue(xml, LeagueOfJusticeOutput.class);
    } catch (final Exception e) {
      return null;
    }
  }

}
