package onboarding;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        void case1() {
            final List<Integer> pobi = List.of(97, 98);
            final List<Integer> crong = List.of(197, 198);
            final int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case2() {
            final List<Integer> pobi = List.of(131, 132);
            final List<Integer> crong = List.of(211, 212);
            final int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case3() {
            final List<Integer> pobi = List.of(99, 102);
            final List<Integer> crong = List.of(211, 212);
            final int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        void case1() {
            final String cryptogram = "browoanoommnaon";
            final String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            final String cryptogram = "zyelleyz";
            final String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            final int number = 13;
            final int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            final int number = 33;
            final int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            final String word = "I love you";
            final String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            final int money = 50_237;
            final List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            final int money = 15_000;
            final List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            final List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            final List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem7Test {
        @Test
        void case1() {
            final String user = "mrko";
            final List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            final List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            final List<String> result = List.of("andole", "jun", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
