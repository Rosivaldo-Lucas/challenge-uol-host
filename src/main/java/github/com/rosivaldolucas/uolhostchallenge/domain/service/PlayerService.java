package github.com.rosivaldolucas.uolhostchallenge.domain.service;

import github.com.rosivaldolucas.uolhostchallenge.api.CreateNewPlayerInput;
import github.com.rosivaldolucas.uolhostchallenge.domain.entity.Codename;
import github.com.rosivaldolucas.uolhostchallenge.domain.entity.Player;
import github.com.rosivaldolucas.uolhostchallenge.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class PlayerService {

  private final PlayerRepository playerRepository;

  private final CodenameService codenameService;

  public PlayerService(final PlayerRepository playerRepository, final CodenameService codenameService) {
    this.playerRepository = playerRepository;
    this.codenameService = codenameService;
  }

  public Set<Player> findAll() {
    return this.playerRepository.findAll();
  }

  public String create(final CreateNewPlayerInput input) {
    final List<Codename> codenames = this.codenameService.findAll(input.group());

    final List<Codename> availableCodenames = codenames.stream()
            .filter(codename -> this.playerRepository.findByCodename(codename.getCodename()).isEmpty()).toList();

    final Codename codename = this.chooseRandomCodename(availableCodenames);

    final Player newPlayer = Player
            .createWith(input.name(), input.email(), input.phone(), codename);

    this.playerRepository.save(newPlayer);

    return codename.getCodename();
  }

  private Codename chooseRandomCodename(final List<Codename> codenames) {
    if (codenames == null || codenames.isEmpty()) {
      throw new IllegalArgumentException("the list cannot be null or empty");
    }

    int randomIndex = new Random().nextInt(codenames.size());

    return codenames.get(randomIndex);
  }

}
