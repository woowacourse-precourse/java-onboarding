package onboarding.problem03.infra.exception;

public class GameNumberOutOfRange extends IllegalArgumentException {

  public GameNumberOutOfRange() {
  }

  public GameNumberOutOfRange(String s) {
    super(s);
  }
}
