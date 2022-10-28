package onboarding;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        void case1() {
            String str1 = "browoanoommnaon";
            assertThat(Problem2.solution(str1)).isEqualTo("brown");
        }

        @Test
        void case2() {
            String str2 = "zyelleyz";
            assertThat(Problem2.solution("zyelleyz")).isEqualTo("");
        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int num1 = 13;

            assertThat(Problem3.solution(num1)).isEqualTo(4);
        }

        @Test
        void case2() {
            int num2 = 33;

            assertThat(Problem3.solution(num2)).isEqualTo(14);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            String str = "I love you";

            assertThat(Problem4.solution(str)).isEqualTo("R olev blf");
        }

    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            int mon1 = 50237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(mon1)).isEqualTo(result);
        }

        @Test
        void case2() {
            int mon2 = 15000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(mon2)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠"));

            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");

            assertThat(Problem6.solution(forms)).isEqualTo(result);

        }
    }
}
