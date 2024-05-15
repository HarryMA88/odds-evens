package nz.ac.auckland.se281;

import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  private int fingers;
  private ArtificialIntelligence ai;
  private List<Integer> opponentFingerHistory;
  private boolean opponentFavoursEven = false;
  private boolean opponentFavoursOdd = false;
  private boolean noPreference = false;

  /**
   * constructor for the topstrategy strategy.
   *
   * @param ai the ai using the strategy
   */
  public TopStrategy(ArtificialIntelligence ai) {
    this.ai = ai;
  }

  @Override
  public void execute() {
    fingers = -1;
    // load in the memory of the opponents finger histroy
    opponentFingerHistory = ai.getOpponentFingers();
    // check what type of numbers the opponent favours
    int evenNos = 0;
    int oddNos = 0;
    for (Integer opponentFingers : opponentFingerHistory) {
      // if the finger is even increase even count, if it is odd increase odd count
      if (Utils.isEven(opponentFingers)) {
        evenNos++;
      } else {
        oddNos++;
      }
    }
    if (evenNos > oddNos) {
      opponentFavoursEven = true;
      opponentFavoursOdd = false;
      noPreference = false;
    } else if (evenNos == oddNos) {
      noPreference = true;
      opponentFavoursEven = false;
      opponentFavoursOdd = false;
    } else {
      opponentFavoursOdd = true;
      opponentFavoursEven = false;
      noPreference = false;
    }
    // choose type of number based on win objective
    Choice sabotage = ai.getSabotage();
    // if there is no trend in opponents fingers, choose a random number
    if (noPreference == true) {
      fingers = Utils.getRandomNumberRange(0, 5);
      return;
    }
    // choose fingers based on how to sabotage player's win
    fingers = chooseFingers(sabotage);
  }

  /**
   * chooses the number of fingers based on the opponent's trend.
   * 
   * @param objective the opposite of what the AI needs to make the sum to win
   * @return the number of fingers the AI choose
   */
  public int chooseFingers(Choice objective) {
    if (objective == Main.Choice.EVEN) {
      if (opponentFavoursEven) {
        return Utils.getRandomOddNumber();
      } else if (opponentFavoursOdd) {
        return Utils.getRandomEvenNumber();
      }
    }
    return -1;
  }

  @Override
  public int getFingers() {
    return this.fingers;
  }
}
