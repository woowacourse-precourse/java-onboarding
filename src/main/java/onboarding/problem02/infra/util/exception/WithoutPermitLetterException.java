package onboarding.problem02.infra.util.exception;

public class WithoutPermitLetterException extends IllegalArgumentException {

  public WithoutPermitLetterException() {
    super();
  }

  public WithoutPermitLetterException(String s) {
    super(s);
  }
}
