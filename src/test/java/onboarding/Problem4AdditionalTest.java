package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem4AdditionalTest {
    @Test
    @DisplayName("특수문자 포함")
    void includingSpecialChar() throws Exception {
        //given
        String word = "I&^love*(you";
        String expect = "R&^olev*(blf";
        //when
        String result = Problem4.solution(word);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("대문자 변환")
    void mapToUppercase() throws Exception {
        //given
        String word = "ABCDE";
        String expect = "ZYXWV";
        //when
        String result = Problem4.solution(word);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("소문자 변환")
    void mapToLowercase() throws Exception {
        //given
        String word = "abcde";
        String expect = "zyxwv";
        //when
        String result = Problem4.solution(word);
        //then
        assertThat(result).isEqualTo(expect);
    }


}
