package onboarding.problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProblemTwoValidationTest {

    private ProblemTwoValidation validation;

    @BeforeEach
    public void setUp() {
        validation = new ProblemTwoValidation();
    }

    @Test
    @DisplayName("암호문 문자열의 길이 제야조건에 위반 (문자열 길이 1 ~ 1000) 되는 경우 테스트")
    void isLength_false() {
        // given
        int min = LengthValue.MIN.getValue();
        int max = LengthValue.MAX.getValue();

        StringBuilder sb = new StringBuilder();
        for (int i = min; i <= max + 1; i++) {
            sb.append("t");
        }

        String testCryptogram = sb.toString();
        String expectedValue = "";
        validation.settingCryptogram(testCryptogram);

        // when
        boolean result = validation.isLength();

        // then
        assertThat(result).isFalse();
        assertThat(validation.getValidString()).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("암호문 문자열의 길이 제약 조건에 맞는 경우 테스트")
    void isLength_true() {
        // given
        int min = LengthValue.MIN.getValue();
        int max = LengthValue.MAX.getValue();

        StringBuilder sb = new StringBuilder();
        for (int i = min; i <= max; i++) {
            sb.append("t");
        }

        String expectedValue = sb.toString();
        validation.settingCryptogram(expectedValue);

        // when
        boolean result = validation.isLength();

        // then
        assertThat(result).isTrue();
        assertThat(validation.getValidString()).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("암호문 문자열에 소문자가 아닌 대문자가 입력 된 경우 소문자로 반환한다.")
    void isLowCase() {
        // given
        String testCryptogram = "TTTTTTTTTTT";
        String expectedValue = testCryptogram.toLowerCase();

        // when
        validation.settingCryptogram(testCryptogram);

        // then
        assertThat(validation.getValidString()).isEqualTo(expectedValue);
    }

}