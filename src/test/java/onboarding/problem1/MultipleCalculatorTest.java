package onboarding.problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("곱셈 계산기")
public class MultipleCalculatorTest {
    @DisplayName("곱셈으로 점수를 계산한다")
    @Test()
    void 곱셈_점수_계산기() {
        List<Integer> 곱셈_인자1 = List.of(1, 2, 3);
        assertThat(new MultipleCalculator(곱셈_인자1).getScore()).isEqualTo(6);

        List<Integer> 곱셈_인자2 = List.of(3, 4, 3);
        assertThat(new MultipleCalculator(곱셈_인자2).getScore()).isEqualTo(36);
    }
}
