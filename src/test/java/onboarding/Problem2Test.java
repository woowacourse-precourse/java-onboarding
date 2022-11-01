package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("문제 2번: 연속중복문자 제거")
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

    @Test
    @DisplayName("연속중복문자가 3개 이상이어도 정상작동한다.")
    void given_teeen_then_tn() {
        String cryptogram = "teeen";
        String result = "tn";
        assertThat(Problem2.solution(cryptogram)).isEqualTo(result);
    }
}