package onboarding.problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("암호문 검증 테스트")
public class CipherTest {
    @DisplayName("암호문은 null이면 안된다")
    @Test
    void 암호문_존재() {
        assertThrows(IllegalArgumentException.class, () -> new Cipher(null));
    }

    @DisplayName("길이가 1~1000 밖에 있음")
    @Test
    void 암호문_길이() {
        assertThrows(IllegalArgumentException.class, () -> new Cipher(""));
    }

    @DisplayName("알파벳 소문자로만 이루어지지 않음")
    @Test
    void 소문자_체크() {
        assertThrows(IllegalArgumentException.class, () -> new Cipher("Abcd"));
    }
}
