package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Problem7 {

  private static final Map<String, Set<String>> friendsMap = new HashMap<>();
  private static final Map<String, Integer> scoreMap = new TreeMap<>();

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    makeFriendMap(friends);
    setAcquaintancePoint(user);
    setVisitorPoint(user, visitors);

    return getAnswer();
  }

  private static List<String> getAnswer() {
    return scoreMap.entrySet()
        .stream()
        .filter(entry -> entry.getValue() != 0)
        .sorted(Map.Entry.<String, Integer>comparingByValue(Collections.reverseOrder())
            .thenComparing(Entry::getKey))
        .limit(5)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  private static void setVisitorPoint(String user, List<String> visitors) {
    for (String visitor : visitors) {
      if (friendsMap.get(user).contains(visitor)) {
        continue;
      }
      scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
    }
  }

  private static void setAcquaintancePoint(String user) {
    for (String person : friendsMap.keySet()) {
      if (person.equals(user) || friendsMap.get(user).contains(person)) {
        continue;
      }
      friendsMap.get(person).retainAll(friendsMap.get(user));
      int acquaintances = friendsMap.get(person).size();
      scoreMap.put(person, acquaintances * 10);
    }
  }

  private static void makeFriendMap(List<List<String>> friends) {
    for (List<String> friend : friends) {
      String friend1 = friend.get(0);
      String friend2 = friend.get(1);
      addFriend(friend1, friend2);
      addFriend(friend2, friend1);
    }
  }

  private static void addFriend(String friend1, String friend2) {
    friendsMap.computeIfAbsent(friend1, s -> new HashSet<>()).add(friend2);
  }
}
