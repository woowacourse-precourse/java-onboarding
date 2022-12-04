package onboarding.resolve.problem4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import onboarding.Problem4;
import org.junit.jupiter.api.Test;

class Problem4Test {
    @Test
    void case1() {
        String word = "I love you";
        String result = "R olev blf";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
}