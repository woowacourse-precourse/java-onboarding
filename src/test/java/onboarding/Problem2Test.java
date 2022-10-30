package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class Problem2Test {
    @Test
    @DisplayName("browoanoommnaon의 결과는 brown이다.")
    void given_browoanoommnaon_then_brown() {
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    @DisplayName("zyelleyz의 결과는 공백이다.")
    void given_zyelleyz_then_BLANK() {
        String cryptogram = "zyelleyz";
        String result = "";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }

    @Test
    @DisplayName("succession의 결과는 sueion이다.")
    void given_succession_then_sueion() {
        String cryptogram = "succession";
        String result = "sueion";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}