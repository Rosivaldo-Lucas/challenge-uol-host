package github.com.rosivaldolucas.uolhostchallenge.infra;

import github.com.rosivaldolucas.uolhostchallenge.domain.Player;
import github.com.rosivaldolucas.uolhostchallenge.domain.repository.PlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class PlayerInMemoryRepository implements PlayerRepository {

  private final Set<Player> players = new HashSet<>();

  @Override
  public Set<Player> findAll() {
    return this.players;
  }

  @Override
  public void save(final Player player) {
    this.players.add(player);
  }

}
