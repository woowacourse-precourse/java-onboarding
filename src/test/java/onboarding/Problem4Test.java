package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;

class Problem4Test {
    @Test
    void 한글자테스트() {
        char ch1 = 'a';
        char ch2 = 'C';

        assertThat(Problem4.transformChar(ch1)).isEqualTo('z');
        assertThat(Problem4.transformChar(ch2)).isEqualTo('X');

    }
    @Test
    void 결과테스트() {

        //given
        int num1 = 3;
        int num2 = 93;
        int num3 = 1;
        int num4 = 611;
        int num5 = -3;
        int num6 = 10_005;

        //when

        //then
        assertThat(Problem3.getClapCountSum(num1)).isEqualTo(1);
        assertThat(Problem3.getClapCountSum(num2)).isEqualTo(52);
        assertThat(Problem3.getClapCountSum(num3)).isEqualTo(0);
        assertThat(Problem3.getClapCountSum(num4)).isEqualTo(475);
        assertThrows(InputMismatchException.class,() -> Problem3.getClapCountSum(num5));
        assertThrows(InputMismatchException.class,() -> Problem3.getClapCountSum(num6));
    }

}