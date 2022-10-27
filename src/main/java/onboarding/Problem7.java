package onboarding;

import java.util.*;

public class Problem7 {
  static final int FRIEND_SCORE = 10;
  static final int VISIT_SCORE = 1;

  public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    List<String> friendsByUser = findFriendsByUser(user, friends);
    return List.of("");
  }


  private static List<String> findFriendsByUser(String user, List<List<String>> friends) {
    List<String> userFriends = new ArrayList<>();
    for (List<String> friendList : friends) {
      if (!friendList.contains(user)) {
        continue;
      }
      String friend = friendList.stream()
              .filter(name -> name != user)
              .findFirst()
              .get();
      userFriends.add(friend);
    }
    return userFriends;
  }
}
