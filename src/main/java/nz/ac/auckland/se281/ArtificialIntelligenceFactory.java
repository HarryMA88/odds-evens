package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class ArtificialIntelligenceFactory {

  public static ArtificialIntelligence creatArtificialIntelligence(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyArtificialIntelligence();
      case MEDIUM:
        return new MediumArtificialIntelligence();
      case HARD:
        return new HardArtificialIntelligence();
      default:
        return null;
    }
  }
}
