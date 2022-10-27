package onboarding.problem2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DecryptorTest {
    @Test
    @DisplayName("문자열에 연속된 같은 문자가 없으면 결과 값 반환")
    void removeAllEqualsTwoChar() {
        Decryptor decryptor = new Decryptor("browoanoommnaon");
        decryptor.decrypte();
        assertThat(decryptor.getCryptogram()).isEqualTo("brown");
    }
}
