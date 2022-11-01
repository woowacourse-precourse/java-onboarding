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
            final int expected = 0;

            final int result = Problem1.solution(pobi, crong);

            assertThat(result).isEqualTo(expected);
        }

        @Test
        void case2() {
            final List<Integer> pobi = List.of(131, 132);
            final List<Integer> crong = List.of(211, 212);
            final int expected = 1;

            final int result = Problem1.solution(pobi, crong);

            assertThat(result).isEqualTo(expected);
        }

        @Test
        void case3() {
            final List<Integer> pobi = List.of(99, 102);
            final List<Integer> crong = List.of(211, 212);
            final int expected = -1;
            
            final int result = Problem1.solution(pobi, crong);

            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        void case1() {
            final String cryptogram = "browoanoommnaon";
            final String expected = "brown";
            
            final String result = Problem2.solution(cryptogram);

            assertThat(result).isEqualTo(expected);
        }

        @Test
        void case2() {
            final String cryptogram = "zyelleyz";
            final String expected = "";

            final String result = Problem2.solution(cryptogram);

            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            final int number = 13;
            final int expected = 4;

            final int result = Problem3.solution(number);

            assertThat(result).isEqualTo(expected);
        }

        @Test
        void case2() {
            final int number = 33;
            final int expected = 14;

            final int result = Problem3.solution(number);
            
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            final String word = "I love you";
            final String expected = "R olev blf";

            final String result = Problem4.solution(word);
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            final int money = 50_237;
            final List<Integer> expected = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            
            final List<Integer> result = Problem5.solution(money);
            
            assertThat(result).isEqualTo(expected);
        }

        @Test
        void case2() {
            final int money = 15_000;
            final List<Integer> expected = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            
            final List<Integer> result = Problem5.solution(money);
            
            assertThat(result).isEqualTo(expected);
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
            final List<String> expected = List.of("jason@email.com", "jm@email.com", "mj@email.com");

            final List<String> result = Problem6.solution(forms);

            assertThat(result).isEqualTo(expected);
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
            final List<String> expected = List.of("andole", "jun", "bedi");

            final List<String> result = Problem7.solution(user, friends, visitors);

            assertThat(result).isEqualTo(expected);
        }
    }
}
