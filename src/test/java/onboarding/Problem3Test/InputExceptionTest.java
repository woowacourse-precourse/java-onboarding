package onboarding.Problem3Test;

import onboarding.Problem2;
import onboarding.Problem3;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class InputExceptionTest {

    @Test
    void case1() {
        int number = 0;
        int result = -1;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    void case2() {
        int number = 10001;
        int result = -1;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
}
