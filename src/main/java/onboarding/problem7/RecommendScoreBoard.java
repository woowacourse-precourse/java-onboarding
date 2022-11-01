package onboarding.problem7;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendScoreBoard {
  private final Map<String, Integer> scoreBoard = new HashMap<>();

  public void keepScore(List<String> users, RecommendType type) {
    users.forEach(user -> keepScore(user, type));
  }

  public void keepScore(String user, RecommendType type) {
    if (scoreBoard.containsKey(user)) {
      scoreBoard.put(user, scoreBoard.get(user) + type.getScore());
      return;
    }
    scoreBoard.put(user, type.getScore());
  }

  public List<String> getResult() {
    List<Map.Entry<String, Integer>> list = new ArrayList<>(scoreBoard.entrySet());
    Collections.sort(list, new ValueThenKeyComparator<>());
    return list.stream().limit(5).map(s -> s.getKey()).collect(Collectors.toList());
  }

  class ValueThenKeyComparator<K extends Comparable<? super K>,
          V extends Comparable<? super V>>
          implements Comparator<Map.Entry<K, V>> {

    public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
      int cmp1 = b.getValue().compareTo(a.getValue());
      if (cmp1 != 0) {
        return cmp1;
      } else {
        return a.getKey().compareTo(b.getKey());
      }
    }
  }
}