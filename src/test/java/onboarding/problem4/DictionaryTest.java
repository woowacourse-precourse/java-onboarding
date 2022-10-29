package onboarding.problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DictionaryTest {

    @Test
    @DisplayName("문자열을 받아 사전을 참조한 뒤 결과를 반환한다.")
    void reverseString_Success() {
        // given
        Dictionary dictionary = new Dictionary("validWord");

        String testWord = "I love you";
        String expectedWord = "R olev blf";

        // when
        String result = dictionary.reverseString(testWord);

        // then
        assertThat(expectedWord.equals(result)).isTrue();
    }
}