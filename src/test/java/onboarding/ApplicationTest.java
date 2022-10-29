package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest {
    @Nested
    class Problem1Test {
        @Test
        @DisplayName("무승부 테스트")
        void case1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("포비가 이긴다")
        void case2() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(211, 212);
            int result = 1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("예외: 연속되는 숫자가 오지 않았다")
        void case3() {
            List<Integer> pobi = List.of(99, 102);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("예외: 1보다 작은 페이지가 들어갔다")
        void case4() {
            List<Integer> pobi = List.of(0, 1);
            List<Integer> crong = List.of(211, 212);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("예외: 400페이지보다 큰 페이지가 들어갔다")
        void case5() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(401, 402);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("예외: 홀수 페이지부터 시작하지 않았다")
        void case6() {
            List<Integer> pobi = List.of(131, 132);
            List<Integer> crong = List.of(202, 203);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }
    }

    @Nested
    class Problem2Test {
        @Test
        void case1() throws Exception {
            String cryptogram = "browoanoommnaon";
            String result = "brown";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() throws Exception {
            String cryptogram = "zyelleyz";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        @DisplayName("대문자가 입력되면 예외를 반환한다")
        void case3() {
            String cryptogram = "zyelleZyz";
            assertThatThrownBy(() -> Problem2.solution(cryptogram)).isInstanceOf(Exception.class);

        }

        @Test
        @DisplayName("숫자가 입력되면 예외를 반환한다")
        void case4() {
            String cryptogram = "zyell0eyz";
            assertThatThrownBy(() -> Problem2.solution(cryptogram)).isInstanceOf(Exception.class);

        }

        @Test
        @DisplayName("길이가 1000보다 크면 예외를 반환한다")
        void case5() {
            String cryptogram = "z".repeat(1001);
            assertThatThrownBy(() -> Problem2.solution(cryptogram)).isInstanceOf(Exception.class);
        }

        @Test
        @DisplayName("길이가 1보다 작으면 예외를 반환한다")
        void case6() {
            String cryptogram = "";
            assertThatThrownBy(() -> Problem2.solution(cryptogram)).isInstanceOf(Exception.class);

        }
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
    }

    @Nested
    class Problem4Test {
        @Test
        void case1() throws Exception {
            String word = "I love you";
            String result = "R olev blf";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void case2() throws Exception {
            String word = "ABCDEFG2HI";
            String result = "ZYXWVUT2SR";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }

        @Test
        void case3() throws Exception {
            String word = "@";
            String result = "@";
            assertThat(Problem4.solution(word)).isEqualTo(result);
        }
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
    }

    @Nested
    class Problem6Test {
        @Test
        @DisplayName("정상적인 결과를 출력한다")
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
        @DisplayName("크루가 10_000명 초과한 경우 예외를 반환한다")
        void case2() {
            List<List<String>> forms = new ArrayList<>();
            for(int i=0;i<10001;i++) {
                forms.add(List.of(i+"ja@email.com", "이름"+i));
            }
            assertThatThrownBy(() -> Problem6.solution(forms)).isInstanceOf(Exception.class);
        }

        @Test
        @DisplayName("크루가 1명 미만인 경우 예외를 반환한다")
        void case3() {
            List<List<String>> forms = List.of();
            assertThatThrownBy(() -> Problem6.solution(forms)).isInstanceOf(Exception.class);

        }

        @Test
        @DisplayName("이메일이 11자보다 작으면 예외를 반환한다")
        void case4() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("@email.com", "워니"), //10자
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            assertThatThrownBy(() -> Problem6.solution(forms)).isInstanceOf(Exception.class);

        }

        @Test
        @DisplayName("이메일이 20자보다 크면 예외를 반환한다")
        void case5() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jasonjason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowmsnowms1@email.com", "이제엠") // 21자
            );
            assertThatThrownBy(() -> Problem6.solution(forms)).isInstanceOf(Exception.class);
        }

        @Test
        @DisplayName("이메일이 @email.com으로 끝나지 않으면 예외를 반환한다")
        void case6() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@emil.com", "제이슨"), //@email.com 아님
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            assertThatThrownBy(() -> Problem6.solution(forms)).isInstanceOf(Exception.class);
        }

        @Test
        @DisplayName("이메일이 중복되면 예외를 반환한다")
        void case7() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"), //중복
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("jason@email.com", "이제엠") //중복
            );
            assertThatThrownBy(() -> Problem6.solution(forms)).isInstanceOf(Exception.class);
        }

        @Test
        @DisplayName("이메일에 영소문자, 숫자 이외 들어가면 예외를 반환한다")
        void case8() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠"),
                    List.of("jason@email.com", "제이슨"),
                    List.of("wOniee@email.com", "워니"), //대문자 들어감
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            assertThatThrownBy(() -> Problem6.solution(forms)).isInstanceOf(Exception.class);
        }

        @Test
        @DisplayName("닉네임에 한글 이외가 들어가면 예외를 반환한다")
        void case9() {
            List<List<String>> forms = List.of(
                    List.of("jm@email.com", "제이엠0"), //한글 이외 들어감
                    List.of("jason@email.com", "제이슨"),
                    List.of("woniee@email.com", "워니"),
                    List.of("mj@email.com", "엠제이"),
                    List.of("nowm@email.com", "이제엠")
            );
            assertThatThrownBy(() -> Problem6.solution(forms)).isInstanceOf(Exception.class);
        }

        //TODO 정상결과를 조금 더 만들어주자
        // 이메일 20자일때, 11글자일때
        // 한글이름 1자일때, 19자일떄
        // 이메일에 숫자 들어갈때
        // 한글닉네임 중복이 아무도 없을떄
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
