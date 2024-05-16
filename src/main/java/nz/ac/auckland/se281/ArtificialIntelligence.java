package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;
import nz.ac.auckland.se281.Main.Choice;

/** Abstract class for the AI. */
public abstract class ArtificialIntelligence {
  private String name = "HAL-9000";
  protected Strategy strategy = new RandomStrategy();
  protected int fingers;
  protected List<Integer> opponentFingerHistory = new ArrayList<Integer>();
  protected Choice sabotage;
  protected boolean wonPreviousRound;

  /**
   * constructor for Artificial Intelligence.
   *
   * @param choice the players choice (opposite of what AI needs to win)
   */
  public ArtificialIntelligence(Choice choice) {
    this.sabotage = choice;
  }

  /**
   * getter for AI's name.
   *
   * @return name of the AI
   */
  public String getName() {
    return this.name;
  }

  /**
   * setter for AI's strategy.
   *
   * @param strategy strategy to set
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * getter for AI's fingers.
   *
   * @return the amount of fingers the AI chose for this round
   */
  public int getFingers() {
    return this.fingers;
  }

  /**
   * adds the opponents fingers choice to the AI's memory.
   *
   * @param fingers the number of fingers the opponent chose
   */
  public void addFingers(int fingers) {
    opponentFingerHistory.add(fingers);
  }

  public List<Integer> getOpponentFingers() {
    return this.opponentFingerHistory;
  }

  public Choice getSabotage() {
    return this.sabotage;
  }

  public void setWonPreviousRound(boolean wonPreviousRound) {
    this.wonPreviousRound = wonPreviousRound;
  }

  /** function to let the AI play a round. */
  public abstract void play();
}
