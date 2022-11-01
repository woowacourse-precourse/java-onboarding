package onboarding.problem3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersTest {
    @Test
    @DisplayName("입력된 숫자까지 증가하면서 3,6,9 개수 더하기")
    void sumCountOfMultipleOfThree() {
        Numbers numbers = new Numbers(40);
        assertThat(numbers.sumCountOfMultipleOfThree()).isEqualTo(22);
    }
}
