package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("올바르지 않은 페이지 검증 단위테스트")
class PageValidatorTest {
    @DisplayName("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이면 true를 반환한다.")
    @Test
    void leftOddAndRightEven() {
        List<Integer> pages = List.of(1, 2);

        boolean result = PageValidator.validate(pages);

        assertThat(result).isTrue();
    }

    @DisplayName("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호가 아니면 false를 반환한다.")
    @CsvSource(value = {"1:1", "2:2", "2:3"}, delimiter = ':')
    @ParameterizedTest
    void notLeftOddAndRightEven(int left, int right) {
        List<Integer> pages = List.of(left, right);

        boolean result = PageValidator.validate(pages);

        assertThat(result).isFalse();
    }

    @DisplayName("페이지가 연속적이면 true를 반환한다.")
    @Test
    void continuous() {
        List<Integer> pages = List.of(1, 2);

        boolean result = PageValidator.validate(pages);

        assertThat(result).isTrue();
    }

    @DisplayName("페이지가 연속적이지 않으면 false를 반환한다.")
    @Test
    void notContinuous() {
        List<Integer> pages = List.of(1, 3);

        boolean result = PageValidator.validate(pages);

        assertThat(result).isFalse();
    }

    @DisplayName("페이지의 범위가 1이상 400이하면 true를 반환한다.")
    @CsvSource(value = {"1:2", "399:400"}, delimiter = ':')
    @ParameterizedTest
    void notOutOfRange(int left, int right) {
        List<Integer> pages = List.of(left, right);

        boolean result = PageValidator.validate(pages);

        assertThat(result).isTrue();
    }

    @DisplayName("페이지의 범위가 1이상 400이하면 true를 반환한다.")
    @CsvSource(value = {"0:1", "400:401"}, delimiter = ':')
    @ParameterizedTest
    void outOfRange(int left, int right) {
        List<Integer> pages = List.of(left, right);

        boolean result = PageValidator.validate(pages);

        assertThat(result).isFalse();
    }

    @DisplayName("두 페이지면 true를 반환한다.")
    @Test
    void twoPages() {
        List<Integer> pages = List.of(1, 2);

        boolean result = PageValidator.validate(pages);

        assertThat(result).isTrue();
    }

    @DisplayName("두 페이지가 아니면 false를 반환한다.")
    @MethodSource("notTowPagesData")
    @ParameterizedTest
    void notTwoPages(List<Integer> pages) {
        boolean result = PageValidator.validate(pages);

        assertThat(result).isFalse();
    }

    @DisplayName("페이지가 null이면 false를 반환한다.")
    @Test
    void nullPages() {
        boolean result = PageValidator.validate(null);

        assertThat(result).isFalse();
    }

    static Stream<Arguments> notTowPagesData() {
        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2, 3))
        );
    }
}
