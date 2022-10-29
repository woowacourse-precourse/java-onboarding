package onboarding;

import onboarding.problem2.Problem2Validation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2CustomTest {

    private static final int INPUT_LENGTH_MIN = 1;
    private static final int INPUT_LENGTH_MAX = 1000;


    @Nested
    class Problem1Test {
        @Test
        void 길이1000초과문자열통과못하게() {
            String userInput = "";
            for (int i = 0; i < 1001; i++) {
                userInput += "a";
            }
            boolean impossible = Problem2Validation.problem2InputValidation(userInput, INPUT_LENGTH_MIN, INPUT_LENGTH_MAX);
            assertThat(impossible).isFalse();
        }

        @Test
        void 길이0인문자열통과못하게() {
            String userInput = "";
            boolean impossible = Problem2Validation.problem2InputValidation(userInput, INPUT_LENGTH_MIN, INPUT_LENGTH_MAX);
            assertThat(impossible).isFalse();
        }

        @Test
        void 알파벳이아닌문자열통과못하게() {
            String userInput = "가";
            boolean impossible = Problem2Validation.problem2InputValidation(userInput, INPUT_LENGTH_MIN, INPUT_LENGTH_MAX);
            assertThat(impossible).isFalse();
        }

        @Test
        void 소문자아닌문자열통과못하게() {
            String userInput = "A";
            boolean impossible = Problem2Validation.problem2InputValidation(userInput, INPUT_LENGTH_MIN, INPUT_LENGTH_MAX);
            assertThat(impossible).isFalse();
        }

        @Test
        void 모든걸만족하는문자열이통과하는지() {
            String userInput = "abcdadfase";
            boolean possible = Problem2Validation.problem2InputValidation(userInput, INPUT_LENGTH_MIN, INPUT_LENGTH_MAX);
            assertThat(possible).isTrue();
        }


        @Test
        void case1() {
            String cryptogram = "bnnnnb";
            String result = "";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case2() {
            String cryptogram = "brrk";
            String result = "bk";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case3() {
            String cryptogram = "brrrk";
            String result = "bk";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

        @Test
        void case4() {
            String cryptogram = "abcdadfase";
            String result = "abcdadfase";
            assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
        }

    }
}
