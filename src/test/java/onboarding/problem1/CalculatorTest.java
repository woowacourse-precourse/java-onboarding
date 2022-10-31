package onboarding.problem1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Nested
    @DisplayName("Calculator 클래스")
    class 계산기 {
        @Test
        @DisplayName("덧셈으로 계산한 점수 체크")
        void 덧셈_점수_계산() {
            Pages 덧셈_점수_방식 = new Pages(List.of(101, 102));
            Calculator calculator = new Calculator(덧셈_점수_방식);
            assertThat(calculator.getScore()).isEqualTo(3);
        }

        @Test
        @DisplayName("곱셈으로 계산한 점수 체크")
        void 곱셈_점수_계산() {
            Pages 곱셈_점수_방식 = new Pages(List.of(155, 156));
            Calculator calculator = new Calculator(곱셈_점수_방식);
            assertThat(calculator.getScore()).isEqualTo(30);
        }
    }
}
