package onboarding.Problem2Test;

import onboarding.Problem2;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class P2InputExceptionTest {

    @Test
    void case1() {
        String cryptogram = "";
        String result = "INPUT_ERROR";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case2() {
        String cryptogram = "";
        for (int i = 0; i < 1001; i++) {
            cryptogram += "a";
        }
        String result = "INPUT_ERROR";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    void case3() {
        String cryptogram = "ContainsCapital";
        String result = "INPUT_ERROR";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}
