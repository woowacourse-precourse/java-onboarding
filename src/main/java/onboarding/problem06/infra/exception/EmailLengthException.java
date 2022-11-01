package onboarding.problem06.infra.exception;

public class EmailLengthException extends IllegalArgumentException {

  public EmailLengthException() {
  }

  public EmailLengthException(String s) {
    super(s);
  }
}
