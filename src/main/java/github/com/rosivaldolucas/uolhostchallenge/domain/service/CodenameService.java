package github.com.rosivaldolucas.uolhostchallenge.domain.service;

import github.com.rosivaldolucas.uolhostchallenge.domain.entity.Codename;
import github.com.rosivaldolucas.uolhostchallenge.domain.enums.Group;
import github.com.rosivaldolucas.uolhostchallenge.infra.AvengerCodename;
import github.com.rosivaldolucas.uolhostchallenge.infra.LeagueOfJusticeCodename;
import github.com.rosivaldolucas.uolhostchallenge.infra.clientresttemplate.ClientRestTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodenameService {

  private final ClientRestTemplate clientRestTemplate;

  public CodenameService(final ClientRestTemplate clientRestTemplate) {
    this.clientRestTemplate = clientRestTemplate;
  }

  public List<Codename> findAll(final Group group) {
    if (group.equals(Group.AVENGERS)) {
      final FindDataCodename avengerCodename = new AvengerCodename(this.clientRestTemplate);

      return avengerCodename.findAll();
    } else if (group.equals(Group.JUSTICE_LEAGUE)) {
      final FindDataCodename leagueOfJusticeCodename = new LeagueOfJusticeCodename(this.clientRestTemplate);

      return leagueOfJusticeCodename.findAll();
    } else {
      throw new RuntimeException("group codename not found");
    }
  }

}
