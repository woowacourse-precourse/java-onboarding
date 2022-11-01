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


  public Set<NameScore> runService(Set<NameScore> nameScores, User user) {
    Name standardUser = user.currentUser();

    // 이미 친구인 사람 체크 flow
    for (Friend friend : friends) {
      List<Name> nameList = friend.currentFriend();

      Name preName = nameList.get(0);
      Name postName = nameList.get(1);

      if (standardUser.currentName().equals(postName.currentName())) {
        for (NameScore nameScore : nameScores) {
          if (nameScore.currentName().equals(preName.currentName())) {
            nameScore.alreadyFriend();
          }
        }
      }
    }

    for (Friend friend : friends) {
      List<Name> nameList = friend.currentFriend();

      Name preName = nameList.get(0);
      Name postName = nameList.get(1);

      if (!standardUser.currentName().equals(postName.currentName())) {
        for (NameScore nameScore : nameScores) {
          if (nameScore.currentName().equals(postName.currentName())) {
            nameScore.newFriend();
          }
        }
      }
    }
    return nameScores;
  }
}
