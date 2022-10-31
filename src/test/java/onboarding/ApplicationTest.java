package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

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
        @DisplayName("리스트나 배열의 길이가 2인지 검증")
        void testValidateListSize() {
            List<Integer> pobi = List.of(3, 4);
            List<Integer> crong = List.of(197, 198);

            assertThat(pobi).hasSize(2);
            assertThat(crong).hasSize(2);
        }

        @Test
        @DisplayName("두 페이지 정보가 연속된 자연수인지 검증 : 성공")
        void testValidateContinuousPages1() {
            List<Integer> pobi = List.of(97, 98);
            List<Integer> crong = List.of(197, 198);
            int result = 0;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("두 페이지 정보가 연속된 자연수인지 검증 : -1")
        void testValidateContinuousPages2() {
            List<Integer> pobi = List.of(95, 98);
            List<Integer> crong = List.of(197, 198);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("첫 번째 원소가 홀수인지 검증: -1")
        void testValidateContinuousPages3() {
            List<Integer> pobi = List.of(96, 97);
            List<Integer> crong = List.of(197, 198);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("1번 페이지나, 400번째 페이지를 하나라도 포함하는지 검증 : -1")
        void testValidateNotFirstOrLastPages1() {
            List<Integer> pobi = List.of(1, 2);
            List<Integer> crong = List.of(35, 36);
            int result = -1;
            assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
        }

        @Test
        @DisplayName("1번 페이지나, 400번째 페이지를 하나라도 포함하는지 검증 : -1")
        void testValidateNotFirstOrLastPages2() {
            List<Integer> pobi = List.of(55, 56);
            List<Integer> crong = List.of(399, 400);
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
        void should_ThrowException_ForInvalidLength() {
            String cryptogram = "";
            assertThatThrownBy(() -> Problem2.validateLength(cryptogram))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("허용되지 않은 길이의 문자열입니다.");
        }

        @Test
        void should_ThrowException_IfCryptogramIsNotLower() {
            String cryptogram = "Aa";
            assertThatThrownBy(() -> Problem2.validateIsLower(cryptogram))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("소문자가 아닌 다른 값이 포함되어 있습니다.");
        }

        @Test
        void testValidator() {
            String cryptogram = "abcd";
            assertThat(Problem2.solution(cryptogram)).isEqualTo("answer");
        }
    }

    @Nested
    class Probalem3Test {
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

        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 10001})
        void testValidateInputSize(int number) {
            assertThatThrownBy(() -> Problem3.validateInputSize(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("유효하지 않은 크기의 숫자입니다.");
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
        void should_ThrowException_ForInvalidLength() {
            String word = "";
            assertThatThrownBy(() -> Problem4.validateLength(word))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("허용되지 않은 길이의 문자열입니다.");
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

        @ParameterizedTest
        @ValueSource(ints = {-1, 0, 1000001})
        void testValidateInputSize(int number) {
            assertThatThrownBy(() -> Problem3.validateInputSize(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("유효하지 않은 크기의 숫자입니다.");
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
        void testValidateForm() {
            List<List<String>> forms = List.of(
                    List.of("andrew#email.com", "앤드류"),
                    List.of("blank@email.com", ""),
                    List.of("jason@email.come", "제이슨"),
                    List.of("testtesttesttesttesttest@email.com", "테스트")
            );

            assertThatThrownBy(() -> Problem6.validate(forms))
                    .isInstanceOf(IllegalArgumentException.class);
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