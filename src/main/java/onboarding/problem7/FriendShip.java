package onboarding.problem7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FriendShip {
  private Map<String, List<String>> friendship = new HashMap<>();

  public void fromFriendLists(List<List<String>> friendLists) {
    for (List<String> friendList : friendLists) {
      makeFriends(friendList.get(0), friendList.get(1));
      makeFriends(friendList.get(1), friendList.get(0));
    }
  }

  public List<String> findFriends(String user) {
    return friendship.get(user);
  }

  public List<String> findFriends(List<String> users) {
    return users.stream()
            .map(this::findFriends)
            .flatMap(friends -> friends.stream())
            .collect(Collectors.toList());
  }

  private void makeFriends(String key, String value) {
    if (friendship.containsKey(key)) {
      friendship.get(key).add(value);
      return;
    }
    List<String> val = new ArrayList<>();
    val.add(value);
    friendship.put(key, val);
  }
}
