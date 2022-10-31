package onboarding;

import onboarding.problem3.Problem3Validation;
import onboarding.problem4.Problem4Validation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem4CustomTest {
    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 1000;

    @Nested
    class Problem4Test {
        @Test
        void 최대최소input만족하는지() {
            String userInput = "abc";
            boolean possible = Problem4Validation.problem4InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(possible).isTrue();
        }

        @Test
        void 최대최소input만족안하는경우1() {
            String userInput = "";
            boolean impossible = Problem4Validation.problem4InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 최대최소input만족안하는경우2() {
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < 1001; i++) {
                input.append("a");
            }
            String userInput = input.toString();
            boolean impossible = Problem4Validation.problem4InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(impossible).isFalse();
        }
    }
}
