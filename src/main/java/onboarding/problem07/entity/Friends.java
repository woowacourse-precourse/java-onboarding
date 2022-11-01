package onboarding.problem07.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import onboarding.problem07.entity.wrapper.Friend;
import onboarding.problem07.infra.exception.ReduplicationFriendsException;

public class Friends {

  private List<Friend> friends;
  private Set<Friend> checkFriends;

  public Friends(List<List<String>> givenFriends) {
    friends = new ArrayList<>();
    checkFriends = new HashSet<>();

    for (List<String> eachFriend : givenFriends) {
      friends.add(Friend.of(eachFriend));
    }

    for (List<String> eachFriend : givenFriends) {
      checkFriends.add(Friend.of(eachFriend));
    }
    if (!checkMultiFriends(friends, checkFriends)) {
      throw new ReduplicationFriendsException();
    }

  }

  private boolean checkMultiFriends(List<Friend> friends, Set<Friend> checkFriends) {
    if (friends.size() != checkFriends.size()) {
      return false;
    }
    return true;
  }

  public static Friends of(List<List<String>> friendNamesList) {
    return new Friends(friendNamesList);
  }
}
