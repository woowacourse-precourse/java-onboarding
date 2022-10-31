package onboarding.problem4;

import onboarding.Problem4;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeFrogTest {

    @Test
    public void alphabetConvert(){
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String result = "ZYXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponmlkjihgfedcba";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

    @Test
    public void nonalphabetConvert(){
        String word = "개굴 개굴 개구리 노래를 한다 !@#$%^&";
        String result = "개굴 개굴 개구리 노래를 한다 !@#$%^&";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }

}