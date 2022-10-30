package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("문제7번: 친구 추천 기능")
public class Problem7Test {
    @Test
    @DisplayName("Case#1 친구의 친구 목록과 방문자 목록 둘다 참고해서 점수를 매겼더니 기능이 적절히 작동한다.")
    void recommendByFriendOfFriendAndVisitors() {
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
    @DisplayName("Case#2 친구의 친구가 없고, 방문자 목록만 참고해서 점수를 매겼더니 기능이 적절히 작동한다.")
    void recommendByVisitors() {
        String user = "donut";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("bedi", "shakevan");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    @DisplayName("Case#3 친구의 친구 목록과 방문자 목록 둘다 참고했는데, 방문자 목록 점수로 친구의 친구 점수 보다 높은 경우")
    void recommendByFriendOfFriendAndVisitors_When_VisitorsScoreIsHigher() {
        String user = "andole";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "mrko", "bedi",
                "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "bedi");
        List<String> result = List.of("bedi", "mrko", "jun");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    @DisplayName("Case#4 친구의 친구 목록만 참고해서 점수를 매겼더니 기능이 적절히 작동한다.")
    void recommendByFriendOfFriend() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of();
        List<String> result = List.of("andole", "jun", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }
}
