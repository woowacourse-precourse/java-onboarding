package onboarding.problem3.objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidationTest {

    @Test
    @DisplayName("유효한 숫자 검증 실패 테스트")
    void validation_Instant_Generate_Fail() {
        // given
        int number = 0;

        // when && then
        assertThatThrownBy(() -> new Validation(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유요하지 않는 숫자입니다.");
    }

    @Test
    @DisplayName("유효한 숫자 검증 성공 테스트")
    void validation_Instant_Generate_Success() {
        // given
        int number = 10;

        // when
        Validation validation = new Validation(number);

        // then
        assertThat(validation).isNotNull();
    }
}