package onboarding.problem06.infra.exception;

public class NickNameNotKoreanException extends IllegalArgumentException {

  public NickNameNotKoreanException() {
  }

  public NickNameNotKoreanException(String s) {
    super(s);
  }
}
