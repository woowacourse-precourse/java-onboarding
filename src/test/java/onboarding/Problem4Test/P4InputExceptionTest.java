package onboarding.Problem4Test;

import onboarding.Problem4;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class P4InputExceptionTest {
    @Test
    void case1() {
        String word = "abcd123";
        String result = "INPUT_ERROR";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
    @Test
    void case2() {
        String word = "abcd*+- ";
        String result = "INPUT_ERROR";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    void case3() {
        String word = new String(new char[1001]).replace('\0', 'a');
        String result = "INPUT_ERROR";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    void case4() {
        String word = "I love you";
        String result = "R olev blf";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

}
