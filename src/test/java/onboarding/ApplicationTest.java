package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        @DisplayName("비기는 경우 - 135점")
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("포비가 이기는 경우 - 포비: 5 + 6 = 11 크롱: 4 + 5 = 9")
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("잘못된 페이지 들어오는 경우 - 연속된 페이지 아님")
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("잘못된 페이지 들어오는 경우 - 연속된 페이지 아님2")
        void case4() {
            List<Integer> pobi = List.of(99, 103);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("포비가 이기는 경우 - 포비: 243 + 0 = 243 크롱: 4 + 5 = 9")
        void case5() {
            List<Integer> pobi = List.of(399, 400);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("잘못된 페이지 들어오는 경우 - 400 페이지 초과")
        void case6() {
            List<Integer> pobi = List.of(400, 401);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("잘못된 페이지 들어오는 경우 - 음수 페이지")
        void case7() {
            List<Integer> pobi = List.of(99, 100);
            List<Integer> crong = List.of(-1, 0);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("크롱이 이기는 경우 - 포비: 6 + 8 = 14 크롱: 72 + 0 = 72")
        void case8() {
            List<Integer> pobi = List.of(123, 124);
            List<Integer> crong = List.of(89, 90);
            int result = 2;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        @DisplayName("\"browoanoommnaon\" -> \"browoannaon\" -> \"browoaaon\" -> \"browoon\" -> \"brown\"")
        void case1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("\"zyelleyz\" -> \"zyeeyz\" -> \"zyyz\" -> \"zz\" -> \"\"")
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("\"a\"")
        void case3() {
            String cryptogram = "a";
            String result = "a";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("\"abbawe\" -> \"aawe\" -> \"we\"")
        void case4() {
            String cryptogram = "abbawe";
            String result = "we";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("\"aaa\" -> \"\"")
        void case5() {
            String cryptogram = "aaa";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("\"baaabbn\" -> \"bn\"")
        void case6() {
            String cryptogram = "baaabbn";
            String result = "bn";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {
        @Test
        @DisplayName("3 6 9 13")
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        @DisplayName("3 6 9 13 16 19 23 26 29 30 31 32 33")
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        @DisplayName("x")
        void case3() {
            int number = 1;
            int result = 0;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        @DisplayName("조금 긴 테스트")
        void case4() {
            int number = 40;
            int result = 22;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        @DisplayName("많이 긴 테스트")
        void case5() {
            int number = 333;
            int result = 228;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    @DisplayName("AZ | BY | CX | DW | EV | FU | GT | HS | IR | JQ | KP | LO | MN")
    class Problem4Test {
        @Test
        @DisplayName("I(R) love(olev) you(blf)")
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        @DisplayName("빈 문자열 테스트")
        void case2() {
            String word = "";
            String result = "";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        @DisplayName("Hello(Svool) Everyone!(Veviblmv!)")
        void case3() {
            String word = "Hello  Everyone!";
            String result = "Svool  Veviblmv!";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        @DisplayName("전체 테스트")
        void case4() {
            String word = "?abcdefghijklmnopqrstuvwxyz\nZYXWVUTSRQPONMLKJIHGFEDCBA!";
            String result = "?zyxwvutsrqponmlkjihgfedcba\nABCDEFGHIJKLMNOPQRSTUVWXYZ!";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        @DisplayName("50237 -> 50000 + (2 * 100) + (3 * 10) + (7 * 1)")
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        @DisplayName("15000 -> 10000 + 5000")
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        @DisplayName("'제이'엠, '제이'슨, 엠'제이'")
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
        @DisplayName("중복 없는 케이스")
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("e@email.com", "중복이"),
                    List.of("b@email.com", "하나도"),
                    List.of("a@email.com", "되지않는"),
                    List.of("d@email.com", "테스트"),
                    List.of("c@email.com", "케이스")
            );
            List<String> result = List.of();
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        @DisplayName("이메일 오름차순 테스트")
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("e@email.com", "알파벳순으로정렬되는지확인하는테스트"),
                    List.of("b@email.com", "알파벳순으로정렬되는지확인하는테스트"),
                    List.of("a@email.com", "알파벳순으로정렬되는지확인하는테스트"),
                    List.of("aa@email.com", "알파벳순으로정렬되는지확인하는테스트"),
                    List.of("d@email.com", "알파벳순으로정렬되는지확인하는테스트"),
                    List.of("c@email.com", "알파벳순으로정렬되는지확인하는테스트")
            );
            List<String> result = List.of("a@email.com", "aa@email.com", "b@email.com", "c@email.com", "d@email.com", "e@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        @DisplayName("이메일 중복 제거 테스트")
        void case4() {
            List<List<String>> forms = List.of(
                    List.of("e@email.com", "중복완전많이"),
                    List.of("b@email.com", "되는닉네임"),
                    List.of("a@email.com", "중복"),
                    List.of("aa@email.com", "완전"),
                    List.of("d@email.com", "많이"),
                    List.of("c@email.com", "되는")
            );
            List<String> result = List.of("a@email.com", "aa@email.com", "b@email.com", "c@email.com", "d@email.com", "e@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        @DisplayName("한 명 테스트")
        void case5() {
            List<List<String>> forms = List.of(
                    List.of("onlyme@email.com", "교육생이한명")
            );
            List<String> result = List.of();
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

    }

    @Nested
    class Problem7Test {
        @Test
        @DisplayName("andole: 20, jun: 20, bedi: 3")
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
        @DisplayName("andole: 10, bedi: 3")
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
        @DisplayName("andole: 20, bedi: 3")
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
        @DisplayName("andole: 20, bedi: 20")
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
        @DisplayName("donut: 11, anne: 10, bedi: 10, mrko: 1, peter: 1 / sam: 1")
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
        @DisplayName("sam: 21, shakevan: 20, anne: 11, kane: 10, mrko: 2 / donut: 1")
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
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        @DisplayName("유저 친구 없는 경우: mrko: 2, anne: 1, donut: 1, sam: 1")
        void case7() {
            String user = "hello";
            List<List<String>> friends = List.of(
                    List.of("andole", "jun"),
                    List.of("andole", "bedi"),
                    List.of("jun", "shakevan"),
                    List.of("jun", "kane"),
                    List.of("bedi", "shakevan"),
                    List.of("bedi", "anne")
            );
            List<String> visitors = List.of("donut", "anne", "mrko", "mrko", "sam");
            List<String> result = List.of("mrko", "anne", "donut", "sam");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
