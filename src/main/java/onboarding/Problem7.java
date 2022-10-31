package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class ValidatorPro7 {

  public final static int ID_A = 0;
  public final static int ID_B = 1;
  public final static int MIN_USER_LEN = 1;
  public final static int MAX_USER_LEN = 30;
  public final static int MIN_FRIENDS_SIZE = 1;
  public final static int MAX_FRIENDS_SIZE = 10_000;
  public final static int FRIENDS_LIST_SIZE = 2;
  public final static int MIN_VISITORS_SIZE = 0;
  public final static int MAX_VISITORS_SIZE = 10_000;
  public final static int MIN_ID_LEN = 1;
  public final static int MAX_ID_LEN = 30;

  public ValidatorPro7(String user, List<List<String>> friends, List<String> visitors) {
    validateUser(user);
    validateFriends(friends);
    validateVisitors(user, visitors);
  }

  public static void validateUser(String user) {
    if (user.length() < MIN_USER_LEN || user.length() > MAX_USER_LEN) {
      throw new IllegalArgumentException(
          "User should be a string with a length of between"
              + MIN_USER_LEN + " and " + MAX_USER_LEN + ".");
    }
  }

  public static void validateFriends(List<List<String>> friends) {
    if (friends.size() < MIN_FRIENDS_SIZE || friends.size() > MAX_FRIENDS_SIZE) {
      throw new IllegalArgumentException(
          "Friends should be a string with a length of between"
              + MIN_FRIENDS_SIZE + " and " + MAX_FRIENDS_SIZE + ".");
    }
    for (List<String> pair : friends) {
      if (pair.size() != FRIENDS_LIST_SIZE) {
        throw new IllegalArgumentException(
            "Each element of friends is of length" + FRIENDS_LIST_SIZE + ".");
      }
      if (pair.get(ID_A).equals(pair.get(ID_B))) {
        throw new IllegalArgumentException("The same friendship is not given.");
      }
      validateId(pair.get(ID_A));
      validateId(pair.get(ID_B));
    }
  }

  public static boolean isAlpha(String str) {
    return Pattern.matches("^[a-zA-Z]*$", str);
  }

  public static void validateId(String id) {
    if (!isAlpha(id)) {
      throw new IllegalArgumentException("The user ID should be given by alphabet.");
    }
    if (!id.equals(id.toLowerCase())) {
      throw new IllegalArgumentException(
          "The user ID consists of only lowercase letters of the alphabet.");
    }
    if (id.length() < MIN_ID_LEN || id.length() > MAX_ID_LEN) {
      throw new IllegalArgumentException(
          "The user ID should be a string with a length of between"
              + MIN_ID_LEN + " and " + MAX_ID_LEN + ".");
    }
  }

  public void validateVisitors(String user, List<String> visitors) {
    if (visitors.contains(user)) {
      throw new IllegalArgumentException("Users cannot visit their own SNS.");
    }
    if (visitors.size() < MIN_VISITORS_SIZE || visitors.size() > MAX_VISITORS_SIZE) {
      throw new IllegalArgumentException(
          "Visitors is a list/array of length "
              + MIN_VISITORS_SIZE + " to " + MAX_VISITORS_SIZE + ".");
    }
  }
}

class RelationPro7 {

  public final static int LEFT = 0;
  public final static int RIGHT = 1;

  private static Map<String, Set<String>> relation;

  public RelationPro7(String user, List<List<String>> friends, List<String> visitors) {
    relation = new HashMap<>();
    findFriend(friends);
    findVisitor(visitors);
  }

  public static Map<String, Set<String>> getRelation() {
    return relation;
  }

  public static void findFriend(List<List<String>> friends) {
    for (List<String> pair : friends) {
      if (!relation.containsKey(pair.get(LEFT))) {
        Set<String> my_friends = new HashSet<>();
        relation.put(pair.get(LEFT), my_friends);
      }
      relation.get(pair.get(LEFT)).add(pair.get(RIGHT));
    }
    for (List<String> pair : friends) {
      if (!relation.containsKey(pair.get(RIGHT))) {
        Set<String> my_friends = new HashSet<>();
        relation.put(pair.get(RIGHT), my_friends);
      }
      relation.get(pair.get(RIGHT)).add(pair.get(LEFT));
    }
  }

  public static void findVisitor(List<String> visitors) {
    for (String name : visitors) {
      if (!relation.containsKey(name)) {
        relation.put(name, null);
      }
    }
  }

  public static void removeMutual(String user, RelationPro7 relation,
      ScorePro7 score) {
    if (RelationPro7.getRelation().containsKey(user)) {
      for (String name : RelationPro7.getRelation().get(user)) {
        ScorePro7.getScoreList().remove(name);
      }
    }
  }
}

class ScorePro7 {

  public final static int SCORE_ZERO = 0;
  public final static int SCORE_ONE = 1;
  public final static int SCORE_TEN = 10;

  private static Map<String, Integer> scoreList;

  public static Map<String, Integer> getScoreList() {
    return scoreList;
  }

  public ScorePro7(String user, RelationPro7 relation, List<String> visitors) {
    scoreList = new HashMap<>();
    scoreAddTen(user, relation);
    scoreAddOne(visitors);
  }

  public static void scoreAddTen(String user, RelationPro7 relation) {
    if (RelationPro7.getRelation().containsKey(user)) {
      for (String mutual : RelationPro7.getRelation().get(user)) {
        for (String unknown : RelationPro7.getRelation().get(mutual)) {
          if (!unknown.equals(user)) {
            if (!scoreList.containsKey(unknown)) {
              scoreList.put(unknown, SCORE_ZERO);
            }
            int score = scoreList.get(unknown);
            scoreList.put(unknown, score + SCORE_TEN);
          }
        }
      }
    }
  }

  public static void scoreAddOne(List<String> visitors) {
    for (String visitor : visitors) {
      if (!scoreList.containsKey(visitor)) {
        scoreList.put(visitor, SCORE_ZERO);
      }
      int score = scoreList.get(visitor);
      scoreList.put(visitor, score + SCORE_ONE);
    }
  }
}

public class Problem7 {

  public static List<String> solution(String user, List<List<String>> friends,
      List<String> visitors) {

    ValidatorPro7 validator = new ValidatorPro7(user, friends, visitors);
    RelationPro7 relation = new RelationPro7(user, friends, visitors);
    RelationPro7.removeMutual(user, relation, new ScorePro7(user, relation, visitors));

    return ScorePro7.getScoreList().keySet()
        .stream()
        .sorted((Comparator.naturalOrder()))
        .sorted(((o1, o2) -> ScorePro7.getScoreList().get(o2)
            .compareTo(ScorePro7.getScoreList().get(o1))))
        .limit(5).collect(Collectors.toList());
  }
}
