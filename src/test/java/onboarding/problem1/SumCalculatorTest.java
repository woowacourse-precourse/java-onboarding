package onboarding.problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("덧셈 계산기")
public class SumCalculatorTest {
    @DisplayName("덧셈으로 점수를 잘 계산한다")
    @Test
    void 덧셈_계산() {
        List<Integer> 덧셈_인자1 = List.of(3, 2, 1);
        List<Integer> 덧셈_인자2 = List.of(3, 6, 7);

        assertThat(new SumCalculator(덧셈_인자1).getScore()).isEqualTo(6);
        assertThat(new SumCalculator(덧셈_인자2).getScore()).isEqualTo(16);
    }
}
