package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Problem7 {

  private static HashMap<String, Set<String>> friendsShip = new HashMap<>();
  private static HashMap<String, Integer> recommendList = new HashMap<>();

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    setFriendsShip(friends);
    recommendByFriends(user);
    recommendByVisitor(user, visitors);
    List<String> answer = getRecommendUsers();
    return answer;
  }

  private static List<String> getRecommendUsers() {
    List<String> answer = new ArrayList<>();
    List<Entry<String, Integer>> recommendEntries = new LinkedList<>(recommendList.entrySet());
    recommendEntries.sort(new Comparator<Entry<String, Integer>>() {
      @Override
      public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
        if (o2.getValue().equals(o1.getValue())) {
          return o1.getKey().compareTo(o2.getKey());
        }
        return o2.getValue() - o1.getValue();
      }
    });
    for (Entry<String, Integer> friend : recommendEntries) {
      if (answer.size() == 5) {
        break;
      }
      answer.add(friend.getKey());
    }
    return answer;
  }

  private static void setFriendsShip(List<List<String>> friends) {
    for (List<String> friend : friends) {
      String userA = friend.get(0);
      String userB = friend.get(1);
      Set<String> userAValue = friendsShip.getOrDefault(userA, new HashSet<>());
      userAValue.add(userB);
      friendsShip.put(userA, userAValue);

      Set<String> userBValue = friendsShip.getOrDefault(userB, new HashSet<>());
      userBValue.add(userA);
      friendsShip.put(userB, userBValue);
    }
  }

  private static void recommendByFriends(String user) {
    Set<String> myFriends = friendsShip.get(user);
    for (String myFriend : myFriends) {

      Set<String> friends = friendsShip.get(myFriend);

      for (String friend : friends) {
        if (!friend.equals(user)) {
          Integer priority = recommendList.getOrDefault(friend, 0);
          priority += 10;
          recommendList.put(friend, priority);
        }
      }
    }
  }

  private static void recommendByVisitor(String user, List<String> visitors) {
    Set<String> myFriends = friendsShip.get(user);
    for (String visitor : visitors) {
      if (myFriends.contains(visitor)) {
        continue;
      }
      Integer priority = recommendList.getOrDefault(visitor, 0);
      priority += 1;
      recommendList.put(visitor, priority);
    }
  }
}
