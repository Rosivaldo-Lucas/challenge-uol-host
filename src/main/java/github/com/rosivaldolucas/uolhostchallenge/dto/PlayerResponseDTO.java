package github.com.rosivaldolucas.uolhostchallenge.dto;

import github.com.rosivaldolucas.uolhostchallenge.enums.CodenameGroup;

import java.util.UUID;

public record PlayerResponseDTO(
        UUID id,
        String name,
        String email,
        String phoneNumber,
        String codename,
        CodenameGroup codenameGroup
) {
}
