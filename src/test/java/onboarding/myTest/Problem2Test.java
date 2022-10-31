package onboarding.myTest;

import onboarding.Problem2;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem2Test {


    /**
     * 문자가 하나인 경우
     */
    @Test
    void case1() {
        String cryptogram = "a";
        String result = "a";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

}
