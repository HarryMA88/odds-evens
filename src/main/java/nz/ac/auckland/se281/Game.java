package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 0;
  private String name;
  private ArtificialIntelligence ai;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    ai = ArtificialIntelligenceFactory.creatArtificialIntelligence(difficulty);
  }

  public void play() {
    // display round and ask for input
    round++;
    MessageCli.START_ROUND.printMessage(String.valueOf(round));
    MessageCli.ASK_INPUT.printMessage();

    // get input until it is valid
    boolean validInput = false;
    String input = null;
    int fingers = -1;
    while (!validInput) {
      input = Utils.scanner.nextLine();
      // check if the input is a number
      if (!Utils.isInteger(input)) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      // check if the input is in the range of the choices
      fingers = Integer.parseInt(input);
      if (fingers < 0 || fingers > 5) {
        MessageCli.INVALID_INPUT.printMessage();
        continue;
      }
      validInput = true;
    }
    MessageCli.PRINT_INFO_HAND.printMessage(name, String.valueOf(fingers));
  }

  public void endGame() {}

  public void showStats() {}
}
