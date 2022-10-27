package onboarding.Problem2Test;

import onboarding.Problem2;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class InputExceptionTest {
    @Test
    void case1() {
        String cryptogram = "";
        String result = "Input Error";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
    @Test
    void case2() {
        String cryptogram = "";
        for (int i = 0; i < 1001 ; i++) {
            cryptogram += "a";
        }
        String result = "Input Error";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
    @Test
    void case3() {
        String cryptogram = "ContainsCapital";
        String result = "Input Error";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}
