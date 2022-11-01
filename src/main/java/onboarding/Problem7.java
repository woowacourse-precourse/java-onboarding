package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    List<String> answer = new ArrayList<>();
    Map<String, Integer> friendsPoint = new HashMap<String, Integer>();
    List<String> userFriends = makeUserFriends(user, friends);
    List<String> newVisitors = new ArrayList<>();

    pointByFriends(user, friends, friendsPoint, userFriends);

    makeVisitorsNotContainFriends(visitors, userFriends, newVisitors);
    pointByVisitors(newVisitors, friendsPoint);

    List<String> keySet = new ArrayList<>(friendsPoint.keySet());
    sortFriends(answer, friendsPoint, keySet);

    return answer;
  }

  private static void sortFriends(List<String> answer, Map<String, Integer> friendsPoint,
      List<String> keySet) {
    keySet.sort((o1, o2) -> friendsPoint.get(o1).compareTo(friendsPoint.get(o1)));

    for (String key : keySet) {
      answer.add(key);
    }
  }

  private static void makeVisitorsNotContainFriends(List<String> visitors, List<String> userFriends,
      List<String> newVisitors) {
    for (String visitor : visitors) {
      if (!userFriends.contains(visitor)) {
        newVisitors.add(visitor);
      }
    }
  }

  private static void pointByFriends(String user, List<List<String>> friends,
      Map<String, Integer> friendsPoint, List<String> userFriends) {
    for (int i = 0; i < userFriends.size(); i++) {
      List<String> friendFriends = makeUserFriends(userFriends.get(i), friends);
      checkContainUser(user, friendFriends);
      givePoint(friendsPoint, friendFriends);
    }
  }

  private static void givePoint(Map<String, Integer> friendsPoint, List<String> friendFriends) {
    for (int j = 0; j < friendFriends.size(); j++) {
      String friendFriendsName = friendFriends.get(j);
      int point = 10 + plusPoint(friendFriendsName, friendsPoint);
      friendsPoint.put(friendFriendsName, point);
    }
  }

  private static void checkContainUser(String user, List<String> friendFriends) {
    if (friendFriends.contains(user)) {
      friendFriends.remove(user);
    }
  }

  private static void pointByVisitors(List<String> visitors, Map<String, Integer> friendsPoint) {
    for (int i = 0; i < visitors.size(); i++) {
      String visitor = visitors.get(i);
      int point = 1 + plusPoint(visitor, friendsPoint);
      friendsPoint.put(visitor, point);
    }
  }

  private static int plusPoint(String name, Map<String, Integer> friendsPoint) {
    int point = 0;
    if (friendsPoint.containsKey(name)) {
      point += friendsPoint.get(name);
    }
    return point;
  }

  private static List<String> makeUserFriends(String user, List<List<String>> friends) {
    List<String> userFriends = new ArrayList<String>();
    for (List<String> pair : friends) {
      if (pair.get(0).equals(user)) {
        userFriends.add(pair.get(1));
      } else if (pair.get(1).equals(user)) {
        userFriends.add(pair.get(0));
      }
    }
    return userFriends;
  }
}
