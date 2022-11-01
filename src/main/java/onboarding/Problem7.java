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

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    Map<String, Set<String>> friendsMap = new HashMap<>();
    Map<String, Integer> scoreMap = new HashMap<>();

    makeFriendMap(friends, friendsMap);
    setAcquaintancePoint(user, friendsMap, scoreMap);
    setVisitorPoint(user, visitors, friendsMap, scoreMap);
    return getAnswer(scoreMap);
  }

  private static List<String> getAnswer(Map<String, Integer> scoreMap) {
    return scoreMap.entrySet()
        .stream()
        .filter(entry -> entry.getValue() != 0)
        .sorted(Map.Entry.<String, Integer>comparingByValue(Collections.reverseOrder())
            .thenComparing(Entry::getKey))
        .limit(5)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }

  private static void setVisitorPoint(String user, List<String> visitors,
      Map<String, Set<String>> friendsMap, Map<String, Integer> scoreMap) {

    for (String visitor : visitors) {
      if (friendsMap.containsKey(user) && friendsMap.get(user).contains(visitor)) {
        continue;
      }
      scoreMap.put(visitor, scoreMap.getOrDefault(visitor, 0) + 1);
    }
  }

  private static void setAcquaintancePoint(String user, Map<String, Set<String>> friendsMap,
      Map<String, Integer> scoreMap) {
    if (!friendsMap.containsKey(user)) {
      return;
    }
    for (String person : friendsMap.keySet()) {
      if (person.equals(user) || friendsMap.get(user).contains(person)) {
        continue;
      }
      friendsMap.get(person).retainAll(friendsMap.get(user));
      int acquaintances = friendsMap.get(person).size();
      scoreMap.put(person, acquaintances * 10);
    }
  }

  private static void makeFriendMap(List<List<String>> friends,
      Map<String, Set<String>> friendsMap) {
    for (List<String> friend : friends) {
      String friend1 = friend.get(0);
      String friend2 = friend.get(1);
      addFriend(friend1, friend2, friendsMap);
      addFriend(friend2, friend1, friendsMap);
    }
  }

  private static void addFriend(String friend1, String friend2,
      Map<String, Set<String>> friendsMap) {
    friendsMap.computeIfAbsent(friend1, s -> new HashSet<>()).add(friend2);
  }
}
