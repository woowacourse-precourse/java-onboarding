package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FriendShip {
  private Map<String, List<String>> friendship = new HashMap<>();

  public void fromFriendLists(List<List<String>> friendLists) {
    for (List<String> friendList : friendLists) {
      makeFriends(friendList.get(0), friendList.get(1));
      makeFriends(friendList.get(1), friendList.get(0));
    }
  }

  public Optional<List<String>> findFriends(String user) {
    return Optional.ofNullable(friendship.get(user));
  }

  public Optional<List<String>> findFriends(List<String> users) {
    return Optional.ofNullable(users.stream()
            .map(this::findFriends)
            .flatMap(friends -> friends.orElseGet(Collections::emptyList).stream())
            .collect(Collectors.toList()));
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
