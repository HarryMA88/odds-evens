package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Class for hard difficulty AI. */
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
        } else if (strategy instanceof TopStrategy) {
          setStrategy(new RandomStrategy());
        }
      }
    }
    strategy.execute();
    fingers = strategy.getFingers();
  }
}
