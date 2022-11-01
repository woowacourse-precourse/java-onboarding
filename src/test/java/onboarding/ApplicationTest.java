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
            List<Integer> pobi = List.of(101, 102);
            List<Integer> crong = List.of(101, 102);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case5() {
            List<Integer> pobi = List.of(99, 103);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void case7() {
            List<Integer> pobi = List.of(401, 402);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        void correctSizeTest() {
            List<Integer> pobi = List.of(111, 112, 113);
            List<Integer> crong = List.of(41, 42);

            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
        }

        @Test
        void consecutiveTest() {
            List<Integer> pobi = List.of(110, 114);
            List<Integer> crong = List.of(399, 400);

            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
        }

        @Test
        void leftOddTest() {
            List<Integer> pobi = List.of(110, 111);
            List<Integer> crong = List.of(399, 400);

            assertThat(Problem1.solution(pobi, crong)).isEqualTo(-1);
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
            String cryptogram = "aabffbabcccbbc";
            String result = "abc";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case4() {
            String cryptogram = "aaabcccbbaa";
            String result = "b";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case5() {
            String cryptogram = "lcaaaklpl";
            String result = "lcklpl";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case6() {
            String cryptogram = "lolllo";
            String result = "l";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case7() {
            String cryptogram = "lloolo";
            String result = "lo";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case8() {
            String cryptogram = "loolloopllp";
            String result = "l";
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
            int number = 334;
            int result = 230;
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
            String word = "I'm must be 1st.";
            String result = "R'n nfhg yv 1hg.";
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
            int money = 120_000;
            List<Integer> result = List.of(2, 2, 0, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        void case3() {
            int money = 34908;
            List<Integer> result = List.of(0, 3, 0, 4, 1, 4, 0, 0, 8);
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
                    List.of("lck@email.com", "한국롤리그"),
                    List.of("facker@email.com", "페이커"),
                    List.of("showmaker@email.com", "쇼메이커"),
                    List.of("bighouse@email.com", "집이커"),
                    List.of("lpl@email.com", "중국리그")
            );
            List<String> result = List.of("bighouse@email.com",
                    "facker@email.com",
                    "lck@email.com",
                    "lpl@email.com",
                    "showmaker@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("park@email.com", "박항모함"),
                    List.of("baek@email.com", "백항모함"),
                    List.of("noob@email.com", "지금모함"),
                    List.of("hangmo@email.com", "대항모"),
                    List.of("war@email.com", "대격변"),
                    List.of("airship@email.com", "항공모함"),
                    List.of("thisisright@email.com", "이거맞냐"),
                    List.of("onetwo@email.com", "맞거싶냐"),
                    List.of("mohave@email.com", "모하비모함"),
                    List.of("aircompany@email.com", "항공사망함"),
                    List.of("saddeveloper@email.com", "개발자일찍사망"),
                    List.of("zebra@email.com", "만나서반갑습니다대단히감사합니다구양배"));

            List<String> result = List.of("aircompany@email.com",
                    "airship@email.com",
                    "baek@email.com",
                    "hangmo@email.com",
                    "mohave@email.com",
                    "noob@email.com",
                    "park@email.com",
                    "saddeveloper@email.com");
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
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = List.of("bedi", "donut", "shakevan");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case3() {
            String user = "dog";
            List<List<String>> friends = List.of(
                    List.of("dog", "cat"),
                    List.of("rabbit", "cat"),
                    List.of("bird", "wolf"),
                    List.of("wolf", "bear"),
                    List.of("wolf", "dog"),
                    List.of("wolf", "person")
            );
            List<String> visitors = List.of("person", "wolf", "dear", "cat", "wolf");
            List<String> result = List.of("person", "bear", "bird", "rabbit", "dear");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case4() {
            String user = "dog";
            List<List<String>> friends = List.of(
                    List.of("dog", "cat"),
                    List.of("rabbit", "cat"),
                    List.of("bird", "cat"),
                    List.of("wolf", "bear"),
                    List.of("wolf", "dog"),
                    List.of("wolf", "person")
            );
            List<String> visitors = List.of("person", "wolf", "dear", "cat", "wolf","dear");
            List<String> result = List.of("person", "bear", "bird", "rabbit", "dear");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        void case5() {
            String user = "knife";
            List<List<String>> friends = List.of(
                    List.of("dog", "cat"),
                    List.of("rabbit", "cat"),
                    List.of("bird", "cat"),
                    List.of("wolf", "bear"),
                    List.of("wolf", "dog"),
                    List.of("wolf", "person")
            );
            List<String> visitors = List.of("person", "wolf", "dear", "cat", "wolf","dear","knife");
            List<String> result = List.of("dear", "wolf", "cat", "person");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }


    }
}
