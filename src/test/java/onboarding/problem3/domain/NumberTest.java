package onboarding.problem3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {
    @Test
    @DisplayName("숫자의 각 자리수 중 3의 배수인 수의 개수 구하기")
    void countOfMultipleOfThree() {
        Number number = new Number(3469);
        assertThat(number.countOfMultipleOfThree()).isEqualTo(3);
    }
}
