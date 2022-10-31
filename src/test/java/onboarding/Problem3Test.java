package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3Test {

    @Test
    void case1() {
        //given
        int number = 333;
        //when
        int result = 228;
        //then
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    void case2() {
        //given
        int number = 2;
        //when
        int result = 0;
        //then
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
}
