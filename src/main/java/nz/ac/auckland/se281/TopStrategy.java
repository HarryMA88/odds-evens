package nz.ac.auckland.se281;

import java.util.List;
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
    } else if (evenNos == oddNos) {
      noPreference = true;
    } else {
      opponentFavoursOdd = true;
    }
  }

  @Override
  public int getFingers() {
    return this.fingers;
  }
}
