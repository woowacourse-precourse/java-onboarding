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
    @DisplayName("Case#3 방문자 목록 없어서, 친구의 친구 목록만 참고해서 점수를 매겼더니 기능이 적절히 작동한다.")
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
        List<String> result = List.of("andole", "jun");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    @DisplayName("Case#4 본인이 본인 타임라인을 방문했지만, 친구의 친구 목록과 방문자 목록 둘다 참고해서 점수를 매겼더니 기능이 적절히 작동한다.")
    void invalidInput_UserVisitedHimself_ButStill_recommendByFriendOfFriendAndVisitors() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("mrko", "bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "jun", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }
}
