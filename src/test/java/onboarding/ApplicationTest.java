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
            String cryptogram = "zyelllllleyz";
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
        @Test
        void case3() {
            int number = 333;
            int result = 228;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
        @Test
        void case4() {
            int number = 2;
            int result = 0;
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
            String word = "Svool, Dliow! 123";
            String result = "Hello, World! 123";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
        @Test
        void case3() {
            String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ !@#$%^&*  ";
            String result = "ZYXWVUTSRQPONMLKJIHGFEDCBA !@#$%^&*  ";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            System.out.println("case1");
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            System.out.println("case1");
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
                    List.of("donut", "bedi"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("jun", "andole"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("donut", "shakevan");
            List<String> result = List.of("andole", "bedi");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
        @Test
        void case5() {
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
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
        @Test
        void case6() {
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
            assertThat(Problem7.solution(user,friends, visitors)).isEqualTo(result);
        }
        @Test
        void case7() {
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
}
