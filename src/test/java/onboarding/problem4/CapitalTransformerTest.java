package onboarding.problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("대문자 변경 기능")
public class CapitalTransformerTest {
    @DisplayName("대문자가 잘 변경됨")
    @Test
    void 대문자_변경_테스트() {
        assertThat(new CapitalTransformer("As83ZcB").getTransformed()).isEqualTo("Zs83AcY");
    }
}
