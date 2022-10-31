package onboarding.problem1;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PageTest {

    @ParameterizedTest
    @ValueSource(strings = {"2", "4", "6"})
    void 왼쪽페이지는_홀수만_들어갈_수_있습니다(final String input) {
        assertThatThrownBy(() -> {
            Page leftPage = new LeftPage(Integer.parseInt(input));
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(LeftPage.LEFT_PAGE_NUMBER_IS_NOT_EVEN);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "5", "7"})
    void 오른쪽_페이지는_짝수만_들어갈_수_있습니다(final String input) {
        assertThatThrownBy(() -> {
            Page rightPage = new RightPage(Integer.parseInt(input));
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(RightPage.RIGHT_PAGE_NUMBER_IS_NOT_EVEN);
    }

}
