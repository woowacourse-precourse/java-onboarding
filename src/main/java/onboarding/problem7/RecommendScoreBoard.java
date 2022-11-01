package onboarding.problem7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    List<Map.Entry<String, Integer>> entries = scoreBoard.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
    return entries.stream().limit(5).map(Map.Entry::getKey).collect(Collectors.toList());
  }
}
