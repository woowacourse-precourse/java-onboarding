package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem7 {

  private static HashMap<String, Set<String>> friendsShip = new HashMap<>();

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    setFriendsShip(friends);
    System.out.println(friendsShip);
    return new ArrayList<>();
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
}
