package github.com.rosivaldolucas.uolhostchallenge.repository;

import github.com.rosivaldolucas.uolhostchallenge.entity.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerRepository {

    List<Player> findAll();
    Optional<Player> findById(UUID playerId);
    Optional<Player> findByEmail(String email);
    void save(Player player);
    void update(Player player);
    void deleteById(UUID playerId);

}
