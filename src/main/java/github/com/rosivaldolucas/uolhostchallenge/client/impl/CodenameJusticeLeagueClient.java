package github.com.rosivaldolucas.uolhostchallenge.client.impl;

import github.com.rosivaldolucas.uolhostchallenge.client.CodenameClient;
import github.com.rosivaldolucas.uolhostchallenge.client.CodenameDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CodenameJusticeLeagueClient implements CodenameClient {

    private final RestTemplate restTemplate;

    public CodenameJusticeLeagueClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CodenameDTO> findAll() {
        return List.of();
    }

}
