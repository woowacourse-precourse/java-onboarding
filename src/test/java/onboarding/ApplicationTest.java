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

        @Test
        void myCaseForPro1() {
            int result = -1;
            List<Integer> pobi = List.of(99, 102, 10);
            List<Integer> crong = List.of(211, 212, 100);

            List<Integer> pobi1 = List.of(99, 103);
            List<Integer> crong1 = List.of(211, 213);

            List<Integer> pobi2 = List.of(92, 103);
            List<Integer> crong2 = List.of(212, 213);

            List<Integer> pobi3 = List.of(92, 102);
            List<Integer> crong3 = List.of(212, 212);

            List<Integer> pobi4 = List.of(1, 2);
            List<Integer> crong4 = List.of(399, 400);

            List<Integer> pobi5 = List.of(0, 1);
            List<Integer> crong5 = List.of(401, 402);

            List<Integer> pobi6 = List.of(-389, -390);
            List<Integer> crong6 = List.of(-389, -390);

            List<Integer> pobi7 = List.of(389);
            List<Integer> crong7 = List.of(399);

            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
            assertThat(Problem1.solution(pobi1, crong1)).isEqualTo(result);
            assertThat(Problem1.solution(pobi2, crong2)).isEqualTo(result);
            assertThat(Problem1.solution(pobi3, crong3)).isEqualTo(result);
            assertThat(Problem1.solution(pobi4, crong4)).isEqualTo(result);
            assertThat(Problem1.solution(pobi5, crong5)).isEqualTo(result);
            assertThat(Problem1.solution(pobi6, crong6)).isEqualTo(result);
            assertThat(Problem1.solution(pobi7, crong7)).isEqualTo(result);
        }

    }

    @Nested
    class Problem2Test {
        @Test
        void case1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
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
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem7Test {
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
    }
}
