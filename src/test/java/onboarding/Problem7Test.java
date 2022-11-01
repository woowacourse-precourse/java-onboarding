package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
class Problem7Test {
    @Test
    void case1() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case2() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("jun", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> result = List.of("andole", "bedi");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case3() {
        String user = "andole";
        List<List<String>> friends = List.of(
                List.of("andole", "jun"),
                List.of("donut", "jun"),
                List.of("donut", "shakevan"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "bedi"),
                List.of("anne", "jun")
        );
        List<String> visitors = List.of("mrko", "peter", "donut", "sam");
        List<String> result = List.of("donut", "anne", "bedi", "mrko", "peter");
        assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case4() {
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
    void case5() {
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
}
