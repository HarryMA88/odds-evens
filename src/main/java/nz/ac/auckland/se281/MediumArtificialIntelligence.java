package nz.ac.auckland.se281;

public class MediumArtificialIntelligence extends ArtificialIntelligence {
  private int round = 0;

  @Override
  public void play() {
    round++;
    if (round == 4) {
      setStrategy(new TopStrategy(this));
    }
    strategy.execute();
    fingers = strategy.getFingers();
  }
}
