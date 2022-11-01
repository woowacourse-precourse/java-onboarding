package onboarding.problem7;

import java.util.List;

public class FriendValidator {
  private static final int MAX_FRIENDS_SIZE = 10000;
  private static final int MIM_FRIENDS_SIZE = 1;

  public static void validate(List<List<String>> friends) {
    isFriendsSize(friends);
    validateFriendsId(friends);
  }

  private static void isFriendsSize(List<List<String>> friends) {
    if ((friends.size() < MIM_FRIENDS_SIZE) || (friends.size() > MAX_FRIENDS_SIZE)) {
      throw new IllegalArgumentException("friends 길이 범위 초과 1 이상 10,000 이하");
    }
  }

  private static void validateFriendsId(List<List<String>> friends) {
    for (List<String> friend : friends) {
      String userA = friend.get(0);
      String userB = friend.get(1);
      validateFriendId(userA);
      validateFriendId(userB);
    }
  }

  private static void validateFriendId(String friendId) {
    if (!IDValidator.isLowerCaseId(friendId)) {
      throw new IllegalArgumentException("friend ID는 소문자로 구성");
    }
    if (!IDValidator.isIdLengthInRange(friendId)) {
      throw new IllegalArgumentException("friend ID 범위 초과 길이는 1이상 30이하");
    }
  }
}
