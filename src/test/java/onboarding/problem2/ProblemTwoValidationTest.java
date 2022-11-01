package onboarding.problem2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ProblemTwoValidationTest {


    @Test
    @DisplayName("암호문 문자열의 길이 제야조건에 위반 (문자열 길이 1 ~ 1000) 되는 경우 테스트")
    void isLength_false() {
        // given
        String cryptogram = "";
        ProblemTwoValidation validation = new ProblemTwoValidation(cryptogram);

        // when && then
        assertThatThrownBy(validation::checkedValid)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("문자열의 범위가 유효하지 않습니다.");
    }

    @Test
    @DisplayName("암호문 문자열의 길이 제약 조건에 맞는 경우 테스트")
    void isLength_true() {
        // given
        String cryptogram = "brrrrroooownn";

        // when
        ProblemTwoValidation validation = new ProblemTwoValidation(cryptogram);
        validation.checkedValid();

        // then
        assertThat(validation).isNotNull();
    }

    @Test
    @DisplayName("암호문 문자열에 소문자가 아닌 대문자가 입력 된 경우 예외 발생한다..")
    void isLowCase() {
        // given
        String cryptogram = "bRRRRRroooownn";
        ProblemTwoValidation validation = new ProblemTwoValidation(cryptogram);

        // when && then
        assertThatThrownBy(validation::checkedValid)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("알파벳 소문자가 아닙니다.!!");
    }
}