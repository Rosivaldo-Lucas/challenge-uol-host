package github.com.rosivaldolucas.uolhostchallenge.service;

import github.com.rosivaldolucas.uolhostchallenge.client.CodenameClient;
import github.com.rosivaldolucas.uolhostchallenge.client.CodenameDTO;
import github.com.rosivaldolucas.uolhostchallenge.client.CodenameFactory;
import github.com.rosivaldolucas.uolhostchallenge.dto.CreatePlayerDTO;
import github.com.rosivaldolucas.uolhostchallenge.entity.Player;
import github.com.rosivaldolucas.uolhostchallenge.enums.CodenameGroup;
import github.com.rosivaldolucas.uolhostchallenge.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final CodenameFactory codenameFactory;

    public PlayerService(PlayerRepository playerRepository, CodenameFactory codenameFactory) {
        this.playerRepository = playerRepository;
        this.codenameFactory = codenameFactory;
    }

    public void create(CreatePlayerDTO createPlayerDTO) {
        this.playerRepository
                .findByEmail(createPlayerDTO.email())
                .ifPresent((player -> {
                    throw new RuntimeException("This player already exists");
                }));

        CodenameDTO selectedCodename = this.getCodename(createPlayerDTO.codenameGroup());

        Player player = new Player(
                createPlayerDTO.name(), createPlayerDTO.email(), createPlayerDTO.phoneNumber(),
                selectedCodename.codename(), createPlayerDTO.codenameGroup()
        );

        this.playerRepository.save(player);
    }

    private CodenameDTO getCodename(CodenameGroup codenameGroup) {
        CodenameClient codenameClient = this.codenameFactory.getCodenameClient(codenameGroup.name());
        List<CodenameDTO> codenameListDTO = codenameClient.findAll();

        Set<String> usedCodenames = this.playerRepository.findAll()
                .stream()
                .map(Player::getCodename)
                .collect(Collectors.toSet());

        return codenameListDTO
                .stream()
                .filter(codenameDTO -> !usedCodenames.contains(codenameDTO.codename()))
                .findFirst()
                .orElseThrow();
    }

}
