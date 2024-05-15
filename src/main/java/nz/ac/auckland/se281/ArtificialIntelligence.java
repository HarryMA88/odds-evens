package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.Main.Choice;

public abstract class ArtificialIntelligence {
  private String name = "HAL-9000";
  protected Strategy strategy = new RandomStrategy();
  protected int fingers;
  protected List<Integer> opponentFingerHistory = new ArrayList<Integer>();
  protected Choice objective;

  public ArtificialIntelligence(Choice choice) {
    this.objective = choice;
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

  public List<Integer> getOpponenetFingers() {
    return this.opponentFingerHistory;
  }

  /**
   * function to let the AI play a round.
   */
  public abstract void play();

}
