package nz.ac.auckland.se281;

import java.util.List;
import java.util.ArrayList;

public class TopStrategy implements Strategy {
  private int fingers;
  private ArtificialIntelligence ai;
  private List<Integer> opponentFingerHistory;

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
    opponentFingerHistory = ai.getOpponenetFingers();
  }

  @Override
  public int getFingers() {
    return this.fingers;
  }
}
