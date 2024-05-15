package nz.ac.auckland.se281;

public interface Strategy {
  /**
   * implementation of the chosen strategy.
   */
  public void execute();
  
  /**
   * getter for fingers chosen by strategy.
   * 
   * @return fingers chosen by strategy
   */
  public int getFingers();
}
