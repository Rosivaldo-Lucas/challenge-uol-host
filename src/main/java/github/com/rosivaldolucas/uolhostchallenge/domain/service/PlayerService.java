package github.com.rosivaldolucas.uolhostchallenge.domain.service;

import github.com.rosivaldolucas.uolhostchallenge.api.CreateNewPlayerInput;
import github.com.rosivaldolucas.uolhostchallenge.domain.Player;
import github.com.rosivaldolucas.uolhostchallenge.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;

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

  public void create(final CreateNewPlayerInput input) {
    final String playerCodename = this.codenameService.find(input.group());

    final Player newPlayer = Player
            .createWith(input.name(), input.email(), input.phone(), playerCodename, input.group());

    this.playerRepository.save(newPlayer);
  }

}
