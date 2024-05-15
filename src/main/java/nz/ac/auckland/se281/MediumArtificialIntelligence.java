package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class MediumArtificialIntelligence extends ArtificialIntelligence {
  private int round = 0;

  public MediumArtificialIntelligence(Choice choice) {
    super(choice);
  }

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
