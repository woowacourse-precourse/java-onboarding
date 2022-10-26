package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {

    @Test
    void case1() {
        String cryptogram = "lol";
        String result = "lol";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
    @Test
    void case2() {
        String cryptogram = "loaal";
        String result = "lol";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

}