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
        void case4() {
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(5, 6);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case5() {
            List<Integer> pobi = List.of(3, 4);
            List<Integer> crong = List.of(399, 400);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
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

        @Test
        void case3() {
            String cryptogram = "zyeeellleeeyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case4() {
            String cryptogram = "a";
            String result = "a";
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

        @Test
        void case2() {
            String word = "GIT123HUB";
            String result = "TRG123SFY";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void case3() {
            String word = "abcEFG";
            String result = "zyxVUT";
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

        @Test
        void case3() {
            int money = 109_876;
            List<Integer> result = List.of(2, 0, 1, 4, 1, 3, 1, 2, 6);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case4() {
            int money = 0;
            List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case5() {
            int money = 1_000_000;
            List<Integer> result = List.of(20, 0, 0, 0, 0, 0, 0, 0, 0);
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

        @Test
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("mmm@email.com", "엠엠엠"),
                    List.of("abcd@email.com", "에이비씨디"),
                    List.of("mk@email.com", "엠케이"),
                    List.of("ace@email.com", "에이스"),
                    List.of("ooo@email.com", "이비"),
                    List.of("k@email.com", "케이")
            );
            List<String> result = List.of("abcd@email.com", "ace@email.com", "k@email.com", "mk@email.com", "ooo@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("k@email.com", "케"),
                    List.of("mmm@email.com", "엠엠엠"),
                    List.of("abcd@email.com", "에이비씨디"),
                    List.of("a@email.com", "에이")
            );
            List<String> result = List.of("a@email.com", "abcd@email.com");
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

        @Test
        void case2() {
            String user = "donut";
            List<List<String>> friends = List.of(
                    List.of("donut", "why"),
                    List.of("why", "jun"),
                    List.of("coco", "why"),
                    List.of("why", "andole"),
                    List.of("why", "mrko")
            );
            List<String> visitors = List.of("coco", "why", "why", "why", "why", "tete", "tete", "tete", "kaka", "kaka", "kaka");
            List<String> result = List.of("coco", "andole", "jun", "mrko", "kaka");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case3() {
            String user = "shakevan";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("abc", "jun"),
                    List.of("donut", "mrko"),
                    List.of("kiki", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("donut", "abc", "kiki", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case4() {
            String user = "shakevan";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("abc", "jun"),
                    List.of("donut", "mrko"),
                    List.of("kiki", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "bedi", "bedi", "bedi",
                    "bedi", "bedi", "bedi", "bedi", "bedi");
            List<String> result = List.of("donut", "abc", "bedi", "kiki");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case5() {
            String user = "shakevan";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("abc", "jun"),
                    List.of("donut", "mrko"),
                    List.of("kiki", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "bedi", "bedi", "bedi",
                    "bedi", "bedi", "bedi", "bedi", "bedi", "bedi");
            List<String> result = List.of("donut", "bedi", "abc", "kiki");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case6() {
            String user = "shakevan";
            List<List<String>> friends = List.of(
                    List.of("jun", "andole"),
                    List.of("mrko", "jun"),
                    List.of("abc", "jun"),
                    List.of("zzz", "jun"),
                    List.of("donut", "mrko"),
                    List.of("kiki", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "bedi", "bedi", "bedi",
                    "bedi", "bedi", "bedi", "bedi", "bedi", "bedi", "donut");
            List<String> result = List.of("bedi", "donut", "abc", "kiki", "zzz");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
