package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class ConvertUtilsTest {
    private static final int REVERSE_SIZE = 5;
    String word = "abcxyzCBAZYX";
    ConvertUtils convertUtils = new ConvertUtils(word, REVERSE_SIZE);

    @Test
    void 대문자와_소문자를_반전_시키는_Map을_기준으로_word_반전() {

        //when
        String expected = convertUtils.convertToReverseWord();

        //then
        Assertions.assertThat(expected).isEqualTo("zyxcbaXYZABC");
    }

    @Test
    void 사전의_반전_크기를_기준으로_대문자와_소문자를_반전_시키는_Map을_생성() {
        //given
        Map<Character, Character> actual = Map.ofEntries(
                Map.entry('a', 'z'),
                Map.entry('b', 'y'),
                Map.entry('c', 'x'),
                Map.entry('d', 'w'),
                Map.entry('e', 'v'),
                Map.entry('z', 'a'),
                Map.entry('y', 'b'),
                Map.entry('x', 'c'),
                Map.entry('w', 'd'),
                Map.entry('v', 'e'),
                Map.entry('A', 'Z'),
                Map.entry('B', 'Y'),
                Map.entry('C', 'X'),
                Map.entry('D', 'W'),
                Map.entry('E', 'V'),
                Map.entry('Z', 'A'),
                Map.entry('Y', 'B'),
                Map.entry('X', 'C'),
                Map.entry('W', 'D'),
                Map.entry('V', 'E'),
                Map.entry(' ', ' ')
        );

        //when
        Map<Character, Character> expected = convertUtils.getConvertReverseCharacterMap(REVERSE_SIZE);

        //then
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
