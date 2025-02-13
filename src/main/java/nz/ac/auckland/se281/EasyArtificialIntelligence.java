package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** Class for easy difficulty AI. */
public class EasyArtificialIntelligence extends ArtificialIntelligence {
  public EasyArtificialIntelligence(Choice choice) {
    super(choice);
  }

  @Override
  public void play() {
    strategy.execute();
    fingers = strategy.getFingers();
  }
}
