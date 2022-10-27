package onboarding.problem2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptogramTest {
    @Test
    @DisplayName("두 문자가 같은 문자인지 확인하기")
    void isEqualsTwoChar() {
        Cryptogram cryptogram = new Cryptogram();
        assertThat(cryptogram.isEquals('a', 'a')).isTrue();
    }
}
