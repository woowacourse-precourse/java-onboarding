package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class Problem4Test {
    @Test
    @DisplayName("I love you는 R olev blf로 변환횐다")
    void convertCase1() {
        String word = "I love you";
        String result = "R olev blf";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    @DisplayName("All is Well.는 Zoo rh Dvoo.로 변환횐다")
    void convertCase2() {
        String word = "All is Well.";
        String result = "Zoo rh Dvoo.";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    @DisplayName("#$Ap!@#&%^.는 #$Zk!@#&%^.로 변환횐다")
    void convertCase3() {
        String word = "#$Ap!@#&%^.";
        String result = "#$Zk!@#&%^.";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
}
