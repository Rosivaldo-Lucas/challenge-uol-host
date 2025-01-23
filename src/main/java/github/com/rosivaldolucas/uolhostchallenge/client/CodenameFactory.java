package github.com.rosivaldolucas.uolhostchallenge.client;

import github.com.rosivaldolucas.uolhostchallenge.client.impl.CodenameAvengersClient;
import github.com.rosivaldolucas.uolhostchallenge.client.impl.CodenameJusticeLeagueClient;
import github.com.rosivaldolucas.uolhostchallenge.enums.CodenameGroup;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CodenameFactory {

    private final Map<String, CodenameClient> codenameClients = new HashMap<>();

    public CodenameFactory(CodenameAvengersClient codenameAvengersClient, CodenameJusticeLeagueClient codenameJusticeLeagueClient) {
        this.codenameClients.put(CodenameGroup.AVENGERS.name(), codenameAvengersClient);
        this.codenameClients.put(CodenameGroup.JUSTICE_LEAGUE.name(), codenameJusticeLeagueClient);
    }

    public CodenameClient getCodenameClient(String codename) {
        return codenameClients.get(codename);
    }

}
