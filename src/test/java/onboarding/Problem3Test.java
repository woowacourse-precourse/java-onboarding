package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;

class Problem3Test {

    Problem3 problem3 = new Problem3();
    @Test
    void 손뼉여부테스트() {

        //given
        int num1 = 3;
        int num2 = 1;
        int num3 = 8;
        int num4 = 6;

        //when

        //then
        assertThat(Problem3.NumberInClapGame.isClapCase(num1)).isEqualTo(true);
        assertThat(Problem3.NumberInClapGame.isClapCase(num3)).isEqualTo(false);
        assertThat(Problem3.NumberInClapGame.isClapCase(num2)).isEqualTo(false);
        assertThat(Problem3.NumberInClapGame.isClapCase(num4)).isEqualTo(true);
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
        assertThat(Problem3.makeNumberInClapGame(num1).clapCount()).isEqualTo(1);
        assertThat(Problem3.makeNumberInClapGame(num2).clapCount()).isEqualTo(2);
        assertThat(Problem3.makeNumberInClapGame(num3).clapCount()).isEqualTo(0);
        assertThat(Problem3.makeNumberInClapGame(num4).clapCount()).isEqualTo(1);
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