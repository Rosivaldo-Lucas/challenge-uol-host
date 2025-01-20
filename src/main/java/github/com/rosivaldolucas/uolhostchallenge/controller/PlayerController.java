package github.com.rosivaldolucas.uolhostchallenge.controller;

import github.com.rosivaldolucas.uolhostchallenge.dto.CreatePlayerDTO;
import github.com.rosivaldolucas.uolhostchallenge.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreatePlayerDTO createPlayerDTO) {
        this.playerService.create(createPlayerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
