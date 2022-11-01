package onboarding;

import onboarding.problem3.exception.NumberOutOfSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Problem3AdditionalTest {

    @Test
    @DisplayName("숫자 범위 초과시")
    void overNumberRange() {
        int number = 10001;
        assertThatThrownBy(() -> Problem3.solution(number))
                .isInstanceOf(NumberOutOfSizeException.class);
    }
}
