package onboarding;

import onboarding.problem7.Problem7Validation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7CustomTest {
    /*
     *   문자열 길이 관련 테스트는 이미 overriding하여 작성하여 다른 테스트 코드들로
     *   확인 했으니, 배열의 길이가 맞는 테스트 코드, 소문자를 확인하는 테스트 코드만 작성한다.
     */

    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 30;


    @Nested
    class Problem7Test {

        @Test
        void 리스트의길이를만족하지않는경우() {
            List<String> zeroLengthList = new ArrayList<>();
            boolean impossible = Problem7Validation.problem7Validation("m", Collections.emptyList(), List.of("m"));
            assertThat(impossible).isFalse();
        }

        @Test
        void 리스트의길이를만족하는경우() {
            List<List<String>> possibleList = new ArrayList<>(List.of(List.of("a","b")));
            boolean possible = Problem7Validation.problem7Validation("m", possibleList, List.of("m"));
            assertThat(possible).isTrue();
        }

        @Test
        void 소문자가아닌경우() {
            List<List<String>> possibleList = new ArrayList<>(List.of(List.of("a","b")));
            boolean impossible = Problem7Validation.problem7Validation("M", possibleList, List.of("m"));
            assertThat(impossible).isFalse();
        }

        @Test
        void 소문자만있는경우() {
            List<List<String>> possibleList = new ArrayList<>(List.of(List.of("a","b")));
            boolean possible = Problem7Validation.problem7Validation("m", possibleList, List.of("m"));
            assertThat(possible).isTrue();
        }
        @Test
        void case5() {
            String user = "andole";
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
            List<String> result = List.of("sam", "shakevan", "anne", "kane", "mrko");
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
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case3() {
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
        void case4() {
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
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
        @Test
        void case7() {
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
    }
}
