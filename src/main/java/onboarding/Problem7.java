package onboarding;

import onboarding.problem7.FriendValidator;
import onboarding.problem7.UserValidator;
import onboarding.problem7.VisitorValidator;

import java.util.*;

public class Problem7 {
  private static final int OVERLAPPED_FRIEND_SCORE = 10;
  private static final int VISITED_FRIEND_SCORE = 1;
  private static final int FRIEND_LIST_OFFSET = 5;
  static Map<String, Integer> friendScoreHashMap = new HashMap<>();

  public static List<String> solution(
      String user, List<List<String>> friends, List<String> visitors) {

    UserValidator.validate(user);
    FriendValidator.validate(friends);
    VisitorValidator.validate(visitors);

    List<String> userFriends = saveUserFriendList(user, friends);

    return new ArrayList<>();
  }

  private static List<String> saveUserFriendList(String user, List<List<String>> friends) {
    List<String> userFriends = new ArrayList<>();
    for (List<String> friendRelationList : friends) {
      if (getUserA(friendRelationList).equals(user)) {
        userFriends.add(getUserB(friendRelationList));
      } else if (getUserB(friendRelationList).equals(user)) {
        userFriends.add(getUserA(friendRelationList));
      }
    }
    return userFriends;
  }

  private static String getUserA(List<String> friendRelationList) {
    return friendRelationList.get(0);
  }

  private static String getUserB(List<String> friendRelationList) {
    return friendRelationList.get(1);
  }


}
