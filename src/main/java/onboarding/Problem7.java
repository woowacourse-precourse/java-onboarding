package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem7 {

  private final static FriendShip friendShip = new FriendShip();
  private final static Recommendation recommendation = new Recommendation();

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    friendShip.createFriendShip(friends);
    return recommendation.recommendUsers(friendShip.createRecommendedScore(user, visitors), user);
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
    private final Map<String, Integer> recommendedScore;

    public FriendShip() {
      friendShip = new HashMap<>();
      recommendedScore = new HashMap<>();
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

    public Map<String, Integer> createRecommendedScore(String user, List<String> visitors) {
      for (String other : friendShip.keySet()) {
        relatedFriends(user, other);
      }

      for (String visitor : visitors) {
        addVisitedScore(user, visitor);
      }

      return recommendedScore;
    }

    private void relatedFriends(String user, String other) {
      Set<String> userFriends = friendShip.get(user);
      for (String friend : friendShip.get(other)) {
        addRelatedScore(other, userFriends, friend);
      }
    }

    private void addRelatedScore(String other, Set<String> userFriends, String friend) {
      if (!userFriends.contains(other) && userFriends.contains(friend)) {
        recommendedScore.put(other,
            recommendedScore.getOrDefault(other, 0) + Point.RELATED_POINT.getPoint());
      }
    }

    private void addVisitedScore(String user, String visitor) {
      Set<String> userFriends = friendShip.get(user);
      if (!userFriends.contains(visitor)) {
        recommendedScore.put(visitor,
            recommendedScore.getOrDefault(visitor, 0) + Point.VISIT_POINT.getPoint());
      }
    }

  }

  static class Recommendation {

    public List<String> recommendUsers(Map<String, Integer> recommendedScore, String user) {
      return recommendedScore.entrySet().stream()
          .filter(entry -> !entry.getKey().equals(user) && entry.getValue() != 0)
          .sorted(Map.Entry.<String, Integer>comparingByValue(Collections.reverseOrder())
              .thenComparing(Entry::getKey))
          .limit(5)
          .map(Map.Entry::getKey)
          .collect(Collectors.toList());
    }
  }

}
