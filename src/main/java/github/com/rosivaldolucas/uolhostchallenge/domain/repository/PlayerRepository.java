package github.com.rosivaldolucas.uolhostchallenge.domain.repository;

import github.com.rosivaldolucas.uolhostchallenge.domain.entity.Player;

import java.util.Optional;
import java.util.Set;

public interface PlayerRepository {

  Set<Player> findAll();

  Optional<Player> findByCodename(final String codename);

  void save(final Player player);

}
