package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 0;
  private String name;
  private ArtificialIntelligence ai;
  private Choice choice;

  /**
   * starts a new game with chosen difficulty and win condition.
   * 
   * @param difficulty difficulty for AI
   * @param choice whether the player wants to be ODD or EVEN
   * @param options player name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    ai = ArtificialIntelligenceFactory.creatArtificialIntelligence(difficulty);
    this.choice = choice;
  }

  /**
   * starts a new round within the game.
   */
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
    // lets ai play and prints info hand for both human and ai
    MessageCli.PRINT_INFO_HAND.printMessage(name, String.valueOf(fingers));
    ai.play();
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getName(), String.valueOf(ai.getFingers()));
    // print outcome for the round
    int sum = fingers + ai.getFingers();
    if (choice == Main.Choice.EVEN) {
      if (Utils.isEven(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), choice.toString(), name);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", ai.getName());
      }
    } else {
      if (Utils.isOdd(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), choice.toString(), name);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", ai.getName());
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
