package onboarding.problem4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SentenceTest {
    @Test
    @DisplayName("알파벳인 경우 대문자, 소문자 판별해서 변환하기")
    void convertAlphabet() {
        Sentence sentence = new Sentence("I love you");
        assertThat(sentence.convert()).isEqualTo("R olev blf");
    }
}
