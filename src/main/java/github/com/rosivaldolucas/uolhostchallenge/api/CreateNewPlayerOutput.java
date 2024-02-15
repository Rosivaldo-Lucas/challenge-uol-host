package github.com.rosivaldolucas.uolhostchallenge.api;

import github.com.rosivaldolucas.uolhostchallenge.domain.entity.Player;
import github.com.rosivaldolucas.uolhostchallenge.domain.enums.Group;

public record CreateNewPlayerOutput(
        String id,
        String name,
        String email,
        String phone,
        String codinome,
        Group group
) {

  public static CreateNewPlayerOutput create(final Player player) {
    return new CreateNewPlayerOutput(
            player.getId(), player.getName(), player.getEmail(),
            player.getPhone(), player.getCodename().getCodename(), player.getCodename().getGroup()
    );
  }

}
