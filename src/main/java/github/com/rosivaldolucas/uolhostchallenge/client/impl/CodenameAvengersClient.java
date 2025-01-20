package github.com.rosivaldolucas.uolhostchallenge.client.impl;

import github.com.rosivaldolucas.uolhostchallenge.client.CodenameClient;
import github.com.rosivaldolucas.uolhostchallenge.client.CodenameDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CodenameAvengersClient implements CodenameClient {

    private final RestTemplate restTemplate;

    public CodenameAvengersClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CodenameDTO> findAll() {
        String url = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";

        AvengersDTO response = this.restTemplate
                .getForObject(url, AvengersDTO.class);

        return response != null ? response.getVingadores() : List.of();
    }

    private static class AvengersDTO {
        private List<CodenameDTO> vingadores;

        public List<CodenameDTO> getVingadores() {
            return vingadores;
        }
    }

}
