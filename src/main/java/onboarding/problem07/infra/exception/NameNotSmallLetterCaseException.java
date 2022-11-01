package onboarding.problem07.infra.exception;

public class NameNotSmallLetterCaseException extends IllegalArgumentException {

  public NameNotSmallLetterCaseException() {
  }

  public NameNotSmallLetterCaseException(String s) {
    super(s);
  }
}
