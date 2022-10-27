package onboarding.problem2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptogramTest {
    @Test
    @DisplayName("연속하는 중복 문자 시작 위치 구하기")
    void overlapStartIndex() {
        Cryptogram cryptogram = new Cryptogram("zyellleyz");
        assertThat(cryptogram.overlapStartIndex()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("연속하는 중복 문자 끝 위치 구하기")
    void overlapEndIndex() {
        Cryptogram cryptogram = new Cryptogram("zyellleyz");
        assertThat(cryptogram.overlapEndIndex(3)).isEqualTo(6);
    }
}
