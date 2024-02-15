package github.com.rosivaldolucas.uolhostchallenge.domain.entity;

import java.util.UUID;

public class Player {

  private String id;
  private String name;
  private String email;
  private String phone;
  private Codename codename;

  private Player(final String name, final String email, final String phone, final Codename codename) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.codename = codename;
  }

  public static Player createWith(final String name, final String email, final String phone, final Codename codename) {
    return new Player(name, email, phone, codename);
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

  public Codename getCodename() {
    return codename;
  }

}
