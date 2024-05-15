package nz.ac.auckland.se281;

import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

import java.util.ArrayList;

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
    Choice objective = ai.getObjective();
    if (noPreference == true) {
      fingers = Utils.getRandomNumberRange(0, 5);
      return;
    }
  }

  public int chooseFingers(Choice objective) {
    return -1;
  }

  @Override
  public int getFingers() {
    return this.fingers;
  }
}
