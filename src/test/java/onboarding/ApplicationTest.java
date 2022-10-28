package onboarding;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ApplicationTest {
    @Nested
    @DisplayName("문제 1 테스트")
    class Problem1Test {
        @Test
        @DisplayName("최고 점수가 같을 때 0을 반환")
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("포비의 최고 점수가 더 높을 때 1 반환")
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("비정상적인 입력값 - 페이지 수가 연속되지 않음")
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("비정상적인 입력값 - 왼쪽 페이지가 홀수가 아님")
        void case3_5() {
            List<Integer> pobi = List.of(100, 101);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("오른쪽에서 왼쪽으로 읽는 책의 경우 왼쪽 페이지의 숫자가 더 클 수 있음")
        void case3_6() {
            List<Integer> pobi = List.of(101, 100);
            List<Integer> crong = List.of(211, 212);
            int result = 2;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("크롱의 최고 점수가 더 높을 때 2 반환")
        void case4() {
            List<Integer> pobi = List.of(211, 212);
            List<Integer> crong = List.of(131, 132);
            int result = 2;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("비정상적인 입력값 - 첫 번째 페이지 이하로 책을 펼칠 수 없음")
        void case5() {
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("비정상적인 입력값 - 마지막 페이지 이상으로 책을 펼칠 수 없음")
        void case6() {
            List<Integer> pobi = List.of(399, 400);
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

        @Test
        @DisplayName("연속된 문자 3개")
        void case3() {
            String cryptogram = "bannnana";
            String result = "bna";
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
            int number = 49;
            int result = 25;
            assertThat(Problem3.solution(number)).isEqualTo(result);
        }
    }

    @Nested
    class Problem4Test {
        @Test
        @DisplayName("대문자는 대문자로, 소문자는 소문자로")
        void case1() {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        @DisplayName("알파벳 외 문자는 변환하지 않는다.")
        void case2() {
            String word = "$aVe ¥0U";
            String result = "$zEv ¥0F";
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
        @DisplayName("십만 단위의 돈 또한 정확히 계산한다.")
        void case3() {
            int money = 600_500;
            List<Integer> result = List.of(12, 0, 0, 0, 1, 0, 0, 0, 0);
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
        @DisplayName("세 글자 이상 겹치는 경우에도 정상적으로 작동한다.")
        void case2() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "롬뭄무야"),
                    List.of("jason@email.com", "이뭄무야"),
                    List.of("woniee@email.com", "이박사"),
                    List.of("mj@email.com", "삼성증권이사장"),
                    List.of("nowm@email.com", "증성증권차장님"),
                    List.of("baak@email.com", "빡빡이아조씨")
            );
            List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com", "nowm@email.com");
            assertThat(Problem6.solution(forms)).isEqualTo(result);
        }

        @Test
        @DisplayName("result 는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.")
        void case3() {
            List<List<String>> forms = List.of(
                    List.of("A@email.com", "간장게장"),
                    List.of("B@email.com", "간장게장"),
                    List.of("D@email.com", "간장게장"),
                    List.of("D@email.com", "간장게장"),
                    List.of("D@email.com", "간장게장"),
                    List.of("F@email.com", "간장게장")
            );
            List<String> result = List.of("A@email.com", "B@email.com", "D@email.com", "F@email.com");
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
        @DisplayName("추천할 친구가 없는 경우는 주어지지 않는다.")
        void case2() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                List.of("donut", "mrko"),
                List.of("shakevan", "mrko"),
                List.of("melon", "mrko"),
                List.of("mrko", "apple"),
                List.of("banana", "mrko")
            );
            List<String> visitors = List.of("apple", "apple", "donut", "shakevan");
            List<String> result = List.of();
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }

        @Test
        @DisplayName("추천 점수가 같은 경우는 이름순으로 정렬한다.")
        void case3() {
            String user = "mrko";
            List<List<String>> friends = List.of(
                List.of("A", "mrko"),
                List.of("A", "C"),
                List.of("B", "A"),
                List.of("B", "D"),
                List.of("A", "E")
            );
            List<String> visitors = List.of("C", "B", "E");
            List<String> result = List.of("B", "C", "E");
            assertThat(Problem7.solution(user, friends, visitors)).isEqualTo(result);
        }
    }
}
