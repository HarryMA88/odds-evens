package nz.ac.auckland.se281;

public abstract class ArtificialIntelligence {
  private String name = "HAL-9000";
  protected Strategy strategy = new RandomStrategy();

  public String getName() {
    return this.name;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public abstract void play();

}
