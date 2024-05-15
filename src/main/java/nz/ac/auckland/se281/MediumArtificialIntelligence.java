package nz.ac.auckland.se281;

public class MediumArtificialIntelligence extends ArtificialIntelligence {
  @Override
  public void play() {
    strategy.execute();
    fingers = strategy.getFingers();
  }
}
