package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;

class Problem3Test {
    @Test
    void 손뼉여부테스트() {

        //given
        int num1 = 3;
        int num2 = 1;
        int num3 = 8;
        int num4 = 6;

        //when

        //then
        assertThat(Problem3.isClapCase(num1)).isEqualTo(true);
        assertThat(Problem3.isClapCase(num3)).isEqualTo(false);
        assertThat(Problem3.isClapCase(num2)).isEqualTo(false);
        assertThat(Problem3.isClapCase(num4)).isEqualTo(true);
    }
    @Test
    void 손뼉횟수테스트() {

        //given
        int num1 = 3;
        int num2 = 93;
        int num3 = 1;
        int num4 = 611;

        //when

        //then
        assertThat(Problem3.getClapCount(num1)).isEqualTo(1);
        assertThat(Problem3.getClapCount(num2)).isEqualTo(2);
        assertThat(Problem3.getClapCount(num3)).isEqualTo(0);
        assertThat(Problem3.getClapCount(num4)).isEqualTo(1);
    }
}