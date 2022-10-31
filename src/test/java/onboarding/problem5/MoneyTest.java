package onboarding.problem5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("돈 테스트")
public class MoneyTest {
    @DisplayName("돈이 범위 밖에 있으면 에러")
    @Test
    void 돈_범위_체크() {
        //Todo assertAll로 교체 추가
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Money(10000001);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Money(1000000);
        });
        Assertions.assertDoesNotThrow(() -> {
            new Money(1);
        });
    }
}
