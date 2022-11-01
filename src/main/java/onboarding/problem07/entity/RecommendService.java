package onboarding.problem07.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import onboarding.problem07.entity.wrapper.Name;
import onboarding.problem07.entity.wrapper.NameScore;

public class RecommendService {

  private User user;
  private Friends friends;
  private Visitors visitors;

  private Set<NameScore> result;

  public RecommendService(String userName, List<List<String>> friendsNames,
      List<String> visitorsNames) {
    user = User.from(userName);
    friends = Friends.of(friendsNames);
    visitors = Visitors.of(visitorsNames);
    result = new HashSet<>();
  }

  public static RecommendService of(String user, List<List<String>> friends,
      List<String> visitors) {
    return new RecommendService(user, friends, visitors);
  }

  public List<String> run() {

    resultListSetting();

    result = friends.runService(result, user);
    result = visitors.runService(result);

    // TODO: 2022/11/01 result to order name by score
    List<NameScore> nameScoreList = result.stream()
        .sorted(Comparator.comparing(NameScore::currentScore).reversed())
        .collect(Collectors.toList());

    return nameScoreList.stream().filter(nameScore -> nameScore.currentScore() != -1 &&
            nameScore.currentScore() != 0)
        .map(name -> name.currentName()).collect(Collectors.toList());

  }

  private void resultListSetting() {
    Set<Name> namesFromFriends = friends.friendListFromFriends();
    Set<Name> namesFromVisitors = visitors.friendListFromVisitors();

    for (Name namesFromVisitor : namesFromVisitors) {
      result.add(NameScore.from(namesFromVisitor));
    }

    for (Name namesFromFriend : namesFromFriends) {
      result.add(NameScore.from(namesFromFriend));
    }
  }
}
