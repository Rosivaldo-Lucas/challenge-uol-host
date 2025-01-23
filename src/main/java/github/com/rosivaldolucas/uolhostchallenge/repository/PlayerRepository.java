package github.com.rosivaldolucas.uolhostchallenge.repository;

import github.com.rosivaldolucas.uolhostchallenge.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository {

    List<Player> findAll();
    Optional<Player> findByEmail(String email);
    void save(Player player);

}
