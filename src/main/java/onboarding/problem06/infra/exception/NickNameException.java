package onboarding.problem06.infra.exception;

public class NickNameException extends IllegalArgumentException {

  public NickNameException() {
  }

  public NickNameException(String s) {
    super(s);
  }
}
