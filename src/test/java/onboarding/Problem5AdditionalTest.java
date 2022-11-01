package onboarding;

import onboarding.problem5.exception.OverflowNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Problem5AdditionalTest {
    @Test
    @DisplayName("입력값 숫자 초과시")
    void overflowNumber() {
        int money = 1_000_001;

        assertThatThrownBy(() -> Problem5.solution(money))
                .isInstanceOf(OverflowNumberException.class);
    }

    @Test
    @DisplayName("입력값 숫자가 0일 때")
    void numberIsZero() {
        int money = 0;

        assertThatThrownBy(() -> Problem5.solution(money))
                .isInstanceOf(OverflowNumberException.class);
    }
}
