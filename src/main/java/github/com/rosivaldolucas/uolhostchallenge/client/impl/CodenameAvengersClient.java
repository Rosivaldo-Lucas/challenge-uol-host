package github.com.rosivaldolucas.uolhostchallenge.client.impl;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import github.com.rosivaldolucas.uolhostchallenge.client.CodenameClient;
import github.com.rosivaldolucas.uolhostchallenge.client.CodenameDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CodenameAvengersClient implements CodenameClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public CodenameAvengersClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public List<CodenameDTO> findAll() {
        String url = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";

        try {
            String response = this.restTemplate.getForObject(url, String.class);

            AvendersDTO avendersDTO = this.objectMapper.readValue(response, AvendersDTO.class);

            return avendersDTO.averngers.stream().map(avenger -> new CodenameDTO(avenger.codename)).toList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private record AvendersDTO(
            @JsonAlias("vingadores")
            List<Codename> averngers
    ) { }

    private record Codename(
            @JsonAlias("codinome")
            String codename
    ) { }

}
