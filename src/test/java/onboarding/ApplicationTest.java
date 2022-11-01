package onboarding;

import org.junit.jupiter.api.Assertions;
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
//        @Test
//        void case4() {
//            List<Integer> pobi = List.of(30,29);
//            List<Integer>crong = List.of(40,41);
//            int result = -1;
//            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
//        }
//        @Test
//        void case5() {
//            List<Integer> pobi = List.of(-1, 0);
//            List<Integer> crong = List.of(40, 41);
//            int result = -1;
//            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
//        }
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

//        @Test
//        void case3() throws Exception{
//            String cryptogram = "abcdefghijklmnopqrstuvwxyzzzzzz".repeat(100);
//
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem2.solution(cryptogram);
//            });
//
//        }
    }

    @Nested
    class Problem3Test {
        @Test
        void case1() throws Exception {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case2() throws Exception {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

//        @Test
//        void case3() throws Exception {
//            int number = 10001;
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem3.solution(number);
//            }, "오류가 발생하지 않았습니다");
//        }

    }

    @Nested
    class Problem4Test {
        @Test
        void case1() throws Exception {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
//        @Test
//        void case2() throws Exception {
//            String word = "I love you".repeat(1000);
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem4.solution(word);
//            }, "오류가 발생하지 않았습니다");
//        }
    }

    @Nested
    class Problem5Test {
        @Test
        void case1() throws Exception {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case2() throws Exception {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

//        @Test
//        void case3() throws Exception {
//            int money = 1_000_001;
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem5.solution(money);
//            }, "오류가 발생하지 않았습니다");
//        }
    }

    @Nested
    class Problem6Test {
        @Test
        void case1() throws Exception {
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

//        @Test
//        void case2() throws Exception {
//            List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠"),
//                    List.of("jason@email.com", "제이슨"),
//                    List.of("woniee@email.com", "워니"),
//                    List.of("mj@email.com", "엠제이"),
//                    List.of("nowm@email.com", "이제엠"),
//                    List.of("12345678901@email.com", "카카오")
//            );
//            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem6.solution(forms);
//            });
//        }
//
//        @Test
//        void case3() throws Exception {
//            List<List<String>> forms = List.of(
//                    List.of("jm@email.com", "제이엠"),
//                    List.of("jason@email.com", "제이슨"),
//                    List.of("woniee@email.com", "워니"),
//                    List.of("mj@email.com", "엠제이"),
//                    List.of("nowm@email.com", "이제엠"),
//                    List.of("test@email.com", "KAKAO")
//            );
//            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem6.solution(forms);
//            });
//        }
    }

    @Nested
    class Problem7Test {
        @Test
        void case1() throws Exception {
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

//        @Test
//        void case2() throws Exception {     //사용자의 아이디가 30자가 넘을 때
//            String user = "mrko".repeat(20);
//            List<List<String>> friends = List.of(
//                    List.of("donut", "andole"),
//                    List.of("donut", "jun"),
//                    List.of("donut", "mrko"),
//                    List.of("shakevan", "andole"),
//                    List.of("shakevan", "jun"),
//                    List.of("shakevan", "mrko")
//            );
//            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem7.solution(user, friends, visitors);
//            });
//        }
//        @Test
//        void case3() throws Exception { //친구의 아이디 길이가 30자가 넘을 때
//            String user = "mrko";
//            List<List<String>> friends = List.of(
//                    List.of("donut", "andole"),
//                    List.of("donut", "jun"),
//                    List.of("donut", "mrko"),
//                    List.of("shakevan", "andolejfalksdfjlkasasdfasdfadsfasdfasf"),
//                    List.of("shakevan", "jun"),
//                    List.of("shakevan", "mrko")
//            );
//            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem7.solution(user, friends, visitors);
//            });
//        }
//
//        @Test
//        void case4() throws Exception { // 사용자의 관계가 1:1이 아닐 때
//            String user = "mrko";
//            List<List<String>> friends = List.of(
//                    List.of("donut", "andole"),
//                    List.of("donut", "jun"),
//                    List.of("donut", "mrko"),
//                    List.of("shakevan", "andole", "BAMIN"),
//                    List.of("shakevan", "jun"),
//                    List.of("shakevan", "mrko")
//            );
//            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem7.solution(user, friends, visitors);
//            });
//        }
//        @Test
//        void case5() throws Exception { //사용자의 아이디가 대문자일 때
//            String user = "mrkO";
//            List<List<String>> friends = List.of(
//                    List.of("donut", "andole"),
//                    List.of("donut", "jun"),
//                    List.of("donut", "mrko"),
//                    List.of("shakevan", "andole"),
//                    List.of("shakevan", "jun"),
//                    List.of("shakevan", "mrko")
//            );
//            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem7.solution(user, friends, visitors);
//            });
//        }
//        @Test
//        void case6() throws Exception { //친구관계가 중복해서 나왔을 때
//            String user = "mrko";
//            List<List<String>> friends = List.of(
//                    List.of("donut", "andole"),
//                    List.of("donut", "jun"),
//                    List.of("donut", "mrko"),
//                    List.of("shakevan", "andole"),
//                    List.of("shakevan", "andole"),
//                    List.of("shakevan", "jun"),
//                    List.of("shakevan", "mrko")
//            );
//            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem7.solution(user, friends, visitors);
//            });
//        }
//        @Test
//        void case7() throws Exception { //추천할 친구가 없을 때
//            String user = "mrko";
//            List<List<String>> friends = List.of(
//                    List.of("donut", "mrko"),
//                    List.of("shakevan", "mrko")
//            );
//            List<String> visitors = List.of("donut", "shakevan");
//            Assertions.assertThrows(Exception.class, () -> {
//                Problem7.solution(user, friends, visitors);
//            });
//        }

    }
}
