package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    
    @Nested
    @DisplayName("moduloNumberAByNumberB 메소드는")
    class moduloNumberAByNumberBTest {
        @Nested
        @DisplayName("숫자A와 0이 아닌 숫자B를 입력하면")
        class Context_with_numberA_and_non_zero_numberB {
            @Test
            @DisplayName("숫자A를 숫자B로 나눈 나머지를 반환한다")
            void it_returns_remainder() {
                int numberA = 5;
                int numberB = 3;
                assertThat(problem5.moduloNumberAByNumberB(numberA, numberB)).isEqualTo(numberA % numberB);
            }
        }

        @Nested
        @DisplayName("숫자A와 0을 입력하면")
        class Context_with_numberA_and_zero_numberB {
            @Test
            @DisplayName("ArithmeticException을 반환한다")
            void it_throws_ArithmeticException() {
                int numberA = 5;
                int numberB = 0;
                assertThatThrownBy(() -> problem5.moduloNumberAByNumberB(numberA, numberB)).isInstanceOf(ArithmeticException.class);
            }
        }
    }
    @Nested
    @DisplayName("sortListDescendingOrder 메소드는")
    class sortListDescendingOrderTest {
        @Nested
        @DisplayName("리스트가 입력되면")
        class Context_with_list {
            @Test
            @DisplayName("내림차순으로 정렬한 리스트를 반환한다")
            void it_returns_descending_sorted_list() {
                List<Integer> list = new ArrayList<>(Arrays.asList(5, 4, 2, 1, 3));
                List<Integer> sortedList = List.of(5, 4, 3, 2, 1);
                assertThat(problem5.sortListDescendingOrder(list)).isEqualTo(sortedList);
            }
        }
    }
}