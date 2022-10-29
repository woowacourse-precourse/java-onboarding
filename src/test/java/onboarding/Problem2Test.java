package onboarding;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    @Test
    void 결과테스트() {

        //given
        String normal = "abcd";
        String multiple = "abccba";
        String invalid = "ABC";
        String shortStr = "";
        StringBuffer forLong = new StringBuffer();
        for (int i = 0; i < 1005; i++) {
            forLong.append('a');
        }
        String longStr = forLong.toString();

        //when

        //then
        assertThat(Problem2.solution(normal)).isEqualTo("abcd");
        assertThat(Problem2.solution(multiple)).isEqualTo("");
        assertThrows(InputMismatchException.class,() -> Problem2.solution(invalid));
        assertThrows(InputMismatchException.class,() -> Problem2.solution(shortStr));
        assertThrows(InputMismatchException.class,() -> Problem2.solution(longStr));
    }
}