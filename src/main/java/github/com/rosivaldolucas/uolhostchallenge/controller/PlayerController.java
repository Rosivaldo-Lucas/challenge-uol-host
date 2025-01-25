package github.com.rosivaldolucas.uolhostchallenge.controller;

import github.com.rosivaldolucas.uolhostchallenge.dto.CreatePlayerDTO;
import github.com.rosivaldolucas.uolhostchallenge.dto.PlayerResponseDTO;
import github.com.rosivaldolucas.uolhostchallenge.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public ModelAndView list() {
        List<PlayerResponseDTO> playerList = this.playerService.list();

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("players", playerList);

        return modelAndView;
    }

    @PostMapping
    public String create(CreatePlayerDTO createPlayerDTO) {
        this.playerService.create(createPlayerDTO);
        return "redirect:/players";
    }

}
