package onboarding;

import onboarding.problem3.Problem3Validation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3CustomTest {

    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 10000;

    @Nested
    class Problem3Test {
        @Test
        void 최대최소input만족하는지() {
            int userInput = 3;
            boolean possible = Problem3Validation.problem3InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(possible).isTrue();
        }

        @Test
        void 최대최소input만족안하는경우() {
            int userInput = 0;
            boolean impossible = Problem3Validation.problem3InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 최대최소input만족안하는경우2() {
            int userInput = 100001;
            boolean impossible = Problem3Validation.problem3InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(impossible).isFalse();
        }
    }
}
