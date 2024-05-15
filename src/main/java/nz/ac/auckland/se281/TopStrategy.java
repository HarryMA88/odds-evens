package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {
  private int fingers;
  private ArtificialIntelligence ai;

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

  }

  @Override
  public int getFingers() {
    return this.fingers;
  }
}
