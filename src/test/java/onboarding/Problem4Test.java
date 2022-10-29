package onboarding;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;

class Problem4Test {
    @Test
    void 한글자테스트() {
        char ch1 = 'a';
        char ch2 = 'C';

        assertThat(Problem4.transformChar(ch1)).isEqualTo('z');
        assertThat(Problem4.transformChar(ch2)).isEqualTo('X');

    }
    @Test
    void 결과테스트() {

        String str1 = "I love you";
        String str2 = "I am Invidam";
        String str3 = "";

        //when

        //then
        assertThat(Problem4.solution(str1)).isEqualTo("");
        assertThat(Problem4.solution(str2)).isEqualTo("");
        assertThat(Problem4.solution(str3)).isEqualTo("");
    }

}