package onboarding;

import onboarding.problem3.Problem3Validation;
import onboarding.problem5.Problem5Validation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem5CustomTest {
    private static final int MIN_INPUT = 1;
    private static final int MAX_INPUT = 1000000;
    @Nested
    class Problem5Test {
        @Test
        void 최대최소input만족하는지() {
            int userInput = 1000000;
            boolean possible = Problem5Validation.problem5InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(possible).isTrue();
        }

        @Test
        void 최대최소input만족안하는경우1() {
            int userInput = 0;
            boolean impossible = Problem5Validation.problem5InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(impossible).isFalse();
        }

        @Test
        void 최대최소input만족안하는경우2() {
            int userInput = 1000001;
            boolean impossible = Problem5Validation.problem5InputValidation(userInput, MIN_INPUT, MAX_INPUT);
            assertThat(impossible).isFalse();
        }
    }

}
