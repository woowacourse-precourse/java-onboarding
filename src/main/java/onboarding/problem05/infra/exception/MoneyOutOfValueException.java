package onboarding.problem05.infra.exception;

public class MoneyOutOfValueException extends IllegalArgumentException {


  public MoneyOutOfValueException() {
  }

  public MoneyOutOfValueException(String s) {
    super(s);
  }
}
