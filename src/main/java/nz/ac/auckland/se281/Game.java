package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
  }

  public void play() {
    round++;
    MessageCli.START_ROUND.printMessage(String.valueOf(round));
    MessageCli.ASK_INPUT.printMessage();
    String input = Utils.scanner.nextLine();
    // check if the input is a number
    if (!Utils.isInteger(input)) {
      MessageCli.INVALID_INPUT.printMessage();
      return;
    }
    
  }

  public void endGame() {}

  public void showStats() {}
}
