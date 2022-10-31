package onboarding.problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("입력 검증 작업")
public class NormalWordTest {
    @DisplayName("null인 경우 체크")
    @Test
    void 널_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NormalWord(null);
        });
    }

    @DisplayName("길이 범위 바깥 체크")
    @Test
    void 길이_바깥_체크() {
        assertThrows(IllegalArgumentException.class, () -> {
            new NormalWord("");
        });
    }
}
