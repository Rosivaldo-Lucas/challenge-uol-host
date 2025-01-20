package github.com.rosivaldolucas.uolhostchallenge.controller;

import github.com.rosivaldolucas.uolhostchallenge.dto.CreatePlayerDTO;
import github.com.rosivaldolucas.uolhostchallenge.dto.PlayerResponseDTO;
import github.com.rosivaldolucas.uolhostchallenge.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerResponseDTO>> list() {
        List<PlayerResponseDTO> playerList = this.playerService.list();
        return ResponseEntity.status(HttpStatus.OK).body(playerList);
    }

    @PostMapping
    public ResponseEntity<PlayerResponseDTO> create(@RequestBody CreatePlayerDTO createPlayerDTO) {
        PlayerResponseDTO playerResponseDTO = this.playerService.create(createPlayerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(playerResponseDTO);
    }

}
