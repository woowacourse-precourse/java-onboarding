package onboarding;

import java.util.ArrayList;
import java.util.Collections;
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

  public ScoreForPro7(Map<String, Integer> scoreMap, Set<String> friendSet) {
    makeScoreMap(new HashMap<>(), friendSet);
  }

  private void makeScoreMap(Map<String, Integer> scoreMap, Set<String> friendSet) {
    for (String s : friendSet) {
      scoreMap.put(s, 0);
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
    FriendForPro7 friendClass = new FriendForPro7();
    Set<String> friendSet = friendClass.makeFriendSet(friends, new HashSet<>());
    ScoreForPro7 scoreClass = new ScoreForPro7(new HashMap<>(), friendSet);
    friendMap = friendClass.makeFriendMap(friends, friendSet, new HashMap<>());
    validateUserContain(user);
    makeUserSelectedList(user, friendMap);
    finalScoreMap(user, visitors, scoreClass);
  }

  private void validateUserContain(String user) {
    if (!friendMap.containsKey(user)) {
      throw new IllegalArgumentException(user + "가 friendMap에 포함되어 있지 않습니다.");
    }
  }

  public Map<String, Integer> theLastScoreMap() {
    return lastScoreMap;
  }

  public void makeUserSelectedList(String user, Map<String, List<String>> friendMap) {
    this.userSelectedList = friendMap.get(user);
  }

  private void finalScoreMap(String user, List<String> visitors, ScoreForPro7 score) {
    valuePlus1(visitors, valuePlus10(user, score.getScoreMap()));
    lastScoreMap = removeFromScoreMap(user, score.getScoreMap());
  }

  private Map<String, Integer> valuePlus10(String user, Map<String, Integer> scoreMap) {
    for (String s : userSelectedList) {
      add10ToFriend(friendMap.get(s), user, scoreMap);
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
    validateVisitors(visitors);
  }

  private void validateUser(String user) {
    if (user.length() < USER_LENGTH_MIN || USER_LENGTH_MAX < user.length()) {
      throw new IllegalArgumentException(
          "user의 길이는 " + USER_LENGTH_MIN + "이상 " + USER_LENGTH_MAX + "이하의 정수여야 합니다.");
    }
    validateSmallAlpha(user);
  }

  private void validatefriends(List<List<String>> friends) {
    validateFriedsLength(friends);
    validateFriensETC(friends);
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

  private void validateVisitors(List<String> visitors) {
    if (VISITOR_LENGTH_MAX < visitors.size()) {
      throw new IllegalArgumentException(
          "visitors의 길이는 " + VISITOR_LENGTH_MIN + "이상 " + VISITOR_LENGTH_MAX + "이하의 정수여야 합니다.");
    }
    for (String name : visitors) {
      validateSmallAlpha(name);
    }
  }

  private void validateSmallAlpha(String name) {
    if (!name.matches("^[a-z]*$")) {
      throw new IllegalArgumentException("아이디는 알파벳 소문자로만 이루어져야 합니다.");
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
      int res = scoreMap.get(o2) - scoreMap.get(o1);
      if (res == 0) {
        return o1.compareTo(o2);
      }
      return res;
    }));
    return keyList;
  }
}
