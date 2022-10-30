package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("문제 5번: 지폐/동전 단위 계산")
public class Problem5Test {
    @Test
    @DisplayName("50,237원은 적절히 계산된다.")
    void isCorrectAnswer_When50237() {
        int money = 50_237;
        List<Integer> result = List.of(1, 0, 0, 0, 0, 2, 0, 3, 7);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }

    @Test
    @DisplayName("15,000원은 적절히 계산된다.")
    void isCorrectAnswer_When15000() {
        int money = 15_000;
        List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
        assertThat(Problem5.solution(money)).isEqualTo(result);
    }
}
