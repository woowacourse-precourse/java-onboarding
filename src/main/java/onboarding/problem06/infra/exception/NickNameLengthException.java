package onboarding.problem06.infra.exception;

public class NickNameLengthException extends IllegalArgumentException {

  public NickNameLengthException() {
  }

  public NickNameLengthException(String s) {
    super(s);
  }
}
