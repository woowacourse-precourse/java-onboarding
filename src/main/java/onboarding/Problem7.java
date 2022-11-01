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

  private static Map<String, Integer> scoreMap;
  private static Set<String> myFriends;

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    myFriends = new HashSet<>();
    scoreMap = new HashMap<>();
    initMyFriends(user, friends);
    initOthers(friends, visitors);
    setScore(friends, visitors);
    return getAnswer();
  }

  private static void initMyFriends(String user, List<List<String>> friends) {
    myFriends.add(user);
    for (List<String> friend : friends) {
      if (user.equals(friend.get(0))) {
        myFriends.add(friend.get(1));
        continue;
      }
      if (user.equals(friend.get(1))) {
        myFriends.add(friend.get(0));
      }
    }
  }

  private static void initOthers(List<List<String>> friends, List<String> visitors) {
    for (List<String> friend : friends) {
      String person1 = friend.get(0);
      String person2 = friend.get(1);
      addOtherPeople(person1);
      addOtherPeople(person2);
    }
    for (String visitor : visitors) {
      addOtherPeople(visitor);
    }
  }

  private static void addOtherPeople(String person) {
    if (!myFriends.contains(person) && !scoreMap.containsKey(person)) {
      scoreMap.put(person, 0);
    }
  }

  private static void setScore(List<List<String>> friends, List<String> visitors) {
    setScoreWithFriendsOfFriends(friends);
    setScoreWithVisitors(visitors);
  }

  private static void setScoreWithFriendsOfFriends(List<List<String>> friends) {
    for (List<String> friend : friends) {
      String friend1 = friend.get(0);
      String friend2 = friend.get(1);

      if (myFriends.contains(friend1) && scoreMap.containsKey(friend2)) {
        scoreMap.put(friend2, scoreMap.get(friend2) + 10);
      }
      if (myFriends.contains(friend2) && scoreMap.containsKey(friend1)) {
        scoreMap.put(friend1, scoreMap.get(friend1) + 10);
      }
    }
  }

  private static void setScoreWithVisitors(List<String> visitors) {
    for (String visitor : visitors) {
      if (scoreMap.containsKey(visitor)) {
        scoreMap.put(visitor, scoreMap.get(visitor) + 1);
      }
    }
  }

  private static List<String> getAnswer() {
    return scoreMap.entrySet()
        .stream()
        .filter(entry -> entry.getValue() != 0)
        .sorted(Entry.<String, Integer>comparingByValue(Collections.reverseOrder())
            .thenComparing(Entry::getKey))
        .limit(5)
        .map(Entry::getKey)
        .collect(Collectors.toList());
  }
}
