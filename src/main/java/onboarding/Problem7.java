package onboarding;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


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
