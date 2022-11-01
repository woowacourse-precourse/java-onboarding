package onboarding.problem1.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PageTest {
    private Page page;
    
    @BeforeEach
    void setUp() {
        page = new Page(236);
    }
    
    @Test
    @DisplayName("숫자의 각 자릿수 합 구하기")
    void sumOfDigits() {
        assertThat(page.sumOfDigits()).isEqualTo(11);
    }
    
    @Test
    @DisplayName("숫자의 각 자릿수 곱하기 구하기")
    void multiplyOfDigits() {
        assertThat(page.multiplyOfDigits()).isEqualTo(36);
    }
    
    @Test
    @DisplayName("홀수가 아닌지 확인")
    void isNotOdd() {
        assertThat(page.isNotOdd()).isTrue();
    }
    
    @Test
    @DisplayName("짝수가 아닌지 확인")
    void isNotEven() {
        assertThat(page.isNotEven()).isFalse();
    }
    
    @Test
    @DisplayName("두 페이지 차이가 1이 아닌지 확인")
    void isDifferenceNotOne() {
        assertAll(
                () -> assertThat(page.isDifferenceNotOne(new Page(238))).isTrue(),
                () -> assertThat(page.isDifferenceNotOne(new Page(237))).isFalse()
        );
    }
    
    @Test
    @DisplayName("왼쪽 페이지가 더 큰지 확인")
    void isBigger() {
        assertAll(
                () -> assertThat(page.isBigger(new Page(235))).isTrue(),
                () -> assertThat(page.isBigger(new Page(237))).isFalse()
        );
    }
    
    @DisplayName("페이지 범위 벗어났는지 확인")
    @ParameterizedTest(name = "{displayName} : page = {0}, result = {1}")
    @CsvSource(value = {"1, true", "2, true", "399, true", "400, true", "3, false", "4, false", "397, false", "398, false"})
    void isExceededRange(int page, boolean result) {
        assertThat(new Page(page).isExceededRange()).isEqualTo(result);
    }
}
