package onboarding.problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("소문자만 변경하는 기능")
public class SmallTransformerTest {
    @DisplayName("소문자가 잘 변경됨")
    @Test
    void 소문자_변경_확인() {
        assertThat(new SmallTransformer("yAz34ba").getTransformed()).isEqualTo("bAa34yz");
    }
}
