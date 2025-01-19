package github.com.rosivaldolucas.uolhostchallenge.service;

import github.com.rosivaldolucas.uolhostchallenge.dto.CreatePlayerDTO;
import github.com.rosivaldolucas.uolhostchallenge.entity.Player;
import github.com.rosivaldolucas.uolhostchallenge.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public void create(CreatePlayerDTO createPlayerDTO) {
        this.playerRepository
                .findByEmail(createPlayerDTO.email())
                .ifPresent((player -> {
                    throw new RuntimeException("This player already exists");
                }));

        Player player = new Player(createPlayerDTO.name(), createPlayerDTO.email(), createPlayerDTO.phoneNumber(), null, null);

        this.playerRepository.save(player);
    }

}
