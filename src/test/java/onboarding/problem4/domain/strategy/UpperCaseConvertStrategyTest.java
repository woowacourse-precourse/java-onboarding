package onboarding.problem4.domain.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UpperCaseConvertStrategyTest {
    @Test
    @DisplayName("대문자 변환하기")
    void convertUpperCase() {
        assertThat(new UpperCaseConvertStrategy().convert('A')).isEqualTo('Z');
    }
}