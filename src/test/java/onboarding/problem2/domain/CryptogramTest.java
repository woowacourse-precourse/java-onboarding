package onboarding.problem2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptogramTest {
    @Test
    @DisplayName("연속하는 중복 문자가 있으면 삭제 후 새로운 객체 반환")
    void decryptedCryptogram() {
        Cryptogram cryptogram = new Cryptogram("zyellleyz");
        assertThat(cryptogram.decrypte().getCryptogram()).isEqualTo("zyeeyz");
    }
}
