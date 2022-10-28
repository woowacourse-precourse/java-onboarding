package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    List<String> answer = Collections.emptyList();
    return answer;
  }

  enum Point {
    RELATED_POINT(10), VISIT_POINT(1);

    Point(int point) {
      this.point = point;
    }

    private final int point;

    public int getPoint() {
      return point;
    }
  }

  static class FriendShip {

    private final Map<String, Set<String>> friendShip;
    private final Map<String, Integer> networkScore;

    public FriendShip() {
      friendShip = new HashMap<>();
      networkScore = new HashMap<>();
    }

    public Map<String, Set<String>> createFriendShip(List<List<String>> friends) {
      for (List<String> friend : friends) {
        String name1 = friend.get(0);
        String name2 = friend.get(1);
        connect(name1, name2);
        connect(name2, name1);
      }
      return friendShip;
    }

    private void connect(String user, String friend) {
      if (!friendShip.containsKey(user)) {
        friendShip.put(user, new HashSet<>());
      }
      friendShip.get(user).add(friend);
    }

    public Map<String, Integer> createNetworkScore(String user, List<String> visitors) {
      for (String other : friendShip.keySet()) {
        relatedFriends(user, other);
      }

      for (String visitor : visitors) {
        networkScore.put(visitor,
            networkScore.getOrDefault(visitor, 0) + Point.VISIT_POINT.getPoint());
      }

      return networkScore;
    }

    private void relatedFriends(String user, String other) {
      Set<String> userFriends = friendShip.get(user);
      for (String friend : friendShip.get(other)) {
        calculateScore(other, userFriends, friend);
      }
    }

    private void calculateScore(String other, Set<String> userFriends, String friend) {
      if (userFriends.contains(friend)) {
        networkScore.put(other, networkScore.getOrDefault(other, 0) + Point.RELATED_POINT.getPoint());
      }
    }

  }

}
