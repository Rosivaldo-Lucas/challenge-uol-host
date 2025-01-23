package github.com.rosivaldolucas.uolhostchallenge.entity;

import github.com.rosivaldolucas.uolhostchallenge.enums.CodenameGroup;

import java.io.Serializable;
import java.util.UUID;

public class Player implements Serializable {

    private final UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private String codename;
    private CodenameGroup codenameGroup;

    public Player(UUID id, String name, String email, String phoneNumber, String codename, CodenameGroup codenameGroup) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.codename = codename;
        this.codenameGroup = codenameGroup;
    }

    public Player(String name, String email, String phoneNumber, String codename, CodenameGroup codenameGroup) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.codename = codename;
        this.codenameGroup = codenameGroup;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s;%s", id.toString(), name, email, phoneNumber, codename, codenameGroup.toString());
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCodename() {
        return codename;
    }

    public CodenameGroup getCodenameGroup() {
        return codenameGroup;
    }
}
