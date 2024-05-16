package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = -1;
  private String name;
  private ArtificialIntelligence ai;
  private Choice choice;
  private int PlayerWins = -1;
  private int BotWins = -1;

  /**
   * starts a new game with chosen difficulty and win condition.
   *
   * @param difficulty difficulty for AI
   * @param choice whether the player wants to be ODD or EVEN
   * @param options player name
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    round = 0;
    PlayerWins = 0;
    BotWins = 0;
    name = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(name);
    ai = ArtificialIntelligenceFactory.createArtificialIntelligence(difficulty, choice);
    this.choice = choice;
  }

  /** starts a new round within the game. */
  public void play() {
    if (round == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
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
        ai.setWonPreviousRound(false);
        PlayerWins++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "ODD", ai.getName());
        ai.setWonPreviousRound(true);
        BotWins++;
      }
    } else {
      if (Utils.isOdd(sum)) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), choice.toString(), name);
        ai.setWonPreviousRound(false);
        PlayerWins++;
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(String.valueOf(sum), "EVEN", ai.getName());
        ai.setWonPreviousRound(true);
        BotWins++;
      }
    }
    // adds the players fingers to the AI's memory
    ai.addFingers(fingers);
  }

  /** ends the game and resets the game state. */
  public void endGame() {
    if (round == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    showStats();
    if (PlayerWins > BotWins) {
      MessageCli.PRINT_END_GAME.printMessage(name);
    } else if (PlayerWins < BotWins) {
      MessageCli.PRINT_END_GAME.printMessage(ai.getName());
    } 
    round = -1;
    PlayerWins = -1;
    BotWins = -1;
    ai = null;
  }

  /** shows the stats of the game. */
  public void showStats() {
    if (round == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        name, String.valueOf(PlayerWins), String.valueOf(BotWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        ai.getName(), String.valueOf(BotWins), String.valueOf(PlayerWins));
  }
}
