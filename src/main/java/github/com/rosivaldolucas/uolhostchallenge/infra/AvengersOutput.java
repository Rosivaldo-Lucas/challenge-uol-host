package github.com.rosivaldolucas.uolhostchallenge.infra;

import java.util.List;

public class AvengersOutput {

  private List<Avenger> vingadores;

  public List<Avenger> getVingadores() {
    return vingadores;
  }

  public void setVingadores(List<Avenger> vingadores) {
    this.vingadores = vingadores;
  }

  public static class Avenger {
    private String codinome;

    public String getCodinome() {
      return codinome;
    }

    public void setCodinome(String codinome) {
      this.codinome = codinome;
    }
  }

}
