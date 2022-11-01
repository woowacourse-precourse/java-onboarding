package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem4Test {

    @Test
    @DisplayName("알파벳 변경 테스트")
    void convertIndex(){

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";

        String convertedUpper = Problem4.solution(upper);
        String convertedLower = Problem4.solution(lower);

        StringBuffer sbUpper = new StringBuffer(upper);
        StringBuffer sbLower = new StringBuffer(lower);

        String reversedUpper = sbUpper.reverse().toString();
        String reversedLower = sbLower.reverse().toString();

        assertThat(convertedUpper).isEqualTo(reversedUpper);
        assertThat(convertedLower).isEqualTo(reversedLower);

    }

    @Test
    @DisplayName("메소드 테스트")
    void methodTest(){
        String word ="I love you";
        assertThat(Problem4.solution(word)).isEqualTo("R olev blf");
    }

}
