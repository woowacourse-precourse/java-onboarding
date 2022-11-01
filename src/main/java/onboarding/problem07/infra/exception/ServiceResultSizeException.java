package onboarding.problem07.infra.exception;

public class ServiceResultSizeException extends IllegalArgumentException {

  public ServiceResultSizeException() {
  }

  public ServiceResultSizeException(String s) {
    super(s);
  }
}
