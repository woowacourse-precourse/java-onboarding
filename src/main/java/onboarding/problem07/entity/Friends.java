package onboarding.problem07.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import onboarding.problem07.entity.wrapper.Friend;
import onboarding.problem07.entity.wrapper.Name;
import onboarding.problem07.entity.wrapper.NameScore;
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

  public Set<Name> friendListFromFriends() {
    Set<Name> userFriend = new HashSet<>();
    for (Friend friend : friends) {
      List<Name> names = friend.currentFriend();
      for (Name name : names) {
        userFriend.add(name);
      }
    }
    return userFriend;
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


  public List<NameScore> runService(List<NameScore> nameScores, User user) {
    Name standardUser = user.currentUser();

    for (Friend friend : friends) {
      List<Name> names = friend.currentFriend();

      Name postName = names.get(1);

      for (NameScore nameScore : nameScores) {
        // 이미 친구인 상황이라면 -1로 스코어 책정
        if (postName.equals(standardUser)) {
          nameScore.alreadyFriend();
        }
        // 새로운 친구라면 10점 더하기
        nameScore.newFriend();
      }
    }
    return nameScores;
  }
}
