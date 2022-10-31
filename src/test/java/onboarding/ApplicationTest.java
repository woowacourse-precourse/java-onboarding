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
        @Test
        void 추천할_친구수가_5명을_넘을경우() {
            String user = "mrko";
            List<List<String>> friends = List.of(
              List.of("donut", "mrko"),
              List.of("shakevan", "mrko"),
              List.of("baemin", "mrko"),
              List.of("shakevan", "a"),
              List.of("shakevan", "b"),
              List.of("shakevan", "c"),
              List.of("shakevan", "d"),
              List.of("shakevan", "e"),
              List.of("shakevan", "f"),
              List.of("shakevan", "g"),
              List.of("donut", "a"),
              List.of("donut", "b"),
              List.of("donut", "c"),
              List.of("donut", "d"),
              List.of("donut", "e"),
              List.of("donut", "f"),
              List.of("baemin", "a"),
              List.of("baemin", "b"),
              List.of("baemin", "c"),
              List.of("baemin", "d"),
              List.of("baemin", "e")
            );
            List<String> visitors = List.of("donut", "shakevan");
            List<String> result = List.of("a","b","c","d","e");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
        @Test
        void 점수가_높은순으로_정렬되어있는가() {
            String user = "mrko";
            List<List<String>> friends = List.of(
              List.of("donut", "mrko"),
              List.of("shakevan", "mrko"),
              List.of("baemin", "mrko"),
              List.of("shakevan", "g"),
              List.of("shakevan", "f"),
              List.of("shakevan", "e"),
              List.of("shakevan", "d"),
              List.of("shakevan", "c"),
              List.of("shakevan", "b"),
              List.of("shakevan", "a"),
              List.of("donut", "f"),
              List.of("donut", "e"),
              List.of("donut", "d"),
              List.of("donut", "c"),
              List.of("donut", "b"),
              List.of("donut", "a"),
              List.of("baemin", "e"),
              List.of("baemin", "d"),
              List.of("baemin", "c"),
              List.of("baemin", "b"),
              List.of("baemin", "a")
            );
            List<String> visitors = List.of("donut", "shakevan", "e", "e", "e", "e", "d", "d", "d", "c", "c", "b");
            List<String> result = List.of("e","d","c","b","a");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
        @Test
        void 점수가_같을경우_이름순으로_정렬되었는가(){
            String user = "mrko";
            List<List<String>> friends = List.of(
              List.of("v", "mrko"),
              List.of("w", "mrko"),
              List.of("x", "mrko"),
              List.of("y", "mrko"),
              List.of("z", "mrko"),
              List.of("z", "c"),
              List.of("y", "e"),
              List.of("x", "d"),
              List.of("w", "b"),
              List.of("v", "a")
            );
            List<String> visitors = List.of();
            List<String> result = List.of("a","b","c","d","e");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
