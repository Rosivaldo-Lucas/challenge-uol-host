package github.com.rosivaldolucas.uolhostchallenge.domain.repository;

import github.com.rosivaldolucas.uolhostchallenge.domain.Player;

import java.util.Set;

public interface PlayerRepository {

  Set<Player> findAll();
  void save(final Player player);

}
