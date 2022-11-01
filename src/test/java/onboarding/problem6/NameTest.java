package onboarding.problem6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class NameTest {

    @Test
    void createName() {
        Name name = new Name("수정");
        Assertions.assertThat(name).isEqualTo(new Name("수정"));
    }

    @Test
    void isKorean() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Name("name");
                }).withMessageMatching("한글만 입력 가능합니다.");
    }

    @Test
    void isValideLength() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Name("");
                    new Name("일이삼사오육칠팔구십일이삼사오육칠팔구십");
                }).withMessageMatching("전체 길이는 1자 이상 20자 미만 가능합니다.");
    }

}
