package github.com.rosivaldolucas.uolhostchallenge.dto;

import github.com.rosivaldolucas.uolhostchallenge.enums.CodenameGroup;

public record CreatePlayerDTO(
        String name,
        String email,
        String phoneNumber,
        CodenameGroup codenameGroup
) {
}
