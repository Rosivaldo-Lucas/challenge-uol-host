package github.com.rosivaldolucas.uolhostchallenge.api;

import github.com.rosivaldolucas.uolhostchallenge.domain.Player;
import github.com.rosivaldolucas.uolhostchallenge.domain.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {

  private final PlayerService playerService;

  public PlayerController(final PlayerService playerService) {
    this.playerService = playerService;
  }

  @GetMapping
  public ResponseEntity<Set<CreateNewPlayerOutput>> findAll() {
    final Set<Player> players = this.playerService.findAll();

    final Set<CreateNewPlayerOutput> output = players.stream()
            .map(CreateNewPlayerOutput::create)
            .collect(Collectors.toSet());

    return ResponseEntity.status(HttpStatus.CREATED).body(output);
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody final CreateNewPlayerInput input) {
    this.playerService.create(input);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
