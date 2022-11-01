package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem4Test {
    @Test
    void case1() {
        String word = "Hello World!";
        String result = "Svool Dliow!";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    void case2() {
        String word = "abcdefghijklmnopqrstuvwxyz";
        String result = "zyxwvutsrqponmlkjihgfedcba";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
}
