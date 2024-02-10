package github.com.rosivaldolucas.uolhostchallenge.domain;

import github.com.rosivaldolucas.uolhostchallenge.domain.enums.Group;

import java.util.UUID;

public class Player {

  private String id;
  private String name;
  private String email;
  private String phone;
  private String codinome;
  private Group group;

  private Player(final String name, final String email, final String phone, final String codinome, final Group group) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.codinome = codinome;
    this.group = group;
  }

  public static Player createWith(final String name, final String email, final String phone, final String codinome, final Group group) {
    return new Player(name, email, phone, codinome, group);
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getCodinome() {
    return codinome;
  }

  public Group getGroup() {
    return group;
  }

}
