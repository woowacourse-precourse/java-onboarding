package onboarding.problem07.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import onboarding.problem07.entity.wrapper.Friend;
import onboarding.problem07.entity.wrapper.Name;
import onboarding.problem07.entity.wrapper.NameScore;
import onboarding.problem07.infra.exception.VisitorLengthException;

public class Visitors {

  private List<Name> visitor;

  private Visitors(List<String> names) {
    if (names.isEmpty() || names.size() > 10000) {
      throw new VisitorLengthException();
    }
    visitor = new ArrayList<>();
    for (String name : names) {
      visitor.add(Name.from(name));
    }
  }

  public static Visitors of(List<String> names) {
    return new Visitors(names);
  }

  public Set<Name> friendListFromVisitors() {
    Set<Name> userFriend = new HashSet<>();
    for (Name name : visitor) {
      userFriend.add(name);
    }
    return userFriend;
  }

  public Set<NameScore> runService(Set<NameScore> nameScores) {

    for (Name visitUser : visitor) {
      for (NameScore nameScore : nameScores) {
        if (nameScore.currentName().equals(visitUser.currentName()) && (nameScore.currentScore()
            != -1)) {
          nameScore.visitFriend();
        }
      }
    }
    return nameScores;
  }
}
