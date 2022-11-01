package onboarding.problem07.infra.exception;

public class FriendListEmptyException extends IllegalArgumentException {

  public FriendListEmptyException() {
  }

  public FriendListEmptyException(String s) {
    super(s);
  }
}
