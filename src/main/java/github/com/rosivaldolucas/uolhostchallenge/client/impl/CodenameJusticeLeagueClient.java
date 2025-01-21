package github.com.rosivaldolucas.uolhostchallenge.client.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import github.com.rosivaldolucas.uolhostchallenge.client.CodenameClient;
import github.com.rosivaldolucas.uolhostchallenge.client.CodenameDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CodenameJusticeLeagueClient implements CodenameClient {

    private final RestTemplate restTemplate;
    private final XmlMapper xmlMapper;

    public CodenameJusticeLeagueClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.xmlMapper = new XmlMapper();
    }

    @Override
    public List<CodenameDTO> findAll() {
        String url = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";

        try {
            String response = this.restTemplate.getForObject(url, String.class);

            JusticeLeagueDTO justiceLeagueDTO = this.xmlMapper.readValue(response, JusticeLeagueDTO.class);

            return justiceLeagueDTO.codinomes.codinomes.stream().map(CodenameDTO::new).toList();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @JacksonXmlRootElement(localName = "lida_da_justica")
    private record JusticeLeagueDTO(
            @JacksonXmlProperty(localName = "codinomes")
            Codinomes codinomes
    ) { }

    @JacksonXmlRootElement(localName = "codinomes")
    private record Codinomes(
            @JacksonXmlProperty(localName = "codinome")
            @JacksonXmlElementWrapper(useWrapping = false)
            List<String> codinomes
    ) { }

}
