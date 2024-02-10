package github.com.rosivaldolucas.uolhostchallenge.api;

import github.com.rosivaldolucas.uolhostchallenge.domain.enums.Group;

public record CreateNewPlayerInput(
        String name,
        String email,
        String phone,
        Group group
) {
}
