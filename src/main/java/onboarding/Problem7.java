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

  private static final Map<String, Integer> scoreMap = new HashMap<>();
  private static final Set<String> myFriends = new HashSet<>();

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    initMyFriends(user, friends);
    initOthers(friends, visitors);
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
}
