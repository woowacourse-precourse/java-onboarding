package onboarding.problem6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class EmailTest {

    @Test
    void validateLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Email("@email.com");
                    new Email("12345678910@email.com");
                }).withMessageMatching("이메일 길이는 11자 이상 20자 미만이어야 합니다.");
    }

    @Test
    void validateEmailPattern() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Email("1234567891011");
                }).withMessageMatching("이메일 형식이 맞지 않습니다.");
    }

    @Test
    void validateDomain() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Email("email@naver.com");
                }).withMessageMatching("지원하지 않는 도메인 입니다.");
    }

}