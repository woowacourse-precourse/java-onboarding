package onboarding;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class Problem7Test {
    @Test
    void checkSolution() {
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
        assertThat(solution(user, friends, visitors)).isEqualTo(result);
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
        assertThat(solution(user, friends, visitors)).isEqualTo(result);
    }

//    visitors = []

    @Test
    void case3() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("mrko", "jun"),
                List.of("bedi", "jun"),
                List.of("bedi", "donut"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("jun", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("donut", "shakevan");
        List<String> result = List.of("andole", "bedi");
        assertThat(solution(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void case4() {
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
        List<String> visitors = List.of("donut", "mrko", "peter", "sam");
        List<String> result = List.of("donut", "anne", "bedi", "mrko", "peter");
        assertThat(solution(user, friends, visitors)).isEqualTo(result);
    }

    static Map<String, Integer> userFriends;
}