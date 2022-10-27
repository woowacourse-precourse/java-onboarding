package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PageTest {
    @Test
    @DisplayName("숫자의 각 자릿수 합 구하기")
    void sumOfDigits() {
        Page page = new Page(236);
        assertThat(page.sumOfDigits()).isEqualTo(11);
    }
    
    @Test
    @DisplayName("숫자의 각 자릿수 곱하기 구하기")
    void multiplyOfDigits() {
        Page page = new Page(236);
        assertThat(page.multiplyOfDigits()).isEqualTo(36);
    }
}
