package onboarding.problem4.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class AlphabetConvertorTest {
    @Test
    @DisplayName("알파벳 변환")
    void convertAlphabet() {
        assertAll(
                () -> assertThat(AlphabetConvertor.convertAlphabet('a')).isEqualTo('z'),
                () -> assertThat(AlphabetConvertor.convertAlphabet('A')).isEqualTo('Z')
        );
    }
}