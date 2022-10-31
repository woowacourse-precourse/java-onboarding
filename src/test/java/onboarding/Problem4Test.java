package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {
    @Test
    void spaceCase(){
        String word = " ";
        String result = " ";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
    @Test
    void case1(){
        String word = "aaazzzAAAZZZ";
        String result = "zzzaaaZZZAAA";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
    @Test
    void case2(){
        String word = "1mn";
        String result = "1nm";
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
    @Test
    void case3(){
        String word = "";
        for (char i = 'a'; i < 'z'+1; i++) {
            word+=i;
        }
        String result = "";
        for (char i = 'z'; i > 'a'-1; i--) {
            result+=i;
        }
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
    @Test
    void case4(){
        String word = "";
        for (char i = 'A'; i < 'Z'+1; i++) {
            word+=i;
        }
        String result = "";
        for (char i = 'Z'; i > 'A'-1; i--) {
            result+=i;
        }
        assertThat(Problem4.solution(word)).isEqualTo(result);
    }
}