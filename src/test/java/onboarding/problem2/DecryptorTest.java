package onboarding.problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("복호화 테스트")
public class DecryptorTest {
    @DisplayName("남아 있는지 확인")
    @Test
    void 남은_부분() {
        Cipher cipher1 = new Cipher("hello");
        Cipher cipher2 = new Cipher("abbaa");
        assertThat(new Decoder(cipher1).decode()).isEqualTo("heo");
        assertThat(new Decoder(cipher2).decode()).isEqualTo("a");
    }
}
