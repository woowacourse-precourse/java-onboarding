package onboarding.problem07.infra.exception;

public class VisitorLengthException extends IllegalArgumentException {

  public VisitorLengthException() {
  }

  public VisitorLengthException(String s) {
    super(s);
  }
}
