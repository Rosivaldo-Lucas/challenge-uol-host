package github.com.rosivaldolucas.uolhostchallenge.client;

import com.fasterxml.jackson.annotation.JsonAlias;

public record CodenameDTO(
        @JsonAlias("codinome")
        String codename
) {
}
