package github.com.rosivaldolucas.uolhostchallenge.domain.entity;

import github.com.rosivaldolucas.uolhostchallenge.domain.enums.Group;

public class Codename {

  private String codename;
  private Group group;

  private Codename(final String codename, final Group group) {
    this.codename = codename;
    this.group = group;
  }

  public static Codename createWith(final String codename, final Group group) {
    return new Codename(codename, group);
  }

  public String getCodename() {
    return codename;
  }

  public Group getGroup() {
    return group;
  }

}
