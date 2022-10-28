package onboarding.problem2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecryptorTest {
    @Test
    @DisplayName("중복되는 문자 모두 삭제 후 결과 반환")
    void decrypt() {
        Decryptor decryptor = new Decryptor("zyellleyz");
        decryptor.decrypt();
        assertThat(decryptor.cryptogram()).isEqualTo("");
    }
}
