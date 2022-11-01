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
    addScoreOverlappedFriendIfNotFriend(user, friends, userFriends);
    addScoreVisitFriend(visitors, userFriends);
    List<Map.Entry<String, Integer>> entryList = new LinkedList<>(friendScoreHashMap.entrySet());
    entryList.sort(Map.Entry.comparingByKey());
    entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    return findFriendRelationshipOrderByScoreTop5(entryList);
  }

  private static List<String> findFriendRelationshipOrderByScoreTop5(
      List<Map.Entry<String, Integer>> entryList) {
    int count = FRIEND_LIST_OFFSET;
    List<String> resultList = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : entryList) {
      resultList.add(entry.getKey());
      count--;
      if (count == 0) {
        break;
      }
    }
    return resultList;
  }

  private static void addScoreVisitFriend(List<String> visitors, List<String> userFriends) {
    for (String visitor : visitors) {
      if (userFriends.contains(visitor)) {
        return;
      }
      updateUserScore(visitor, VISITED_FRIEND_SCORE);
    }
  }

  private static void addScoreOverlappedFriendIfNotFriend(
      String user, List<List<String>> friends, List<String> userFriends) {
    for (List<String> friendRelationList : friends) {
      String userA = getUserA(friendRelationList);
      String userB = getUserB(friendRelationList);
      if (isUserEqualUserAOrUserB(user, userA, userB)) {
        return;
      }
      updateScoreOverlappedFriend(userFriends, userA, userB);
    }
  }

  private static void updateScoreOverlappedFriend(
      List<String> userFriends, String userA, String userB) {
    if (userFriends.contains(userA) && !userFriends.contains(userB)) {
      updateUserScore(userB, OVERLAPPED_FRIEND_SCORE);
    } else if (userFriends.contains(userB) && !userFriends.contains(userA)) {
      updateUserScore(userA, OVERLAPPED_FRIEND_SCORE);
    }
  }

  private static boolean isUserEqualUserAOrUserB(String user, String userA, String userB) {
    return userA.equals(user) || userB.equals(user);
  }

  private static void updateUserScore(String name, int score) {
    if (friendScoreHashMap.containsKey(name)) {
      score += friendScoreHashMap.get(name);
    }
    friendScoreHashMap.put(name, score);
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
