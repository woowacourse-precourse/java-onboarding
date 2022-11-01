package onboarding.problem07.infra.exception;

public class FriendSizeWrongException extends IllegalArgumentException {

  public FriendSizeWrongException() {
  }

  public FriendSizeWrongException(String s) {
    super(s);
  }
}
