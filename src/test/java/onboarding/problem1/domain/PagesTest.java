package onboarding.problem1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PagesTest {
    @Test
    @DisplayName("가장 큰 더하기 숫자 구하기")
    void getMaxSum() {
        Pages pages = new Pages("237", "238");
        assertThat(pages.getMaxSum()).isEqualTo(13);
    }
}
