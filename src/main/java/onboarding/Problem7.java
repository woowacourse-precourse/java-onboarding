package onboarding;

import onboarding.problem7.FriendShip;
import onboarding.problem7.RecommendScoreBoard;
import onboarding.problem7.RecommendType;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {
  public static List<String> solution(String user, List<List<String>> friendLists, List<String> visitors) {
    FriendShip friendShip = new FriendShip();
    friendShip.fromFriendLists(friendLists);

    RecommendScoreBoard scoreBoard = new RecommendScoreBoard();

    List<String> findFriends = friendShip.findFriends(user);
    List<String> findFriendsOfFriends = filterUser(filterFriends(friendShip.findFriends(findFriends), findFriends), user);
    scoreBoard.keepScore(findFriendsOfFriends, RecommendType.FRIEND);

    List<String> filterVisitors = filterUser(filterFriends(visitors, findFriends), user);
    scoreBoard.keepScore(filterVisitors, RecommendType.VISITOR);

    return scoreBoard.getResult();
  }

  private static List<String> filterUser(List<String> visitors, String user) {
    return visitors.stream().filter(visitor -> !visitor.equals(user)).collect(Collectors.toList());
  }

  private static List<String> filterFriends(List<String> users, List<String> friends) {
    return users.stream().filter(user -> !friends.contains(user)).collect(Collectors.toList());
  }
}
