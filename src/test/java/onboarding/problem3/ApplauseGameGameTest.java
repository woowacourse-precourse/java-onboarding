package onboarding.problem3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplauseGameGameTest {
    @Nested
    class Problem3Test {
        private final ClapRule clapRule = new ClapRule();

        @Test
        void case1() {
            int number = 13;
            int result = 4;
            ApplauseGame applauseGame = new ApplauseGame();
            assertThat(applauseGame.start(number, clapRule)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            ApplauseGame applauseGame = new ApplauseGame();
            assertThat(applauseGame.start(number, clapRule)).isEqualTo(result);
        }


    }
}
