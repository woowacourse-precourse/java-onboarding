package onboarding.problem1;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PageNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "-1"})
    void 페이지번호는_1번페이지와_그보다_작은값을_가질_수_없습니다(final String input) {
        assertThatThrownBy(() -> {
            int number = Integer.parseInt(input);
            new PageNumber(number);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(PageNumber.PAGE_NUMBER_IS_LESS_THAN_MIN_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(strings = {"400", "401", "402"})
    void 페이지번호는_400페이지와_그보다_큰_수를_가질_수_없습니다(final String input) {
        assertThatThrownBy(() -> {
            int number = Integer.parseInt(input);
            new PageNumber(number);
        }).isInstanceOf(IllegalArgumentException.class)
          .hasMessageContaining(PageNumber.PAGE_NUMBER_MORE_THAN_MAX_NUMBER);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:2", "11:2", "13:4", "101:2"}, delimiterString = ":")
    void 페이지번호가_생성자를_통해_주입받은_후_각_자릿수를_모두_더한다(final String input, final String result) {

        var pageNumber = new PageNumber(Integer.parseInt(input));
        var actual     = pageNumber.sum();

        assertThat(actual).isEqualTo(Integer.parseInt(result));
    }

    @ParameterizedTest
    @CsvSource(value = {"2:2", "10:0", "101:0", "111:1", "123:6"}, delimiterString = ":")
    void 페이지_번호가_생성자를_통해_주입받은_후_각_자릿수를_모두_곱한다(final String input, final String result) {
        var pageNumber = new PageNumber(Integer.parseInt(input));
        var actual     = pageNumber.multiple();

        assertThat(actual).isEqualTo(Integer.parseInt(result));
    }
}