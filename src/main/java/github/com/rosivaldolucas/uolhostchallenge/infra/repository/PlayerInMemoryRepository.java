package github.com.rosivaldolucas.uolhostchallenge.infra.repository;

import github.com.rosivaldolucas.uolhostchallenge.domain.entity.Player;
import github.com.rosivaldolucas.uolhostchallenge.domain.repository.PlayerRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Repository
public class PlayerInMemoryRepository implements PlayerRepository {

  private final Set<Player> players = new HashSet<>();

  @Override
  public Set<Player> findAll() {
    return this.players;
  }

  @Override
  public Optional<Player> findByCodename(final String codename) {
    return this.players.stream().filter(player -> player.getCodename().getCodename().equals(codename)).findFirst();
  }

  @Override
  public void save(final Player player) {
    this.players.add(player);
  }

}
