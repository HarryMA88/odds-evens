package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** Factory design pattern to create different AI instances. */
public class ArtificialIntelligenceFactory {

  /**
   * factory method to create an instance of the AI.
   *
   * @param difficulty difficulty for the AI
   * @param choice the players choice for even or odd
   * @return an instance of the AI
   */
  public static ArtificialIntelligence createArtificialIntelligence(
      Difficulty difficulty, Choice choice) {
    // choose type of AI to return
    switch (difficulty) {
      case EASY:
        return new EasyArtificialIntelligence(choice);
      case MEDIUM:
        return new MediumArtificialIntelligence(choice);
      case HARD:
        return new HardArtificialIntelligence(choice);
      default:
        return null;
    }
  }
}
