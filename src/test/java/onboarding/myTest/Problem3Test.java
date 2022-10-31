package onboarding.myTest;

import onboarding.Problem3;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3Test {

    @Test
    void case1() {
        int number = 1;
        int result = 0;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
}
