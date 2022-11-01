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
        //페이지 범위가 1~400인지 테스트
        void case4() {
            List<Integer> pobi1 = List.of(-51, -50);
            List<Integer> pobi2 = List.of(0, 1);
            List<Integer> pobi3 = List.of(401, 402);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi1, crong)).isEqualTo(result);
            assertThat(Problem1.solution(pobi2, crong)).isEqualTo(result);
            assertThat(Problem1.solution(pobi3, crong)).isEqualTo(result);
        }

        @Test
        //왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수인지 테스트
        void case5() {
            List<Integer> pobi = List.of(100, 101);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        //무승부일 경우 테스트
        void case6() {
            List<Integer> pobi = List.of(121, 122);
            List<Integer> crong = List.of(211, 212);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
        @Test
        void case7() {
            List<Integer> pobi1 = List.of(1, 2);
            List<Integer> pobi2 = List.of(3, 4);
            List<Integer> crong1 = List.of(397, 398);
            List<Integer> crong2 = List.of(399, 400);
            int result = -1;
            assertThat(Problem1.solution(pobi1, crong1)).isEqualTo(result);
            assertThat(Problem1.solution(pobi2, crong2)).isEqualTo(result);
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
            //중복 문자가 3개 이상인 경우
            String cryptogram = "aaaaaaabcbc";
            String result = "bcbc";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case4() {
            //중복 문자가 3개 이상인 경우가 여러개인 경우
            String cryptogram = "aaabcbcccbcsd";
            String result = "bsd";
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
            int number = 100;
            int result = 60;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case4() {
            int number = 1;
            int result = 0;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        void case5(){
            int number = 10000;
            int result = 12000;
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
            String word = "ABCDEFGHIJKLMN opqrstuvwxyz";
            String result = "ZYXWVUTSRQPONM lkjihgfedcba";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void case3() {
            String word = "ABC알파벳 외의 문자는 변환하지 않는다.";
            String result = "ZYX알파벳 외의 문자는 변환하지 않는다.";
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

        @Test
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("abc@email.com", "가나다"),
                    List.of("bcd@email.com", "나다라"),
                    List.of("cde@email.com", "다라마"),
                    List.of("fgh@email.com", "바사아"),
                    List.of("ijk@email.com", "자차카")
            );
            List<String> result = List.of("abc@email.com", "bcd@email.com", "cde@email.com");
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
        void case5() {
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

        @Test
        void case6() {
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
