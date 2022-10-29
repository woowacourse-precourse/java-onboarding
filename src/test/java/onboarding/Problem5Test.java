package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Problem5Test {

    private Problem5 problem5;

    @BeforeEach
    void setUp() {
        problem5 = new Problem5();
    }

    @Nested
    @DisplayName("divideNumberAByNumberB 메소드는")
    class DivideNumberAByBTest {
        @Nested
        @DisplayName("숫자A와 0이 아닌 숫자B를 입력하면")
        class Context_with_numberA_and_non_zero_numberB{
            @Test
            @DisplayName("숫자A를 숫자B로 나눈 몫을 반환한다")
            void it_returns_quotient() {
                int numberA = 5;
                int numberB = 3;
                assertThat(problem5.divideNumberAByNumberB(numberA, numberB)).isEqualTo(numberA / numberB);
            }
        }

        @Nested
        @DisplayName("숫자A와 0을 입력하면")
        class Context_with_numberA_and_zero_numberB{
            @Test
            @DisplayName("ArithmeticException을 반환한다")
            void it_throws_ArithmeticException() {
                int numberA = 5;
                int numberB = 0;
                assertThatThrownBy(() ->  problem5.divideNumberAByNumberB(numberA, numberB)).isInstanceOf(ArithmeticException.class);
            }
        }
    }
}