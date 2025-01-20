package github.com.rosivaldolucas.uolhostchallenge.repository;

import github.com.rosivaldolucas.uolhostchallenge.entity.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PlayerRepositoryInMemory implements PlayerRepository {

    private final List<Player> players = new ArrayList<>();

    @Override
    public List<Player> findAll() {
        return this.players;
    }

    @Override
    public Optional<Player> findById(UUID playerId) {
        return this.players
                .stream()
                .filter(player -> player.getId().equals(playerId))
                .findFirst();
    }

    @Override
    public Optional<Player> findByEmail(String email) {
        return this.players
                .stream()
                .filter(player -> player.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public void save(Player player) {
        this.players.add(player);
    }

    @Override
    public void update(Player player) {
    }

    @Override
    public void deleteById(UUID playerId) {
    }

}
