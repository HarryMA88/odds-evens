package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardArtificialIntelligence extends ArtificialIntelligence {
  private int round = 0;

  public HardArtificialIntelligence(Choice choice) {
    super(choice);
  }

  @Override
  public void play() {
    round++;
    // after round 3 if the ai lost the previous round switch strategy
    if (round >= 4) {
      if (wonPreviousRound == false) {
        if (strategy instanceof RandomStrategy) {
          setStrategy(new TopStrategy(this));
        }
      }
    }
    strategy.execute();
    fingers = strategy.getFingers();
  }
}
