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

        assertThat(Problem4.makeReverseAlphabet(ch1).result()).isEqualTo('z');
        assertThat(Problem4.makeReverseAlphabet(ch2).result()).isEqualTo('X');

    }
    @Test
    void 결과테스트() {

        String str1 = "I love you";
        String str2 = "I am Invidam";
        String shortStr = "";
        StringBuffer forLong = new StringBuffer();
        for (int i = 0; i < 1005; i++) {
            forLong.append('a');
        }
        String longStr = forLong.toString();

        //when

        //then
        assertThat(Problem4.solution(str1)).isEqualTo("R olev blf");
        assertThat(Problem4.solution(str2)).isEqualTo("R zn Rmerwzn");

        assertThrows(InputMismatchException.class,() -> Problem4.solution(shortStr));
        assertThrows(InputMismatchException.class,() -> Problem4.solution(longStr));
    }

}