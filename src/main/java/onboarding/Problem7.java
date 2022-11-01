package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FriendForPro7 {

  public Set<String> makeFriendSet(List<List<String>> friends, Set<String> friendSet) {
    for (List<String> friend : friends) {
      friendSet.add(friend.get(0));
      friendSet.add(friend.get(1));
    }
    return friendSet;
  }

  public Map<String, List<String>> makeFriendMap(List<List<String>> friends, Set<String> friendSet
      , Map<String, List<String>> friendMap) {
    for (String s : friendSet) {
      friendMap.put(s, matchFriends(friends, s));
    }
    return friendMap;
  }

  private List<String> matchFriends(List<List<String>> friends, String s) {
    List<String> nameList = new ArrayList<>();
    for (List<String> friend : friends) {
      addFriend(friend, s, nameList);
    }
    return nameList;
  }

  private void addFriend(List<String> friend, String s, List<String> nameList) {
    if (s.equals(friend.get(0))) {
      nameList.add(friend.get(1));
    } else if (s.equals(friend.get(1))) {
      nameList.add(friend.get(0));
    }
  }
}

class ScoreForPro7 {

  private Map<String, Integer> scoreMap;

  public ScoreForPro7(Set<String> friendSet, String user) {
    makeScoreMap(new HashMap<>(), friendSet, user);
  }

  private void makeScoreMap(Map<String, Integer> scoreMap, Set<String> friendSet, String user) {
    for (String s : friendSet) {
      scoreMap.put(s, 0);
    }
    if (!friendSet.contains(user)) {
      scoreMap.clear();
    }
    this.scoreMap = scoreMap;
  }

  public Map<String, Integer> getScoreMap() {
    return scoreMap;
  }
}

class UserSelectedForPro7 {

  private List<String> userSelectedList;
  private static Map<String, Integer> lastScoreMap;
  private static Map<String, List<String>> friendMap;

  public UserSelectedForPro7(String user, List<List<String>> friends, List<String> visitors) {
    ExceptionClassForPro7 exceptionClassForPro7 = new ExceptionClassForPro7(user, friends,
        visitors);
    exceptionClassForPro7 = null;
    FriendForPro7 friendClass = new FriendForPro7();
    Set<String> friendSet = friendClass.makeFriendSet(friends, new HashSet<>());
    ScoreForPro7 scoreClass = new ScoreForPro7(friendSet, user);
    friendMap = friendClass.makeFriendMap(friends, friendSet, new HashMap<>());
    makeUserSelectedList(user);
    finalScoreMap(user, visitors, scoreClass);
  }

  public Map<String, Integer> theLastScoreMap() {
    return lastScoreMap;
  }

  public void makeUserSelectedList(String user) {
    if (!friendMap.containsKey(user)) {
      this.userSelectedList = new ArrayList<>();
    }

    if (friendMap.containsKey(user)) {
      this.userSelectedList = friendMap.get(user);
    }
  }

  private void finalScoreMap(String user, List<String> visitors, ScoreForPro7 score) {
    valuePlus1(visitors, valuePlus10(user, score.getScoreMap()));
    lastScoreMap = removeFromScoreMap(user, score.getScoreMap());
  }

  private Map<String, Integer> valuePlus10(String user, Map<String, Integer> scoreMap) {
    if (!userSelectedList.isEmpty()) {
      for (String s : userSelectedList) {
        add10ToFriend(friendMap.get(s), user, scoreMap);
      }
    }
    return scoreMap;
  }

  private void add10ToFriend(List<String> selected, String user, Map<String, Integer> scoreMap) {
    for (String str : selected) {
      if (str.equals(user)) {
        continue;
      }
      scoreMap.put(str, scoreMap.get(str) + 10);
    }
  }

  private void valuePlus1(List<String> visitors, Map<String, Integer> scoreMap) {
    for (String s : visitors) {
      if (!scoreMap.containsKey(s)) {
        scoreMap.put(s, 1);
        continue;
      }
      scoreMap.put(s, scoreMap.get(s) + 1);
    }
  }

  private Map<String, Integer> removeFromScoreMap(String user, Map<String, Integer> scoreMap) {
    scoreMap.remove(user);
    for (String s : userSelectedList) {
      scoreMap.remove(s);
    }
    return scoreMap;
  }
}

class ExceptionClassForPro7 {

  private static final int USER_LENGTH_MIN = 1;
  private static final int USER_LENGTH_MAX = 30;
  private static final int FRIENDS_LENGTH_MIN = 1;
  private static final int FRIENDS_LENGTH_MAX = 10000;
  private static final int FRIENDS_LIST_ARR_LENGTH = 2;
  private static final int FRIENDS_ID_LENGTH_MIN = 1;
  private static final int FRIENDS_ID_LENGTH_MAX = 30;
  private static final int VISITOR_LENGTH_MIN = 0;
  private static final int VISITOR_LENGTH_MAX = 10000;

  public ExceptionClassForPro7(String user, List<List<String>> friends,
      List<String> visitors) {
    validateInfo(user, friends, visitors);
  }

  private void validateInfo(String user, List<List<String>> friends,
      List<String> visitors) {
    validateUser(user);
    validatefriends(friends);
    validateVisitors(visitors, user);
  }

  private void validateUser(String user) {
    if (user.length() < USER_LENGTH_MIN || USER_LENGTH_MAX < user.length()) {
      throw new IllegalArgumentException(
          "user의 길이는 " + USER_LENGTH_MIN + "이상 " + USER_LENGTH_MAX + "이하의 정수여야 합니다.");
    }
    validateSmallAlpha(user);
  }

  private void validatefriends(List<List<String>> friends) {
    validateSameFriend(friends);
    validateFriedsLength(friends);
    validateFriensETC(friends);
  }

  private void validateSameFriend(List<List<String>> friends) {
    Set<String> sameFriendSet = new HashSet<>();
    List<String> friendPair = friends.get(0);
    sameFriendSet.add(friendPair.get(0) + "/" + friendPair.get(1));
    sameFriendSet.add(friendPair.get(1) + "/" + friendPair.get(0));
    for (int i = 1; i < friends.size(); i++) {
      friendPair = friends.get(i);
      String pair1 = friendPair.get(0) + "/" + friendPair.get(1);
      String pair2 = friendPair.get(1) + "/" + friendPair.get(0);
      if (sameFriendSet.contains(pair1) || sameFriendSet.contains(pair2)) {
        throw new IllegalArgumentException();
      }
    }
  }

  private void validateFriedsLength(List<List<String>> friends) {
    if (friends.size() < FRIENDS_LENGTH_MIN || FRIENDS_LENGTH_MAX < friends.size()) {
      throw new IllegalArgumentException(
          "friends를 담고 있는 리스트/배열의 길이는 " + FRIENDS_LENGTH_MIN + "이상 " + FRIENDS_LENGTH_MAX
              + "이하의 정수여야 합니다.");
    }
  }

  private void validateFriensETC(List<List<String>> friends) {
    for (List<String> onePair : friends) {
      if (onePair.size() != FRIENDS_LIST_ARR_LENGTH || onePair.contains("")) {
        throw new IllegalArgumentException("friends에 담긴 친구 쌍에 문제가 있습니다.");
      }
      validateNameLength(onePair.get(0));
      validateNameLength(onePair.get(1));
    }
  }

  private void validateNameLength(String name) {
    if (name.length() < FRIENDS_ID_LENGTH_MIN || FRIENDS_ID_LENGTH_MAX < name.length()) {
      throw new IllegalArgumentException(
          "friends에 담긴 이름의 길이는 " + FRIENDS_ID_LENGTH_MIN + "이상 " + FRIENDS_ID_LENGTH_MAX
              + "이하의 정수여야 합니다.");
    }
    validateSmallAlpha(name);
  }

  private void validateVisitors(List<String> visitors, String user) {
    if (VISITOR_LENGTH_MAX < visitors.size()) {
      throw new IllegalArgumentException(
          "visitors의 길이는 " + VISITOR_LENGTH_MIN + "이상 " + VISITOR_LENGTH_MAX + "이하의 정수여야 합니다.");
    }
    validateNoUserInVisitor(visitors, user);
    for (String name : visitors) {
      validateSmallAlpha(name);
    }
  }

  private void validateSmallAlpha(String name) {
    if (!name.matches("^[a-z]*$")) {
      throw new IllegalArgumentException("아이디는 알파벳 소문자로만 이루어져야 합니다.");
    }
  }

  private void validateNoUserInVisitor(List<String> visitors, String user) {
    if (visitors.contains(user)) {
      throw new IllegalArgumentException("visitors에는 " + user + "가 포함되어 있으면 안됩니다.");
    }
  }
}

public class Problem7 {

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {
    UserSelectedForPro7 userSelected = new UserSelectedForPro7(user, friends, visitors);
    return sortKeys(userSelected.theLastScoreMap());
  }

  public static List<String> sortKeys(Map<String, Integer> scoreMap) {
    List<String> keyList = new ArrayList<>(scoreMap.keySet());
    keyList.sort(((o1, o2) -> {
      int result = scoreMap.get(o2) - scoreMap.get(o1);
      if (result == 0) {
        return o1.compareTo(o2);
      }
      return result;
    }));
    List<String> ansList = new ArrayList<>();
    int i = 0;
    for (String element : keyList) {
      ansList.add(element);
      if (i == 4) {
        break;
      }
      i++;
    }
    return ansList;
  }
}
