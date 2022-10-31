package onboarding;

import org.junit.jupiter.api.*;

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
        @DisplayName("시작 면이나 마지막 면이 나도록 책을 펼친 경우")
        void whenOpenedFirstOrLastPage() {
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(399, 400);
            int result = -1;
            Assertions.assertEquals(result, Problem1.solution(pobi,crong), "첫페이지나 마지막 페이지 오픈 금지");
        }

        @Test
        @DisplayName("페이지가 차이가 1이 아닌 경우")
        void whenPagesAreNotNumber() {
            List<Integer> pobi = List.of(3,6);
            List<Integer> crong = List.of(8, 10);
            int result = -1;
            Assertions.assertEquals(result, Problem1.solution(pobi,crong), "페이지 차이가 1 이상시 -1 반환해야함");
        }

        @Test
        @DisplayName("페이지 숫자가 1~400을 벗어나는 경우")
        void whenPagesAreOutOfBound () {
            List<Integer> pobi = List.of(-1, 0);
            List<Integer> crong = List.of(400, 401);
            int result = -1;
            Assertions.assertEquals(result, Problem1.solution(pobi,crong), "오른쪽 페이지가 값이 작을 경우 -1 반환해야함");
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
        @DisplayName("연속 하는 중복된 문자가 떨어져 있을 경우")
        void testForSeparateDuplicateCharacter() {
            String cryptogram = "acccabba";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
        @Test
        @DisplayName("연속하는 중복문자가 주어질 경우 완전 삭제")
        void testForConsecutiveDuplicateCharacter() {
            String cryptogram = "zyellleeyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    @TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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
        @Order(1)
        @DisplayName("3이 포함될 때 손뼉을 치는지")
        void testForClapOnThree() {
            int number = 3;
            int expected = 1;
            Assertions.assertEquals(expected, Problem3.solution(3), "Should return 1");
        }

        @Test
        @Order(2)
        @DisplayName("6이 포함될 때 손뼉을 치는지")
        void testForClapOnSix() {
            int number = 6;
            int expected = 2;
            Assertions.assertEquals(expected, Problem3.solution(6), "Should return 2");
        }

        @Test
        @Order(3)
        @DisplayName("9가 포함될 때 손뼉을 치는지")
        void testForClapOnNine() {
            int number = 9;
            int expected = 3;
            Assertions.assertEquals(expected, Problem3.solution(9), "Should return 3");
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
        @DisplayName("word가 알파벳이 아닌 경우")
        void whenWordIsNotAlphabet() {
            String word = "123456789012";
            String expected = "123456789012";
            Assertions.assertEquals(expected, Problem4.solution(word), "should not convert without alphabet");
        }

        @Test
        @DisplayName("word가 대문자일 경우")
        void testForLowerCase() {
            String word = "iloveyou";
            String expected = "rolevblf";
            Assertions.assertEquals(expected, Problem4.solution(word), "should convert to upper case");
        }

        @Test
        @DisplayName("word가 소문자일 경우")
        void testForUpperCase() {
            String word = "ILOVEYOU";
            String expected = "ROLEVBLF";
            Assertions.assertEquals(expected, Problem4.solution(word), "should convert to lower case");
        }

        @Test
        @DisplayName("word에 숫자, 대문자 소문자가 섞여있을 경우")
        void testForMixedWord() {
            String word = "123I loVe you";
            String expected = "123R olEv blf";
            Assertions.assertEquals(expected, Problem4.solution(word), "should follw the rule");
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
        @DisplayName("오 만원 테스트")
        void testFor50_000Won() {
            int money = 100_000;
            List<Integer> expected = List.of(2, 0, 0, 0, 0, 0, 0, 0, 0);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 2 of 50_000");
        }
        @Test
        @DisplayName("일 만원 테스트")
        void testFor10_000Won() {
            int money = 30_000;
            List<Integer> expected = List.of(0, 3, 0, 0, 0, 0, 0, 0, 0);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 3 of 10_000");
        }
        @Test
        @DisplayName("오 천원 테스트")
        void testFor5_000Won() {
            int money = 5_000;
            List<Integer> expected = List.of(0, 0, 1, 0, 0, 0, 0, 0, 0);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 1 of 5_000");
        }
        @Test
        @DisplayName("일 천원 테스트")
        void testFor1_000Won() {
            int money = 3_000;
            List<Integer> expected = List.of(0, 0, 0, 3, 0, 0, 0, 0, 0);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 3 of 1_000");
        }
        @Test
        @DisplayName("오 백원 테스트")
        void testFor500Won() {
            int money = 500;
            List<Integer> expected = List.of(0, 0, 0, 0, 1, 0, 0, 0, 0);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 1 of 500");
        }
        @Test
        @DisplayName("일 백원 테스트")
        void testFor100Won() {
            int money = 200;
            List<Integer> expected = List.of(0, 0, 0, 0, 0, 2, 0, 0, 0);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 2 of 100");
        }
        @Test
        @DisplayName("오 십원 테스트")
        void testFor50Won() {
            int money = 50;
            List<Integer> expected = List.of(0, 0, 0, 0, 0, 0, 1, 0, 0);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 1 of 50");
        }
        @Test
        @DisplayName("일 십원 테스트")
        void testFor10Won() {
            int money = 30;
            List<Integer> expected = List.of(0, 0, 0, 0, 0, 0, 0, 3, 0);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 3 of 10");
        }     @Test
        @DisplayName("일 원 테스트")
        void testFor1Won() {
            int money = 2;
            List<Integer> expected = List.of(0, 0, 0, 0, 0, 0, 0, 0, 2);
            Assertions.assertIterableEquals(expected, Problem5.solution(money), "shoud return 2 of 1");
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
        @DisplayName("연속되는 같은 글자가 두 개 이상일 경우")
        void whenConsecutiveletterMoreThanOne() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠"),
                    List.of("mga@email.com", "제엠가")
            );
            List<String> expected = List.of("jason@email.com", "jm@email.com", "mga@email.com", "mj@email.com", "nowm@email.com");
            Assertions.assertIterableEquals(expected, Problem6.solution(forms), "연속되는 같은 글자가 두 개 이상일 경우");
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
        @DisplayName("mrko가 shakevan 대신 andole과 친구일 때")
        void whenMrkoIsFriendWithAndoleNotShakevan() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("andole", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> expected = List.of("bedi", "shakevan");
            Assertions.assertIterableEquals(expected,Problem7.solution(user, friends, visitors), "bedi와 shakevan을 반환" );
        }

    }
}
