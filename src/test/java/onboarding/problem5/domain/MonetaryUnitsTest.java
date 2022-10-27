package onboarding.problem5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MonetaryUnitsTest {
    @Test
    @DisplayName("오만원 권 개수 구하기")
    void fiftyThousandDivide() {
        assertThat(MonetaryUnits.FIFTY_THOUSAND.divide(100001)).isEqualTo(2);
    }
    
    @Test
    @DisplayName("만원 권 개수 구하기")
    void tenThousandDivide() {
        assertThat(MonetaryUnits.TEN_THOUSAND.divide(40001)).isEqualTo(4);
    }
}
