package onboarding;

import org.junit.jupiter.api.Test;

import static onboarding.Problem3.getClapCount;
import static org.assertj.core.api.Assertions.assertThat;

class Problem3MethodTest {

    @Test
    void getClapCountTest() {
        int number1 = 13;
        int number2 = 33;
        int number3 = 461923;

        int result1 = getClapCount(number1);
        int result2 = getClapCount(number2);
        int result3 = getClapCount(number3);

        assertThat(result1).isEqualTo(1);
        assertThat(result2).isEqualTo(2);
        assertThat(result3).isEqualTo(3);
    }
}