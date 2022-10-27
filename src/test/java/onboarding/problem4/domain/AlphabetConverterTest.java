package onboarding.problem4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AlphabetConverterTest {
    @Test
    @DisplayName("대문자 변환하기")
    void convertUpperCase() {
        assertThat(AlphabetConverter.convert('A')).isEqualTo('Z');
    }
    
    @Test
    @DisplayName("소문자 변환하기")
    void convertLowerCase() {
        assertThat(AlphabetConverter.convert('a')).isEqualTo('z');
    }
}