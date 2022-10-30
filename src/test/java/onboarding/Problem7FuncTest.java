package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class Problem7FuncTest {

  @Test
  public void createFriendShip() {
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun")
    );

    String name1 = "donut";
    String name2 = "andole";
    String name3 = "jun";

    Map<String, Set<String>> result = Problem7.friendShip.createFriendShip(friends);

    assertThat(result.get(name1)).containsExactly(name2, name3);
    assertThat(result.get(name2)).containsExactly(name1);
    assertThat(result.get(name3)).containsExactly(name1);
  }

  @Test
  public void createNetworkScore() {
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun"),
        List.of("dog", "jun"),
        List.of("rabbit", "jun"),
        List.of("andole", "jun")
    );

    String name1 = "donut";
    String name2 = "dog";
    String name3 = "rabbit";
    String name4 = "happy";

    List<String> visitors = List.of("dog", "happy");

    Problem7.friendShip.createFriendShip(friends);
    Map<String, Integer> networkScore = Problem7.friendShip.createRecommendedScore(name1, visitors);

    int scoreForName2 = 11;
    int scoreForName3 = 10;
    int scoreForName4 = 1;

    assertThat(networkScore.get(name2)).isEqualTo(scoreForName2);
    assertThat(networkScore.get(name3)).isEqualTo(scoreForName3);
    assertThat(networkScore.get(name4)).isEqualTo(scoreForName4);
  }

  @Test
  public void recommendUsers() {
    Map<String, Integer> recommendedScore = new HashMap<>();

    String name1 = "donut";
    String name2 = "andole";
    String name3 = "jun";
    String name4 = "happy";

    int scoreForName1 = 10;
    int scoreForName2 = 11;
    int scoreForName3 = 12;
    int scoreForName4 = 13;

    recommendedScore.put(name1, scoreForName1);
    recommendedScore.put(name2, scoreForName2);
    recommendedScore.put(name3, scoreForName3);
    recommendedScore.put(name4, scoreForName4);

    List<String> result = Problem7.recommendation.recommendUsers(name1, recommendedScore);

    assertThat(result.size()).isEqualTo(3);
    assertThat(result).containsExactly(name4, name3, name2);
  }

  @Test
  public void testCase1() {
    String user = "mrko";
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun"),
        List.of("donut", "mrko"),
        List.of("shakevan", "andole"),
        List.of("shakevan", "jun"),
        List.of("shakevan", "mrko")
    );
    List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
    List<String> result = List.of("andole", "jun", "bedi");
    assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
  }

  @Test
  public void testCase2() {
    String user = "mrko";
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun"),
        List.of("donut", "mrko"),
        List.of("shakevan", "andole"),
        List.of("shakevan", "jun"),
        List.of("shakevan", "mrko")
    );
    List<String> visitors = List.of(
        "bedi", "bedi", "donut",
        "bedi", "shakevan", "pp",
        "pp", "pp", "pp",
        "KK", "KK", "KK",
        "PP", "PP", "PP",
        "LL", "LL", "LL",
        "YY", "YY", "YY");
    List<String> result = List.of("andole", "jun", "pp", "KK", "LL");
    assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
  }

  @Test
  public void testCase3() {
    String user = "mrko";
    List<List<String>> friends = List.of(
        List.of("donut", "andole"),
        List.of("donut", "jun"),
        List.of("donut", "mrko"),
        List.of("shakevan", "andole"),
        List.of("shakevan", "jun"),
        List.of("shakevan", "mrko")
    );
    List<String> visitors = Collections.emptyList();
    List<String> result = List.of("andole", "jun");
    assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
  }

  @Test
  public void testCase4() {
    String user = "hello";
    List<List<String>> friends = List.of(
        List.of("andole", "jun"),
        List.of("andole", "bedi"),
        List.of("jun", "shakevan"),
        List.of("jun", "kane"),
        List.of("jun", "sam"),
        List.of("bedi", "shakevan"),
        List.of("bedi", "anne"),
        List.of("bedi", "sam"),
        List.of("anne", "mrko")
    );
    List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
    List<String> result = List.of("mrko", "anne", "donut", "sam");
    assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
  }

  @Test
  public void testCase5() {
    String user = "mrko";
    List<List<String>> friends = List.of(
        List.of("shakevan", "mrko"),
        List.of("donut", "mrko"),
        List.of("jun", "mrko"),
        List.of("jun", "shakevan"),
        List.of("donut", "jun"),
        List.of("shakevan", "donut")
    );
    List<String> visitors = Collections.emptyList();
    List<String> result = Collections.emptyList();
    assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
  }

}