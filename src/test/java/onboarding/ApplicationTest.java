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
        void case4(){
            List<Integer> pobi = List.of(1, 2);
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
            String cryptogram = "hello";
            String result = "heo";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case4() {
            String cryptogram = "a";
            String result = "a";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        void case5() {
            String cryptogram = "aaaccede";
            String result = "aede";
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
            int number = 1;
            int result = 0;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case4() {
            int number = 50;  //3 6 9 13 16 19 23 26 29 30 31 32 33 34 35 36 37 38 39 43 46 49
            int result = 25;
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
            String word = "My favorite food is a Pizza";
            String result = "Nb uzelirgv ullw rh z Kraaz";
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
            int money = 231_256;
            List<Integer> result = List.of(4, 3, 0, 1, 0, 2, 1, 0, 6);
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
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "이엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
        @Test
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("aaa@email.com", "제이엠"),
                    List.of("bbb@email.com", "제이제이제"),
                    List.of("ccc@email.com", "바이지"),
                    List.of("ddd@email.com", "제이옴"),
                    List.of("eee@email.com", "도롱뇽")
            );
            List<String> result = List.of("aaa@email.com", "bbb@email.com", "ddd@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void case4() {
            List<List<String>> forms = List.of(
                    List.of("bbb@email.com", "앙앙비비"),
                    List.of("ddd@email.com", "디디앙앙"),
                    List.of("ccc@email.com", "시시앙"),
                    List.of("eee@email.com", "이이앙"),
                    List.of("aaa@email.com", "에에앙앙")
            );
            List<String> result = List.of("aaa@email.com", "bbb@email.com", "ddd@email.com");
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
            String user = "aaa";
            List<List<String>> friends = List.of(
                    List.of("aaa", "bbb"),
                    List.of("ddd", "ccc"),
                    List.of("bbb", "ccc"),
                    List.of("bbb", "ddd"),
                    List.of("eee", "ddd"),
                    List.of("aaa", "eee")
            );
            List<String> visitors = List.of("bbb", "ccc", "eee", "bbb", "bbb");
            List<String> result = List.of("ddd", "ccc");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case3() {
            String user = "aaa";
            List<List<String>> friends = List.of(
                    List.of("aaa", "bbb"),
                    List.of("aaa", "ccc"),
                    List.of("aaa", "ddd"),
                    List.of("eee", "ccc"),
                    List.of("fff", "eee")
            );
            List<String> visitors = List.of("fff", "fff", "fff", "fff", "fff", "fff", "fff", "fff", "fff", "fff", "fff");
            List<String> result = List.of("fff", "eee");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case4() {
            String user = "aaa";
            List<List<String>> friends = List.of(
                    List.of("aaa", "bbb"),
                    List.of("aaa", "ccc"),
                    List.of("aaa", "ddd"),
                    List.of("fff", "ccc"),
                    List.of("eee", "fff")
            );
            List<String> visitors = List.of("eee", "eee", "eee", "eee", "eee", "eee", "eee", "eee", "eee", "eee");
            List<String> result = List.of("eee", "fff");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
