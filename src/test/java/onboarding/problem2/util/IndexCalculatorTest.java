package onboarding.problem2.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IndexCalculatorTest {
    @Test
    @DisplayName("연속하는 중복 문자 시작 위치 구하기")
    void overlapStartIndex() {
        assertThat(IndexCalculator.overlapStartIndex(0, "zyellleyz".split(""))).isEqualTo(3);
    }
    
    @Test
    @DisplayName("연속하는 중복 문자 끝 위치 구하기")
    void overlapEndIndex() {
        assertThat(IndexCalculator.overlapEndIndex(3, "zyellleyz".split(""))).isEqualTo(6);
    }
}