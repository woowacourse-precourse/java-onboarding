package onboarding.problem4.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LowerCaseConvertStrategyTest {
    @Test
    @DisplayName("소문자 변환하기")
    void convertLowerCase() {
        assertThat(new LowerCaseConvertStrategy().convert('a')).isEqualTo('z');
    }
}