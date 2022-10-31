package onboarding.myTest;

import onboarding.Problem7;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7Test {


    @Test
    void case1() {
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

    /**
     * 추천 친구가 없는 경우
     */
    @Test
    void case2() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "mrko")
        );
        List<String> visitors = List.of("donut");
        List<String> result = List.of();
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    /**
     * 동일한 친구관계가 만약 주어진다면
     */
    @Test
    void case3() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "jun");
        List<String> result = List.of("jun", "andole", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    /**
     * friends 가 비어 있고, 동일한 점수가 5명 이사인 경우
     */
    @Test
    void case4() {
        String user = "mrko";
        List<List<String>> friends = List.of(

        );
        List<String> visitors = List.of("bedi", "donut", "bedi", "shakevan", "jun", "a", "b");
        List<String> result = List.of("bedi", "a", "b", "donut", "jun");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }


}
