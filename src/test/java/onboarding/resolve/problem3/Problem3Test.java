package onboarding.resolve.problem3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import onboarding.Problem3;
import org.junit.jupiter.api.Test;

class Problem3Test {
    @Test
    void case1() {
        int number = 13;
        int result = 4;
        assertThat(onboarding.Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    void case2() {
        int number = 33;
        int result = 14;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
}