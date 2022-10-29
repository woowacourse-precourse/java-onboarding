package onboarding.problem4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    @DisplayName("유효하지 않는 문자열 테스트")
    void isValid_fail() {
        // given
        String word = "";

        // when && then
        assertThatThrownBy(() -> new Validation(word))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 문자열입니다.");
    }

    @Test
    @DisplayName("유효한 문자열을 받아 인스턴스 생성하기 성공 테스트")
    void ValidationTest() {
        // given
        String word = "i love";

        // when
        Validation validation = new Validation(word);

        // then
        assertThat(validation).isNotNull();
    }

}