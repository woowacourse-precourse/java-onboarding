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
