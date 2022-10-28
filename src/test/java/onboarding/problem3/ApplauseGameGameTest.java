package onboarding.problem3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplauseGameGameTest {
    @Nested
    class Problem3Test {
        @Test
        void case1() {
            int number = 13;
            int result = 4;
            assertThat(ApplauseGame.start(number)).isEqualTo(result);
        }

        @Test
        void case2() {
            int number = 33;
            int result = 14;
            assertThat(ApplauseGame.start(number)).isEqualTo(result);
        }

        @Test
        void if_Under_Min(){
            assertThrows(ApplauseException.class, () -> ApplauseGame.start(0));
        }

        @Test
        void if_Over_MAX(){
            assertThrows(ApplauseException.class, () -> ApplauseGame.start(10_001));
        }
    }
}
