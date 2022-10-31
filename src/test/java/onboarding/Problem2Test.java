package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Problem2Test {
    @Test
    public void 문자리스트반환() throws Exception {
        //given
        String word = "abcdefg";

        //when
        List<Character> chars = Problem2.getChars(word);

        //then
        Assertions.assertThat(chars).isEqualTo(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g'));
    }

    @Test
    public void 중복문자제거() throws Exception {
        //given
        List<Character> characters = new ArrayList<>(List.of('z', 'e', 'l', 'l', 'l', 'l'));

        //when
        Problem2.removeDuplicates(characters);

        //then
        Assertions.assertThat(characters).isEqualTo(List.of('z', 'e'));
    }

    @Test
    public void String으로합치기() throws Exception {
        //given
        List<Character> characters = new ArrayList<>(List.of('a', 'b', 'c', 'd', 'e', 'f'));

        //when
        String answer = Problem2.listToString(characters);

        //then
        Assertions.assertThat(answer).isEqualTo("abcdef");
    }
}