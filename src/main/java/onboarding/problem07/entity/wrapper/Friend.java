package onboarding.problem07.entity.wrapper;

import java.util.ArrayList;
import java.util.List;
import onboarding.problem07.infra.exception.FriendListEmptyException;
import onboarding.problem07.infra.exception.FriendSizeWrongException;

public class Friend {

  private List<Name> friend;

  private Friend(List<String> friendNames) {
    friend = new ArrayList<>();
    if (friendNames.size() != 2) {
      throw new FriendSizeWrongException();
    }
    if (friendNames.contains("")) {
      throw new FriendListEmptyException();
    }
    for (String friendName : friendNames) {
      friend.add(Name.from(friendName));
    }
  }
  public static Friend of(List<String> friendNames) {
    return new Friend(friendNames);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Friend)) {
      return false;
    }

    Friend friend1 = (Friend) o;

    return friend != null ? friend.equals(friend1.friend) : friend1.friend == null;
  }

  @Override
  public int hashCode() {
    return friend != null ? friend.hashCode() : 0;
  }
}
