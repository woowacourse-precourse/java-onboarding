package onboarding.problem3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("인풋 범위 검증기")
public class GameNumberTest {
    @DisplayName("자연수가 아닌 것을 검증한다")
    @Test
    void 자연수_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameNumber(0);
        });
    }

    @DisplayName("10000보다 큰 수 체크")
    @Test
    void 최대값_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            new GameNumber(10001);
        });
    }
}
