package github.com.rosivaldolucas.uolhostchallenge.client;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CodenameClient {

    List<CodenameDTO> findAll();

}
