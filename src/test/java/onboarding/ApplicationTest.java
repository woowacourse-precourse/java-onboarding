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
        @DisplayName("case1: 정상 - pobi 승리")
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("case2: 정상 - 무승부")
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("case3: 제한사항 - 연속 페이지 순서")
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 1: 정상 - crong 승리")
        void customCase1() {
            List<Integer> pobi = List.of(199, 200);
            List<Integer> crong = List.of(298, 299);
            int result = 2;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 2: 제한사항 - 시작페이지")
        void customCase2() {
            List<Integer> pobi = List.of(0, 1);
            List<Integer> crong = List.of(101, 102);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 3: 제한사항 - 마지막페이지")
        void customCase3() {
            List<Integer> pobi = List.of(200, 201);
            List<Integer> crong = List.of(400, 401);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 4: 제한사항 - 페이지 순서")
        void customCase4() {
            List<Integer> pobi = List.of(200, 201);
            List<Integer> crong = List.of(401, 400);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        @DisplayName("case1: 정상 - browoanoommnaon -> brown")
        void case1() {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("case2: 정상 - zyelleyz -> ")
        void case2() {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 1: 정상 - xyxxkababb -> xykaba")
        void customCase1() {
            String cryptogram = "xyxxkababb";
            String result = "xykaba";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 2: 제한사항 - gSggsk")
        void customCase2() {
            String cryptogram = "gSggsk";
            String result = "gSggsk";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 3: 제한사항 - cryptogram 길이")
        void customCase3() {
            StringBuilder cryptogram = new StringBuilder();
            cryptogram.append("a".repeat(1001));
            String result = cryptogram.toString();
            assertThat(Problem2.solution(cryptogram.toString())).isEqualTo(result);
        }
    }

    @Nested
    class Problem3Test {
        @Test
        @DisplayName("case1: 정상 - 13 -> 4")
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        @DisplayName("case2: 정상 - 33 -> 14")
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 1: 정상 - 333 -> 228")
        void customCase1() {
            int number = 333;
            int result = 228;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 2: 제한사항 - 최솟값")
        void customCase2() {
            int number = 0;
            int result = 0;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 3: 제한사항 - 최댓값")
        void customCase3() {
            int number = 10001;
            int result = 10001;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        @DisplayName("case1: 정상 - I love you -> R olev blf")
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 1: 정상 - 1a2b3c4d5 -> 1z2y3x4w5")
        void customCase1() {
            String word = "1a2b3c4d5";
            String result = "1z2y3x4w5";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 2: 제한사항 - 문자열 길이")
        void customCase2() {
            StringBuilder word = new StringBuilder();
            word.append("a".repeat(1001));
            String result = word.toString();
            assertThat(Problem4.solution(word.toString())).isEqualTo(result);
        }
    }

    @Nested
    class Problem5Test {
        @Test
        @DisplayName("case1: 정상 - 50237 -> 1 0 0 0 0 2 0 3 7")
        void case1() {
            int money = 50_237;
            List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        @DisplayName("case2: 정상 - 15000 -> 0 1 1 0 0 0 0 0 0")
        void case2() {
            int money = 15_000;
            List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 1: 정상 - 654321 -> 13 0 0 4 0 3 0 2 1")
        void customCase1() {
            int money = 654_321;
            List<Integer> result = List.of(13, 0, 0, 4, 0, 3, 0, 2, 1);
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 2: 제한사항 - 최솟값")
        void customCase2() {
            int money = 0;
            List<Integer> result = null;
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 3: 제한사항 - 최댓값")
        void customCase3() {
            int money = 1000001;
            List<Integer> result = null;
            assertThat(Problem5.solution(money)).isEqualTo(result);
        }
    }

    @Nested
    class Problem6Test {
        @Test
        @DisplayName("case1: 정상 - '제이'")
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
        @DisplayName("Custom case 1: 정상 - '제이', '이제'")
        void customCase1() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "이제"),
                    List.of("jason@email.com", "제이"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "nowm@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 2: 제한사항 - 이메일 형식")
        void customCase2() {
            List<List<String>> forms = List.of(
                    List.of("jm#email.com", "이제"),
                    List.of("jason@email.com", "제이")
            );
            List<String> result = null;
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 3: 제한사항 - 이메일 도메인")
        void customCase3() {
            List<List<String>> forms = List.of(
                    List.of("jm@naver.com", "이제"),
                    List.of("jason@email.com", "제이")
            );
            List<String> result = null;
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 4: 제한사항 - 한글 닉네임")
        void customCase4() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "Jay"),
                    List.of("jason@email.com", "제이")
            );
            List<String> result = null;
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }
    }

    @Nested
    class Problem7Test {
        @Test
        @DisplayName("case1: 정상")
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
        @DisplayName("Custom case 1: 정상")
        void customCase1() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "jun"),
                    List.of("donut", "gwan"),
                    List.of("donut", "su"),
                    List.of("donut", "mrko"),
                    List.of("shakevan", "andole"),
                    List.of("shakevan", "jun"),
                    List.of("shakevan", "gwan"),
                    List.of("shakevan", "su"),
                    List.of("shakevan", "mrko")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "apple", "apple", "apple");
            List<String> result = List.of("andole", "gwan", "jun", "su", "apple");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 2: 제한사항 - friends의 각 원소의 크기 == 2")
        void customCase2() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "mrko"),
                    List.of("donut", "gwan", "su")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = null;
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        @DisplayName("Custom case 3: 제한사항 - 아이디는 알파벳 소문자")
        void customCase3() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                    List.of("donut", "andole"),
                    List.of("donut", "mrko"),
                    List.of("donut", "GWAN")
            );
            List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
            List<String> result = null;
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
