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

  static class FriendShip {

    public static Map<String, Set<String>> makeFriends(List<List<String>> friends) {
      Map<String, Set<String>> friendShipMap = new HashMap<>();
      for (List<String> friend : friends) {
        String name1 = friend.get(0);
        String name2 = friend.get(1);
        establishFriendShip(friendShipMap, name1, name2);
        establishFriendShip(friendShipMap, name2, name1);
      }
      return friendShipMap;
    }

    private static void establishFriendShip(Map<String, Set<String>> friendShipMap, String keyName,
        String valueName) {
      if (!friendShipMap.containsKey(keyName)) {
        friendShipMap.put(keyName, new HashSet<>());
      }
      friendShipMap.get(keyName).add(valueName);
    }

  }
}
