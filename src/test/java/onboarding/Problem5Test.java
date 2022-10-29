package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;

class Problem5Test {

    @Test
    void 결과테스트() {

        int num1 = 43000;
        int num2 = 654321;
        //when

        //then
        assertThat(Problem5.solution(num1).stream().mapToInt(Integer::intValue).toArray()).isEqualTo(
                new int[]{0, 4, 0, 3, 0, 0, 0, 0, 0});
        assertThat(Problem5.solution(num2).stream().mapToInt(Integer::intValue).toArray()).isEqualTo(
                new int[]{13, 0, 0, 4, 0, 3, 0, 2, 1});

    }

    @Test
    void 예외결과테스트() {

        int num1 = -3;
        int num2 = 2_000_000;

        assertThrows(InputMismatchException.class, () -> Problem5.solution(num1));
        assertThrows(InputMismatchException.class, () -> Problem5.solution(num2));
    }

}