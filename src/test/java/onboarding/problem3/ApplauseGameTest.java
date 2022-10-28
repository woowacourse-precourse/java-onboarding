package onboarding.problem3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplauseGameTest {
    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(Applause.start(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(Applause.start(number)).isEqualTo(result);
        }
    }
}
