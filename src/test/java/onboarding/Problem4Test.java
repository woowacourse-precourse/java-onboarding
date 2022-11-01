package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("문제4번: 알파벳 변환")
public class Problem4Test {
    @Test
    @DisplayName("알파벳만 주어져도 정상동작한다.")
    void convertCase1() {
        String word = "I love you";
        String result = "R olev blf";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    @DisplayName("알파벳 여러 개와 특수문자 1개가 입력되도 정상동작한다.")
    void convertCase2() {
        String word = "All is Well.";
        String result = "Zoo rh Dvoo.";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    @DisplayName("특수문자만 입력되도 정상동작한다.")
    void convertCase3() {
        String word = "#$Ap!@#&%^.";
        String result = "#$Zk!@#&%^.";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
}
