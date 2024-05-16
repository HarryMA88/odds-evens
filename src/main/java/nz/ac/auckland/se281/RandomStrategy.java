package nz.ac.auckland.se281;

/** Strategy class for random strategy design pattern. */
public class RandomStrategy implements Strategy {
  private int fingers;

  @Override
  public void execute() {
    fingers = Utils.getRandomNumberRange(0, 5);
  }

  @Override
  public int getFingers() {
    return this.fingers;
  }
}
