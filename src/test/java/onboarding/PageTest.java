package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PageTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 399})
    @DisplayName("시작면과 끝면이 아닌 페이지가 나오는 테스트 -> true값 반환")
    public void 페이지_정상_경계값_테스트(int normal) {
        //given
        Page page = new Page(normal);

        //when
        boolean expected = page.validationCheck();

        //then
        Assertions.assertThat(expected).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 400})
    @DisplayName("시작면과 끝면이 나오는 페이지가 나오는 테스트 -> false값 반환")
    public void 페이지_초과_경계값_테스트(int error) {
        //given
        Page page = new Page(error);

        //when
        boolean expected = page.validationCheck();

        //then
        Assertions.assertThat(expected).isFalse();
    }
}