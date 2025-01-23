package github.com.rosivaldolucas.uolhostchallenge.repository;

import github.com.rosivaldolucas.uolhostchallenge.entity.Player;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Profile("test")
@Repository
public class PlayerRepositoryInMemory implements PlayerRepository {

    private final List<Player> players = new ArrayList<>();

    @Override
    public List<Player> findAll() {
        return this.players;
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

}
