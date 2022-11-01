package onboarding.problem06.infra.exception;

public class EmailFormatException extends IllegalArgumentException {

  public EmailFormatException() {
  }

  public EmailFormatException(String s) {
    super(s);
  }
}
