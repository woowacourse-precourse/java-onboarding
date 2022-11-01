package onboarding.problem1.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PageTest {

    @Test
    void create() {
        Page actual = new Page(3, 4);

        assertThat(actual).isEqualTo(new Page(3, 4));
    }

    @DisplayName("오른쪽 페이지 번호에서 왼쪽 페이지 번호를 뺀 값이 1이 아니면 IllegalArgumentException 에외를 throw 한다.")
    @Test
    void valid_sequence() {
        assertThatThrownBy(() -> new Page(99, 102)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 이하혹은 400이상의 숫자가 포함되면 IllegalArgumentException 예외를 throw 한다.")
    @Test
    void valid_page_bound() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new Page(1, 2)).isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Page(399, 400)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest(name = "각 자리의 숫자를 모두 더한다")
    @CsvSource(value = {"3:3", "34:7", "236:11"}, delimiter = ':')
    void add_each_digit(int number, int result) {
        Page page = new Page(3, 4);

        assertThat(page.addEachDigit(number)).isEqualTo(result);
    }

    @ParameterizedTest(name = "각 자리의 숫자를 모두 곱한다")
    @CsvSource(value = {"3:3", "34:12", "236:36", "340:0"}, delimiter = ':')
    void multiply_each_digit(int number, int result) {
        Page page = new Page(3, 4);

        assertThat(page.multiplyEachDigit(number)).isEqualTo(result);
    }

    @ParameterizedTest(name = "각 자리의 숫자를 모두 더한값과 모두 곱한값 중 큰 값을 반환한다.")
    @CsvSource(value = {"3:3:3", "34:7:12", "211:4:2", "340:7:0"}, delimiter = ':')
    void multiply_each_digit(int number, int addValue, int multiplyValue) {
        Page page = new Page(3, 4);

        assertThat(page.maxAddAndMultiplyEachDigit(number)).isEqualTo(Math.max(addValue, multiplyValue));
    }

    @ParameterizedTest(name = "왼쪽 페이지와 오른쪽 페이지 각 자리의 숫자를 모두 더한값과 모두 곱한값 중 가증 큰 값을 반환한다.")
    @CsvSource(value = {"3:4:4", "9:10:9", "211:212:5", "339:340:81"}, delimiter = ':')
    void max_score(int left, int right, int expected) {
        Page page = new Page(left, right);

        assertThat(page.maxScore()).isEqualTo(expected);
    }
}
