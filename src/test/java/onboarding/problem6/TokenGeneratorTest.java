package onboarding.problem6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자를 토큰으로 끊는다")
public class TokenGeneratorTest {
    @DisplayName("토큰으로 분해 기능이 잘 작동함")
    @Test
    void 토큰_분해() {
        assertThat(new TokenGenerator("한글체크").getTokens()).isEqualTo(List.of("한글", "글체", "체크"));
    }
}
