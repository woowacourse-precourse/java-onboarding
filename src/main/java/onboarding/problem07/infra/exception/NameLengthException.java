package onboarding.problem07.infra.exception;

public class NameLengthException extends IllegalArgumentException {

  public NameLengthException() {
  }

  public NameLengthException(String s) {
    super(s);
  }
}
