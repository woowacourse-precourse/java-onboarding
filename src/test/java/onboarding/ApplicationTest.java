package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static onboarding.Problem6.EMAIL_DOMAIN;
import static onboarding.Problem6.MAX_NUM_OF_CREWS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        @DisplayName("1(첫) 페이지를 열었을 경우")
        void openFirstPage() {
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("400(마지막) 페이지를 열었을 경우")
        void openLastPage() {
            List<Integer> pobi = List.of(6, 7);
            List<Integer> crong = List.of(399, 400);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("페이지의 개수가 2가 아닐 경우")
        void invalidPageSize() {
            List<Integer> pobi = List.of(101, 102, 103);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("left 가 홀수가 아닐 경우")
        void isNotOddLeftPage() {
            List<Integer> pobi = List.of(20, 22);
            List<Integer> crong = List.of(212, 214);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("right 가 짝수가 아닐 경우")
        void isNotEvenRightPage() {
            List<Integer> pobi = List.of(21, 23);
            List<Integer> crong = List.of(211, 213);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("right < left 일 경우")
        void rightLessThanLeft() {
            List<Integer> pobi = List.of(21, 20);
            List<Integer> crong = List.of(211, 210);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("값의 범위를 벗어나는 경우 - down")
        void outOfRangeDown() {
            List<Integer> pobi = List.of(-1, 0);
            List<Integer> crong = List.of(211, 213);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("값의 범위를 벗어나는 경우 - up")
        void outOfRangeUp() {
            List<Integer> pobi = List.of(11, 12);
            List<Integer> crong = List.of(401, 402);
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
            String cryptogram = "aa";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case4() {
            String cryptogram = "aba";
            String result = "aba";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case5() {
            String cryptogram = "abbac";
            String result = "c";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case6() {
            String cryptogram = "aabbccc";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case7() {
            String cryptogram = "nmmnn";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case8() {
            String cryptogram = "z";
            String result = "z";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case9() {
            String cryptogram = "aabbccddee".repeat(100);
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void invalidCryptogramNotAlphabet() {
            String cryptogram = "!@#$%^&*1234567890";
            assertThatThrownBy(() -> Problem2.solution(cryptogram))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void invalidCryptogramUpperCase() {
            String cryptogram = "AABBCC";
            assertThatThrownBy(() -> Problem2.solution(cryptogram))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void invalidCryptogramEmpty() {
            String cryptogram = "";
            assertThatThrownBy(() -> Problem2.solution(cryptogram))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void invalidCryptogramTooLong() {
            String cryptogram = "a".repeat(1001);
            assertThatThrownBy(() -> Problem2.solution(cryptogram))
                    .isInstanceOf(IllegalArgumentException.class);
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
        void outOfRangeDown() {
            int number = 0;
            assertThatThrownBy(() -> Problem3.solution(number))
                    .isInstanceOfAny(IllegalArgumentException.class);
        }

        @Test
        void outOfRangeUp() {
            int number = 10001;
            assertThatThrownBy(() -> Problem3.solution(number))
                    .isInstanceOfAny(IllegalArgumentException.class);
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
        void allUpperCase() {
            String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String result = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void allLowerCase() {
            String word = "abcdefghijklmnopqrstuvwxyz";
            String result = "zyxwvutsrqponmlkjihgfedcba";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void maxLengthWord() {
            String word = "a".repeat(1000);
            String result = "z".repeat(1000);
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void includeNotAlphabet() {
            String word = "zZ !@#$%^&*()-=_+[]{}:<>,./? 1234567890 aA";
            String result = "aA !@#$%^&*()-=_+[]{}:<>,./? 1234567890 zZ";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void invalidWordEmpty() {
            String word = "";
            assertThatThrownBy(() -> Problem4.solution(word))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void invalidWordTooLong() {
            String word = "a".repeat(1001);
            assertThatThrownBy(() -> Problem4.solution(word))
                    .isInstanceOf(IllegalArgumentException.class);
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
        void edgeCaseDown() {
            int money = 1;
            List<Integer> result = List.of(0, 0, 0, 0, 0, 0, 0, 0, 1);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void edgeCaseUp() {
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
            List<List<String>> forms = new ArrayList<>();
            List<String> result = new ArrayList<>();
            for (int i = 0; i < MAX_NUM_OF_CREWS; i++) {
                forms.add(List.of("a" + i + EMAIL_DOMAIN, "가나다라마거너더러머고노도로모구누두루"));
                result.add("a" + i + EMAIL_DOMAIN);
            }
            Collections.sort(result);

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
