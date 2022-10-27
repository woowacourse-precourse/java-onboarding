package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
  static final int FRIEND_SCORE = 10;
  static final int VISIT_SCORE = 1;

  public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
    List<String> friendsByUser = findFriendsByUser(user, friends);
    List<String> friendOfFriend = findFriends(friendsByUser, friends);
    List<String> userFriendOfFriend = exceptDuplicateNameAndUserOfFriends(user, friendOfFriend);

    Map<String, Integer> record = new HashMap<>();
    setFriendScore(record, userFriendOfFriend);

    return List.of("");
  }

  public static List<String> exceptDuplicateNameAndUserOfFriends(String user, List<String> friends) {
    return friends.stream().distinct().filter((name) -> name != user).collect(Collectors.toList());
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

  public static List<String> findFriends(List<String> users, List<List<String>> friends) {
    List<String> result = new ArrayList<>();
    for (String user : users) {
      List<String> userFriends = findFriendsByUser(user, friends);
      result.addAll(userFriends);
    }
    return result;
  }

  public static void setFriendScore(Map<String, Integer> record, List<String> friends) {
    for (String friend : friends) {
      if (record.containsKey(friend)) {
        record.put(friend, record.get(friend) + FRIEND_SCORE);
        continue;
      }
      record.put(friend, FRIEND_SCORE);
    }
  }
}
