package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
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
        @DisplayName("3일때")
        void is369TestSuccess() throws Exception {
            Method testMethod = Problem3.class.getDeclaredMethod("is369", int.class);
            testMethod.setAccessible(true);

            boolean result = (boolean) testMethod.invoke(boolean.class, 3);

            assertThat(result).isEqualTo(true);
        }

        @Test
        @DisplayName("4일때")
        void is369TestFail() throws Exception {
            Method testMethod = Problem3.class.getDeclaredMethod("is369", int.class);
            testMethod.setAccessible(true);

            boolean result = (boolean) testMethod.invoke(boolean.class, 4);

            assertThat(result).isEqualTo(false);
        }

        @Test
        @DisplayName("369 카운트 - 33일때")
        void count369InNumberTwo() throws Exception {
            Method testMethod = Problem3.class.getDeclaredMethod("count369InNumber", int.class);
            testMethod.setAccessible(true);

            //given
            int test = 33;

            //when
            int result = (int) testMethod.invoke(int.class, test);

            //then
            assertThat(result).isEqualTo(2);
        }

        @Test
        @DisplayName("369 카운트 - 14일때")
        void count369InNumberZero() throws Exception {
            Method testMethod = Problem3.class.getDeclaredMethod("count369InNumber", int.class);
            testMethod.setAccessible(true);

            //given
            int test = 14;

            //when
            int result = (int) testMethod.invoke(int.class, test);

            //then
            assertThat(result).isEqualTo(0);
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
        void changeUpperCase() throws Exception {
            Method testMethod = Problem4.class.getDeclaredMethod("changeUpperCaseChar", char.class);
            testMethod.setAccessible(true);

            //given
            char test = 'B';
            //when
            char result = (char) testMethod.invoke(char.class, test);
            //then
            assertThat(result).isEqualTo('Y');
        }

        @Test
        void changeLowerCase() throws Exception {
            Method testMethod = Problem4.class.getDeclaredMethod("changeLowerCaseChar", char.class);
            testMethod.setAccessible(true);

            //given
            char test = 'b';
            //when
            char result = (char) testMethod.invoke(char.class, test);
            //then
            assertThat(result).isEqualTo('y');
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

        @Test
        @DisplayName("추천가능한 사람이 5보다 많을때")
        void case2() {
            String user = "a";
            List<List<String>> friends = List.of(
                    List.of("a", "b"),
                    List.of("b", "c"),
                    List.of("b", "d"),
                    List.of("b", "e"),
                    List.of("b", "f"),
                    List.of("b", "g"),
                    List.of("b", "h")
            );
            List<String> visitors = List.of("f", "f", "d");
            List<String> result = List.of("f", "d", "c", "e", "g");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
