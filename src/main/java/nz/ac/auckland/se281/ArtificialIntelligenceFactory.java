package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class ArtificialIntelligenceFactory {

  /**
   * factory method to create an instance of the AI.
   * 
   * @param difficulty difficulty for the AI
   * @return an instance of the AI
   */
  public static ArtificialIntelligence creatArtificialIntelligence(Difficulty difficulty) {
    // choose type of AI to return
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
