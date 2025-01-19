package github.com.rosivaldolucas.uolhostchallenge.entity;

import github.com.rosivaldolucas.uolhostchallenge.enums.CodenameGroup;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Player {

    private final UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private String codename;
    private CodenameGroup codenameGroup;

    public Player(String name, String email, String phoneNumber, String codename, CodenameGroup codenameGroup) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.codename = codename;
        this.codenameGroup = codenameGroup;
    }

}
