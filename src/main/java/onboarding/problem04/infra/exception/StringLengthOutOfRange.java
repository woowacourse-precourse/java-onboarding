package onboarding.problem04.infra.exception;

public class StringLengthOutOfRange extends IndexOutOfBoundsException {

  public StringLengthOutOfRange() {
  }

  public StringLengthOutOfRange(String s) {
    super(s);
  }
}
